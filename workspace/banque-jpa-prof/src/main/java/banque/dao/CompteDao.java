package banque.dao;

import java.util.List;

import banque.model.Compte;

public interface CompteDao extends Dao<Compte, String>{
	List<Compte> findAllByType(String type);
}
