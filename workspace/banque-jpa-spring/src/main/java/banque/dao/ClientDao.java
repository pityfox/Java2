package banque.dao;

import java.util.List;

import banque.model.Client;
import banque.model.Titre;

public interface ClientDao extends Dao<Client, Long>{
	List<Client> findAllByName(String name);
	Client find(String nom, String prenom);
	List<Client> findByTitle(Titre titre); 
	List<Client> findByCity(String ville); 
	List<Client> findByYear(int annee); 
	List<Object[]> findAllWithAgency();
	List<Client> findByCityAgency(String ville);
}
