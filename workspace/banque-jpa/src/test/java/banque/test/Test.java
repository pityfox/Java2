package banque.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import banque.model.Client;

public class Test {

	public static void main(String[] args) {
		// Déclaration EMF EM TX
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("banque");
		EntityManager em = null;
		EntityTransaction tx = null;
		
		
		// Connexion 1
		try{
			// Ouverture des connexions
			em = emf.createEntityManager();
			tx = em.getTransaction();
			
			// Transaction
			tx.begin();
			
			// Création & Ajout d'un client
			Client dupont = new Client("DUPONT", "Jean"); //new
			Date ddn = new SimpleDateFormat("dd/MM/yyyy").parse("04/10/1916");
			dupont.setDdn(ddn);
			em.persist(dupont); //managed
			
			// Création & Ajout d'une agence
//			Agence bnpBourse = new Agence(30014,1425);
////			bnpBourse.setNumBanque(30004);
////			bnpBourse.setNumAgence(1425);
//			bnpBourse.setLibelle("BNP Bourse");
//			bnpBourse.setHoraires("Jamais ouvert");
//			em.persist(bnpBourse);
			
			// Soumission
			tx.commit();
			
		}catch(Exception e){
			e.printStackTrace();
			// Si ça plante on revient en arrière
			if(tx != null)
				tx.rollback();
		}finally{
			// Dans tous les cas il faut fermer les connexions
			if(em != null)
				em.close();
		}
		
		// Connexion 2
		try{
			// Ouverture des connexions
			em = emf.createEntityManager();
			tx = em.getTransaction();
			
			// Transaction
			tx.begin();
			
			// Soumission
			tx.commit();
			
		}catch(Exception e){
			e.printStackTrace();
			// Si ça plante on revient en arrière
			if(tx != null)
				tx.rollback();
		}finally{
			// Dans tous les cas il faut fermer les connexions
			if(em != null)
				em.close();
		}
		
		// Fermeture EMF
		emf.close();
	}
}
