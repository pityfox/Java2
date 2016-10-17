package banque.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import banque.model.Compte;

@Repository
public class CompteDaoJpa implements CompteDao {

	@Autowired
	private EntityManagerFactory entityManagerFactory;
	
	@Override
	public Compte find(String id) {
		Compte compte = null;
		EntityManager em = null;
		EntityTransaction tx = null;
		try {
			em = entityManagerFactory.createEntityManager();
			tx = em.getTransaction();

			tx.begin();

			compte = em.find(Compte.class, id);
			
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			if (em != null) {
				em.close();
			}
		}
		return compte;
	}

	@Override
	public List<Compte> findAll() {
		List<Compte> comptes = new ArrayList<Compte>();
		EntityManager em = null;
		EntityTransaction tx = null;
		try {
			em = entityManagerFactory.createEntityManager();
			tx = em.getTransaction();

			tx.begin();

			Query query = em.createQuery("select c from Compte c");
			comptes = query.getResultList();
			
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			if (em != null) {
				em.close();
			}
		}
		return comptes;
	}

	@Override
	public void create(Compte obj) {
		EntityManager em = null;
		EntityTransaction tx = null;
		try {
			em = entityManagerFactory.createEntityManager();
			tx = em.getTransaction();

			tx.begin();

			em.persist(obj);
			
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	@Override
	public Compte update(Compte obj) {
		Compte compte = null;
		EntityManager em = null;
		EntityTransaction tx = null;
		try {
			em = entityManagerFactory.createEntityManager();
			tx = em.getTransaction();

			tx.begin();

			compte = em.merge(obj);
			
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			if (em != null) {
				em.close();
			}
		}
		return compte;
	}

	@Override
	public void delete(Compte obj) {
		EntityManager em = null;
		EntityTransaction tx = null;
		try {
			em = entityManagerFactory.createEntityManager();
			tx = em.getTransaction();

			tx.begin();

			em.remove(obj);
			
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	@Override
	public <T> List<?> findAllByType(Class<? extends Compte> clazz) {
		List<Compte> comptes = new ArrayList<Compte>();
		EntityManager em = null;
		EntityTransaction tx = null;
		try {
			em = entityManagerFactory.createEntityManager();
			tx = em.getTransaction();

			tx.begin();

			Query query = em.createQuery("select c from " + clazz.getSimpleName() +" c");
			comptes = query.getResultList();
			
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			if (em != null) {
				em.close();
			}
		}
		return comptes;
	}


}
