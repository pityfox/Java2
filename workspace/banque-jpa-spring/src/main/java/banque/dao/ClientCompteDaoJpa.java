package banque.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import banque.model.ClientCompte;
import banque.model.ClientCompteId;

@Repository
@Transactional
public class ClientCompteDaoJpa implements ClientCompteDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	@Transactional(readOnly = true)
	public ClientCompte find(ClientCompteId id) {
		return em.find(ClientCompte.class, id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ClientCompte> findAll() {
		Query query = em.createQuery("select cc from ClientCompte cc");
		return query.getResultList();
	}

	@Override
	public void create(ClientCompte obj) {
		obj.setClient(em.merge(obj.getClient()));
		obj.setCompte(em.merge(obj.getCompte()));
		em.persist(obj);
	}

	@Override
	public ClientCompte update(ClientCompte obj) {
		return em.merge(obj);
	}

	@Override
	public void delete(ClientCompte obj) {
		em.remove(em.merge(obj));
	}

}
