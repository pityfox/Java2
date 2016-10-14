package banque.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import banque.model.Client;
import banque.model.ClientCompte;

@Component
public class ClientDaoJpa implements ClientDao {
	
	@Autowired
	private EntityManagerFactory entityManagerFactory;

	@Autowired
	@Qualifier("clientCompteDaoJpa")
	private ClientCompteDao clientCompteDao;

	@Override
	public Client find(Long id) {
		Client client = null;
		EntityManager em = null;
		EntityTransaction tx = null;
		try {
			em = entityManagerFactory.createEntityManager();
			tx = em.getTransaction();

			tx.begin();

			client = em.find(Client.class, id);

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

		return client;
	}

	@Override
	public List<Client> findAll() {
		List<Client> clients = new ArrayList<Client>();
		EntityManager em = null;
		EntityTransaction tx = null;
		try {
			em = entityManagerFactory.createEntityManager();
			tx = em.getTransaction();

			tx.begin();

			Query query = em.createQuery("select c from Client c");
			clients = query.getResultList();

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
		return clients;
	}

	@Override
	public void create(Client obj) {
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
	public Client update(Client obj) {
		Client client = null;
		EntityManager em = null;
		EntityTransaction tx = null;
		try {
			em = entityManagerFactory.createEntityManager();
			tx = em.getTransaction();

			tx.begin();

			client = em.merge(obj);

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
		return client;
	}

	@Override
	public void delete(Client obj) {
		EntityManager em = null;
		EntityTransaction tx = null;
		try {
			em = entityManagerFactory.createEntityManager();
			tx = em.getTransaction();

			tx.begin();
			
			obj = em.merge(obj);
			
			for(ClientCompte clientCompte : obj.getComptes()) {
				clientCompteDao.delete(clientCompte);
			}

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
	public List<Client> findAllByName(String name) {
		List<Client> clients = new ArrayList<Client>();
		EntityManager em = null;
		EntityTransaction tx = null;
		try {
			em = entityManagerFactory.createEntityManager();
			tx = em.getTransaction();

			tx.begin();

			Query query = em.createQuery("select c from Client c where c.nom = :monNom");
			query.setParameter("monNom", name);
			clients = query.getResultList();

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
		return clients;
	}

}
