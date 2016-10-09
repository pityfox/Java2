package banque.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import banque.Application;
import banque.model.ClientCompte;
import banque.model.ClientCompteId;

public class ClientCompteDaoJpa implements ClientCompteDao {

	@Override
	public ClientCompte find(ClientCompteId id) {
		ClientCompte clientCompte = null;
		EntityManager em = null;
		EntityTransaction tx = null;
		try {
			em = Application.getInstance().getEmf().createEntityManager();
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
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();

			tx.begin();

			Query query = em.createQuery("select c from ClientCompte c");
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
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();

			tx.begin();
			
			// Problem avec l'ID class qui fait que hibernate
			// tente de persist Client et Compte, qui sont alors détachés
			// Utiliser EMBEDDED
			// ICI la résolution est de merge chaque objet pour les rattacher :
			// ClientCompte obj2 = em.merge(obj); // Trop bourrin
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
			em = Application.getInstance().getEmf().createEntityManager();
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
			em = Application.getInstance().getEmf().createEntityManager();
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
	public List<ClientCompte> findAllByName(String name) {
		List<ClientCompte> clientComptes = new ArrayList<ClientCompte>();
		EntityManager em = null;
		EntityTransaction tx = null;
		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();

			tx.begin();

			Query query = em.createQuery("select cc from ClientCompte cc where cc.client = 'select c from Client c where c.nom = :monNom'");
			query.setParameter("monNom", name);
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
	
}
