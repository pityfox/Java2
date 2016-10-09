package banque.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import banque.Application;
import banque.dao.AgenceDao;
import banque.dao.AgenceDaoJpa;
import banque.dao.ClientCompteDao;
import banque.dao.ClientCompteDaoJpa;
import banque.dao.ClientDao;
import banque.dao.ClientDaoJpa;
import banque.dao.CompteDao;
import banque.dao.CompteDaoJpa;
import banque.model.Adresse;
import banque.model.Agence;
import banque.model.Client;
import banque.model.ClientCompte;
import banque.model.Compte;
import banque.model.CompteCheque;
import banque.model.Pret;
import banque.model.Titre;

public class TestWithDao {

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public static void main(String[] args) throws ParseException {
		// Creation agences
		Agence bnpBourse = new Agence(30004, 1425);
		bnpBourse.setLibelle("BNP Bourse");
		bnpBourse.setHoraires("Jamais ouvert");
		bnpBourse.setAdresse(new Adresse("1 place de la bourse", "75002", "Paris"));


		// Creation Comptes
		CompteCheque cptJoint = new CompteCheque("05151500");
		cptJoint.setDtOuverture(new Date());
		cptJoint.setSolde(100);
		cptJoint.setJoint(true);
		cptJoint.setDecouvert(1000);

		Pret cptPret = new Pret("456789");
		cptPret.setDtOuverture(new Date());
		cptPret.setSolde(100);
		cptPret.setJoint(false);
		cptPret.setNbEcheances(6);
		cptPret.setTaux(1.5f);

		// Creation Clients
		Client dupont = new Client("DUPONT", "Jean"); // new
		dupont.setDtNaissance(sdf.parse("04/10/1916"));
		dupont.setCommentaire("mon commentaire");
		dupont.setTitre(Titre.M);
		dupont.setAdr(new Adresse("1 rue de la paix", "75001", "Paris"));
		//dupont.setAgence(bnpBourse);

		Client durand = new Client("DURAND", "Super"); // new
		durand.setDtNaissance(sdf.parse("04/10/1916"));
		durand.setCommentaire("mon commentaire");
		durand.setTitre(Titre.MME);
		durand.setAdr(new Adresse("1 rue de la paix", "75001", "Paris"));

		// Ajout des clients aux banques
		bnpBourse.addClient(dupont);
		bnpBourse.addClient(durand);





		// PERSISTENCE  --  Enregistrement en base
		AgenceDao agenceDao = new AgenceDaoJpa(); // Instances connexion et EMF
		agenceDao.create(bnpBourse);

		CompteDao compteDao = new CompteDaoJpa();
		compteDao.create(cptJoint);
		compteDao.create(cptPret);

		ClientDao clientDao = new ClientDaoJpa();
		clientDao.create(dupont);
		clientDao.create(durand);

		// Test Update
		dupont.setAgence(bnpBourse);
		dupont = clientDao.update(dupont); // Attention a bien recup l'objet à
		// jour pour pouvoir continuer a travailler dessus
				
		// Ajout des comptes aux clients
		ClientCompteDao clientCompteDao = new ClientCompteDaoJpa();
		clientCompteDao.create(new ClientCompte(dupont,cptJoint));
		clientCompteDao.create(new ClientCompte(durand,cptJoint));

		
		
		// Test des find()
		//		List<Compte> comptesPret = compteDao.findAllByType("Pret");
		//		System.out.println(comptesPret);

		//		Compte cpt = compteDao.find("456789");
		//		System.out.println(cpt.toString());
		//		
		//		Application.close();

	}

}
