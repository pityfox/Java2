package banque.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import banque.model.Client;
import banque.model.ClientCompte;
import banque.model.Titre;

@Repository
@Transactional
public class ClientDaoJpa implements ClientDao {

	@PersistenceContext
	private EntityManager em;

	@Autowired
	@Qualifier("clientCompteDaoJpa")
	private ClientCompteDao clientCompteDao;

	@Override
	@Transactional(readOnly = true)
	public Client find(Long id) {
		return em.find(Client.class, id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Client> findAll() {
		Query query = em.createQuery("select c from Client c");
		return query.getResultList();
	}

	@Override
	public void create(Client obj) {
		em.persist(obj);
	}

	@Override
	public Client update(Client obj) {
		return em.merge(obj);
	}

	@Override
	public void delete(Client obj) {
		obj = em.merge(obj);

		for (ClientCompte clientCompte : obj.getComptes()) {
			clientCompteDao.delete(clientCompte);
		}

		em.remove(obj);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Client> findAllByName(String name) {
		Query query = em.createQuery("select c from Client c where c.nom = :monNom");
		query.setParameter("monNom", name);
		return query.getResultList();
	}

	@Override
	public Client find(String nom, String prenom) {
		Query query = em.createQuery("select c from Client c where c.nom = :nom and c.prenom = :prenom");
		query.setParameter("nom", nom);
		query.setParameter("prenom", prenom);
		List<Client> clients = query.getResultList();
		return clients.size() > 0 ? clients.get(0) : null;
	}

	@Override
	public List<Client> findByTitle(Titre titre) {
		Query query = em.createQuery("select c from Client c where c.titre = :titre");
		query.setParameter("titre", titre);
		return query.getResultList();
	}

	@Override
	public List<Client> findByCity(String ville) {
		Query query = em.createQuery("select c from Client c where c.adr.ville = :ville");
		query.setParameter("ville", ville);
		return query.getResultList();
	}

//	@Override
//	public List<Client> findByYear(int annee) {
//		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//		Query query = null;
//		try {
//			query = em.createQuery("select c from Client c where c.dtNaissance between :dtDebut and :dtFin");
//			query.setParameter("dtDebut", sdf.parse("01/01/" + annee));
//			query.setParameter("dtFin", sdf.parse("31/12/" + annee));
//		} catch (ParseException e) {
//
//		}
//		return query.getResultList();
//	}
	
	public List<Client> findByYear(int annee) {
		Query query = em.createQuery("select c from Client c where year(c.dtNaissance) = :annee");
		query.setParameter("annee", annee);
		
		return query.getResultList();
	}

	@Override
	public List<Object[]> findAllWithAgency() {
//		Query query = em.createQuery("select c, a from Client c join c.agence a");
		Query query = em.createQuery("select c, c.agence from Client c");
		
		return query.getResultList();
	}

	@Override
	public List<Client> findByCityAgency(String ville) {
		Query query = em.createQuery("select c, c.agence from Client c where c.agence.adresse.ville = :ville");
		query.setParameter("ville", ville);
		
		return query.getResultList();	
	}

}
