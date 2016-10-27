package banque.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import banque.model.Agence;
import banque.model.AgenceId;

@Repository
@Transactional
public class AgenceDaoJpa implements AgenceDao {

	@PersistenceContext
	private EntityManager em;

	@Autowired
	private ClientDao clientDao;

	public AgenceDaoJpa(ClientDao clientDao) {
		super();
		this.clientDao = clientDao;
	}

	@Override
	@Transactional(readOnly = true)
	public Agence find(AgenceId id) {
		return em.find(Agence.class, id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Agence> findAll() {
		Query query = em.createQuery("select a from Agence a");
		return query.getResultList();
	}

	@Override
	public void create(Agence obj) {
		em.persist(obj);
	}

	@Override
	public Agence update(Agence obj) {
		return em.merge(obj);
	}

	@Override
	public void delete(Agence obj) {
		em.remove(em.merge(obj));
	}

}
