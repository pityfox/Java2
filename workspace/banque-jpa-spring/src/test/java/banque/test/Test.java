package banque.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import banque.Application;
import banque.model.Adresse;
import banque.model.Agence;
import banque.model.AgenceId;
import banque.model.Client;
import banque.model.ClientCompte;
import banque.model.Compte;
import banque.model.CompteCheque;
import banque.model.Titre;

public class Test {

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public static void main(String[] args) {
		EntityManagerFactory emf = Application.getInstance().getEmf();

		EntityManager em = null;
		EntityTransaction tx = null;
		try {
			em = emf.createEntityManager();
			tx = em.getTransaction();

			tx.begin();

			CompteCheque cptJoint = new CompteCheque("05151500");
			cptJoint.setDtOuverture(new Date());
			cptJoint.setSolde(100);
			cptJoint.setJoint(true);
			cptJoint.setDecouvert(1000);
			em.persist(cptJoint);
			
			Client dupont = new Client("DUPONT", "Jean"); // new
			dupont.setDtNaissance(sdf.parse("04/10/1916"));
			dupont.setCommentaire("mon commentaire");
			dupont.setTitre(Titre.M);
			dupont.setAdr(new Adresse("1 rue de la paix", "75001", "Paris"));
//			dupont.addCompte(cptJoint);

			Agence bnpBourse = new Agence(30004, 1425);
			bnpBourse.setLibelle("BNP Bourse");
			bnpBourse.setHoraires("Jamais ouvert");
			bnpBourse.setAdresse(new Adresse("1 place de la bourse", "75002", "Paris"));
			em.persist(bnpBourse);

			dupont.setAgence(bnpBourse);

			em.persist(dupont); // managed

			Client durand = new Client("DURAND", "Super"); // new
			durand.setDtNaissance(sdf.parse("04/10/1916"));
			durand.setCommentaire("mon commentaire");
			durand.setTitre(Titre.MME);
			durand.setAdr(new Adresse("1 rue de la paix", "75001", "Paris"));
//			durand.addCompte(cptJoint);
			durand.setAgence(bnpBourse);
			
			em.persist(durand);
			
			em.persist(new ClientCompte(dupont,cptJoint));
			em.persist(new ClientCompte(durand,cptJoint));
			
			bnpBourse.addClient(dupont);
			bnpBourse.addClient(durand);
			
			System.out.println("bnpBourse-1=" + bnpBourse.getClients());

			tx.commit();
			tx.begin();

			em.refresh(bnpBourse);

			System.out.println("bnpBourse-2=" + bnpBourse.getClients());

			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			if (em != null) {
				em.close();
			}
		}

		try {
			em = emf.createEntityManager();
			tx = em.getTransaction();

			tx.begin();

			Agence bnpBourseBis = em.find(Agence.class, new AgenceId(30004, 1425));
			System.out.println("bnpBourse-3=" + bnpBourseBis.getClients());

			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			if (em != null) {
				em.close();
			}
		}

		Application.close();

	}

}
