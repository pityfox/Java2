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

import banque.model.Agence;
import banque.model.AgenceId;

@Repository
public class AgenceDaoJpa implements AgenceDao {

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	@Autowired
	private ClientDao clientDao;

	public AgenceDaoJpa(ClientDao clientDao) {
		super();
		this.clientDao = clientDao;
	}

	@Override
	public Agence find(AgenceId id) {
		Agence agence = null;
		EntityManager em = null;
		EntityTransaction tx = null;
		try {
			em = entityManagerFactory.createEntityManager();
			tx = em.getTransaction();

			tx.begin();

			agence = em.find(Agence.class, id);

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
		return agence;
	}

	@Override
	public List<Agence> findAll() {
		List<Agence> agences = new ArrayList<Agence>();
		EntityManager em = null;
		EntityTransaction tx = null;
		try {
			em = entityManagerFactory.createEntityManager();
			tx = em.getTransaction();

			tx.begin();

			Query query = em.createQuery("select a from Agence a");
			agences = query.getResultList();

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
		return agences;
	}

	@Override
	public void create(Agence obj) {
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
	public Agence update(Agence obj) {
		Agence agence = null;
		EntityManager em = null;
		EntityTransaction tx = null;
		try {
			em = entityManagerFactory.createEntityManager();
			tx = em.getTransaction();

			tx.begin();

			agence = em.merge(obj);

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
		return agence;
	}

	@Override
	public void delete(Agence obj) {
		EntityManager em = null;
		EntityTransaction tx = null;
		try {
			em = entityManagerFactory.createEntityManager();
			tx = em.getTransaction();

			tx.begin();
			obj = em.merge(obj);
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

}
