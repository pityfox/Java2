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

import banque.model.Compte;

@Repository
@Transactional
public class CompteDaoJpa implements CompteDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	@Transactional(readOnly = true)
	public Compte find(String id) {
			return em.find(Compte.class, id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Compte> findAll() {
			Query query = em.createQuery("select c from Compte c");
			return query.getResultList();
	}

	@Override
	public void create(Compte obj) {
		em.persist(obj);
	}

	@Override
	public Compte update(Compte obj) {
		return em.merge(obj);
	}

	@Override
	public void delete(Compte obj) {
		em.remove(obj);
	}

	@Override
	@Transactional(readOnly = true)
	public <T> List<?> findAllByType(Class<? extends Compte> clazz) {
		Query query = em.createQuery("select c from " + clazz.getSimpleName() +" c");
		return query.getResultList();
	}


}
