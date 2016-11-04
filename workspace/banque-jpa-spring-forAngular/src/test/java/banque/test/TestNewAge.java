package banque.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import banque.dao.ClientDao;
import banque.model.Adresse;
import banque.model.Client;
import banque.model.Titre;

// à partir de la v4.x
public class TestNewAge {
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	private static ClassPathXmlApplicationContext context = null;
	private static ClientDao clientDao = null;

	@BeforeClass
	public static void init() {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		clientDao = context.getBean(ClientDao.class);
	}
	
	@AfterClass
	public static void destroy() {
		context.close();
	}
	
	@Test
	public void client() throws ParseException {
		Client client = new Client("DUPONT", "Jean"); // new
		client.setDtNaissance(sdf.parse("04/10/1916"));
		client.setCommentaire("mon commentaire");
		client.setTitre(Titre.M);
		client.setAdr(new Adresse("1 rue de la paix", "75001", "Paris"));

		clientDao.create(client);

		Client clientFind = clientDao.find(client.getId());

		Assert.assertEquals("DUPONT", clientFind.getNom());
		Assert.assertEquals("Jean", clientFind.getPrenom());
		Assert.assertEquals(sdf.parse("04/10/1916"), clientFind.getDtNaissance());
		Assert.assertEquals("mon commentaire", clientFind.getCommentaire());
		Assert.assertEquals(Titre.M, clientFind.getTitre());
		Assert.assertEquals("1 rue de la paix", clientFind.getAdr().getRue());
		Assert.assertEquals("75001", clientFind.getAdr().getCodePostal());
		Assert.assertEquals("Paris", clientFind.getAdr().getVille());

		clientFind.setNom("DUPOND");
		clientFind.setPrenom("Jeanne");
		clientFind.setTitre(Titre.MME);
		clientFind.getAdr().setRue("18 rue de la paix");

		clientDao.update(clientFind);

		clientFind = clientDao.find(clientFind.getId());

		Assert.assertEquals("DUPOND", clientFind.getNom());
		Assert.assertEquals("Jeanne", clientFind.getPrenom());
		Assert.assertEquals(Titre.MME, clientFind.getTitre());
		Assert.assertEquals("18 rue de la paix", clientFind.getAdr().getRue());

		clientDao.delete(clientFind);

		clientFind = clientDao.find(clientFind.getId());

		// if(clientFind != null) {
		// Assert.fail("ClientFind n'est pas null : problème de suppression");
		// }

		Assert.assertNull("ClientFind n'est pas null : problème de suppression", clientFind);
	}
	
	@Test
	public void compte() {
		
	}
}
