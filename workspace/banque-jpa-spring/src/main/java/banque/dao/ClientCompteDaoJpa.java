package banque.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import banque.model.ClientCompte;
import banque.model.ClientCompteId;

@Component
public class ClientCompteDaoJpa implements ClientCompteDao {

	@Autowired
	private EntityManagerFactory entityManagerFactory;
	
	@Override
	public ClientCompte find(ClientCompteId id) {
		ClientCompte clientCompte = null;
		EntityManager em = null;
		EntityTransaction tx = null;
		try {
			em = entityManagerFactory.createEntityManager();
			tx = em.getTransaction();

			tx.begin();

			clientCompte = em.find(ClientCompte.class, id);

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
		return clientCompte;
	}

	@Override
	public List<ClientCompte> findAll() {
		List<ClientCompte> clientComptes = new ArrayList<ClientCompte>();
		EntityManager em = null;
		EntityTransaction tx = null;
		try {
			em = entityManagerFactory.createEntityManager();
			tx = em.getTransaction();

			tx.begin();

			Query query = em.createQuery("select cc from ClientCompte cc");
			clientComptes = query.getResultList();

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
		return clientComptes;
	}

	@Override
	public void create(ClientCompte obj) {
		EntityManager em = null;
		EntityTransaction tx = null;
		try {
			em = entityManagerFactory.createEntityManager();
			tx = em.getTransaction();

			tx.begin();

			obj.setClient(em.merge(obj.getClient()));
			obj.setCompte(em.merge(obj.getCompte()));
			
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
	public ClientCompte update(ClientCompte obj) {
		ClientCompte clientCompte = null;
		EntityManager em = null;
		EntityTransaction tx = null;
		try {
			em = entityManagerFactory.createEntityManager();
			tx = em.getTransaction();

			tx.begin();

			clientCompte = em.merge(obj);

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
		return clientCompte;
	}

	@Override
	public void delete(ClientCompte obj) {
		EntityManager em = null;
		EntityTransaction tx = null;
		try {
			em = entityManagerFactory.createEntityManager();
			tx = em.getTransaction();

			tx.begin();

			em.remove(em.merge(obj));

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
