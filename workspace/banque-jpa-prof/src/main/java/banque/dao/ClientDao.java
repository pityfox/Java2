package banque.dao;

import java.util.List;

import banque.model.Client;

public interface ClientDao extends Dao<Client, Long>{
	List<Client> findAllByName(String name);
}
