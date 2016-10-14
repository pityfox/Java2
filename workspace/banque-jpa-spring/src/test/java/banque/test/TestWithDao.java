//package banque.test;
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//import banque.Application;
//import banque.dao.AgenceDao;
//import banque.dao.AgenceDaoJpa;
//import banque.dao.ClientCompteDao;
//import banque.dao.ClientCompteDaoJpa;
//import banque.dao.ClientDao;
//import banque.dao.ClientDaoJpa;
//import banque.dao.CompteDao;
//import banque.dao.CompteDaoJpa;
//import banque.model.Adresse;
//import banque.model.Agence;
//import banque.model.Client;
//import banque.model.ClientCompte;
//import banque.model.CompteCheque;
//import banque.model.Titre;
//
//public class TestWithDao {
//
//	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//
//	public static void main(String[] args) throws ParseException {
//		AgenceDao agenceDao = new AgenceDaoJpa();
//		ClientDao clientDao = new ClientDaoJpa();
//		ClientCompteDao clientCompteDao = new ClientCompteDaoJpa();
//		CompteDao compteDao = new CompteDaoJpa();
//
//		CompteCheque cptJoint = new CompteCheque("05151500");
//		cptJoint.setDtOuverture(new Date());
//		cptJoint.setSolde(100);
//		cptJoint.setJoint(true);
//		cptJoint.setDecouvert(1000);
//		compteDao.create(cptJoint);
//
//		cptJoint.setJoint(false);
//
//		cptJoint = (CompteCheque) compteDao.update(cptJoint);	
//
//		Client dupont = new Client("DUPONT", "Jean"); // new
//		dupont.setDtNaissance(sdf.parse("04/10/1916"));
//		dupont.setCommentaire("mon commentaire");
//		dupont.setTitre(Titre.M);
//		dupont.setAdr(new Adresse("1 rue de la paix", "75001", "Paris"));
//		clientDao.create(dupont);
//
//		Agence bnpBourse = new Agence(30004, 1425);
//		bnpBourse.setLibelle("BNP Bourse");
//		bnpBourse.setHoraires("Jamais ouvert");
//		bnpBourse.setAdresse(new Adresse("1 place de la bourse", "75002", "Paris"));
//		agenceDao.create(bnpBourse);
//
//		dupont.setAgence(bnpBourse);
//
//		dupont = clientDao.update(dupont);
//
//		Client durand = new Client("DURAND", "Super"); // new
//		durand.setDtNaissance(sdf.parse("04/10/1916"));
//		durand.setCommentaire("mon commentaire");
//		durand.setTitre(Titre.MME);
//		durand.setAdr(new Adresse("1 rue de la paix", "75001", "Paris"));
//		durand.setAgence(bnpBourse);
//
//		clientDao.create(durand);
//
//		clientCompteDao.create(new ClientCompte(dupont, cptJoint));
//		clientCompteDao.create(new ClientCompte(durand, cptJoint));
//
//		Application.close();
//
//	}
//
//}
