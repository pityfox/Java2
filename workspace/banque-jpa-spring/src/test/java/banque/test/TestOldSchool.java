package banque.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Assert;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import banque.dao.ClientDao;
import banque.model.Adresse;
import banque.model.Client;
import banque.model.Titre;
import junit.framework.TestCase;

// en junit v3.8
public class TestOldSchool extends TestCase {
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private ClassPathXmlApplicationContext context = null;
	private ClientDao clientDao = null;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		clientDao = context.getBean(ClientDao.class);
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		context.close();
	}

	public void testClient() throws ParseException {
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
		
//		if(clientFind != null) {
//			Assert.fail("ClientFind n'est pas null : problème de suppression");
//		}
		
		Assert.assertNull("ClientFind n'est pas null : problème de suppression", clientFind);
	}

	public void testCompte() {
		
	}

}
