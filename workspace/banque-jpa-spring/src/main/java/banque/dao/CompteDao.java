package banque.dao;

import java.util.List;

import banque.model.Compte;

public interface CompteDao extends Dao<Compte, String>{
	public <T> List<?> findAllByType(Class<? extends Compte> clazz);
}
