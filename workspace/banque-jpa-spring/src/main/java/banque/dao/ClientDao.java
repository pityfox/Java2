package banque.dao;

import java.util.Date;
import java.util.List;

import banque.model.Client;
import banque.model.Titre;

public interface ClientDao extends Dao<Client, Long>{
	List<Client> findAllByName(String name);
	Client findByNameSurname(String name, String surname);
	List<Client> findAllByTitle(Titre titre);
	List<Client> findAllByCity(String city);
	List<Client> findAllByYear(int year);
	List<Object[]> findAllWithAgency();
	List<Client> findAllByAgencyCity(String city);
}
