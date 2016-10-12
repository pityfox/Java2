package banque.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import banque.model.Adresse;
import banque.model.Agence;
import banque.model.AgenceId;
import banque.model.Client;
import banque.model.Compte;
import banque.model.Compte2;
import banque.model.CompteCheque;
import banque.model.CompteClient;
import banque.model.Epargne;
import banque.model.Pret;
import banque.model.Titre;

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




			// Création & Ajout d'une agence
			Agence bnpBourse = em.find(Agence.class, new AgenceId(30014,1425));
			if(bnpBourse == null){
				bnpBourse = new Agence(30014,1425);
	
				//			bnpBourse.setNumBanque(30004);
				//			bnpBourse.setNumAgence(1425);
				bnpBourse.setLibelle("BNP Bourse");
				bnpBourse.setHoraires("Jamais ouvert");
				bnpBourse.setAdresse(new Adresse("rue du troll", "Panam", "45678"));

			}
			
			Agence caIdf = em.find(Agence.class, new AgenceId(1234,5678));
			if(caIdf == null){
				caIdf = new Agence(1234,5678);
	
				//			caIdf.setNumBanque(30004);
				//			caIdf.setNumAgence(1425);
				caIdf.setLibelle("BNP Bourse");
				caIdf.setHoraires("Jamais ouvert");
				caIdf.setAdresse(new Adresse("rue du troll", "Panam", "45678"));

			}

			// Création & Ajout d'un client
			Client dupont = new Client("DUPONT", "Jean"); //new

			Date ddn = new SimpleDateFormat("dd/MM/yyyy").parse("04/10/1916");
			dupont.setDdn(ddn);
			dupont.setCommentaire("Lzeknfjz j hgehz zeg zejghz oengjozenjzgnj");
			dupont.setTitre(Titre.M);
			dupont.setAdresse(new Adresse("rue du lol", "citygang", "1337"));
			dupont.setAgence(bnpBourse);
			
			Client dugenoux = new Client("DUGENOUX", "Truc");
			dugenoux.setAgence(bnpBourse);
			
			Client durand = new Client("DURAND", "Machin");
			durand.setAgence(bnpBourse);
			
			// Creation et ajout de comptes
//			Compte compte1 = new Compte("123", true, 123456);
//			Compte compte2 = new Compte("456", false, 98745);
			
			Epargne compte1 = new Epargne("123",true,1234,2.3f);
			Pret compte2 = new Pret("456",false,4567,1.5f,5);
			CompteCheque compte3 = new CompteCheque("789", true, 7894, 1000);
			
//			durand.addCompte(compte1);
//			durand.addCompte(compte2);
//			dugenoux.addCompte(compte2);
//			dupont.addCompte(compte1);
//			CompteClient link1 = new CompteClient(compte1, durand);
//			CompteClient link2 = new CompteClient(compte2, durand);
//			CompteClient link3 = new CompteClient(compte1, dupont);
//			CompteClient link4 = new CompteClient(compte1, dugenoux);
			
			// Management
			em.persist(bnpBourse);
			em.persist(caIdf);
			em.persist(dupont);
			em.persist(dugenoux);
			em.persist(durand);
			em.persist(compte1);
			em.persist(compte2);
			em.persist(compte3);
//			em.persist(link1);
//			em.persist(link2);
//			em.persist(link3);
//			em.persist(link4);
			
			
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
