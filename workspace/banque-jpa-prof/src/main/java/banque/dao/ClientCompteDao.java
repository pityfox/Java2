package banque.dao;

import java.util.List;

import banque.model.ClientCompte;
import banque.model.ClientCompteId;

public interface ClientCompteDao extends Dao<ClientCompte, ClientCompteId>{
	List<ClientCompte> findAllByName(String name);
}
