package banque.dao;

import java.util.Date;
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
	public Client findByNameSurname(String name, String surname) {
		Query query = em.createQuery("select c from Client c where c.prenom=:name and c.nom=:surname");
		query.setParameter("name", name);
		query.setParameter("surname", surname);
		List<Client> clients = query.getResultList();
		
		return (clients.size() > 0)?clients.get(0):null;
	}

	public List<Client> findAllByTitle(Titre titre){
		Query query = em.createQuery("select c from Client c where c.titre=:title");
		query.setParameter("title", titre);
		return query.getResultList();
	}
	
	public List<Client> findAllByCity(String city){
		Query query = em.createQuery("select c from Client c where c.adr.ville=:city");
		query.setParameter("city", city);
		return query.getResultList();
	}

	@Override
	public List<Client> findAllByYear(int year) {
		Query query = em.createQuery("select c from Client c where YEAR(c.dtNaissance)=:ydate");
		query.setParameter("ydate", year);
		return query.getResultList();
	}

	@Override
	public List<Object[]> findAllWithAgency() {
		Query query = em.createQuery("select c,a from Client c join c.agence a");
		return query.getResultList();
	}

	@Override
	public List<Client> findAllByAgencyCity(String city) {
		Query query = em.createQuery("select c from Client c where c.agence.adresse.ville=:city");
		query.setParameter("city", city);
		return query.getResultList();
	}
	
	
}
