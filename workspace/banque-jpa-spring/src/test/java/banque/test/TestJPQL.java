package banque.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import banque.dao.ClientDao;
import banque.model.Agence;
import banque.model.Client;
import banque.model.Titre;

public class TestJPQL {
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	public static void main(String[] args) throws ParseException {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ClientDao clientDao = context.getBean(ClientDao.class);
		
//		List<Client> client = clientDao.findAllByName("DURAND");
//		System.out.println(client);
//		
//		Client client2 = clientDao.findByNameSurname("Super", "DURAND");
//		System.out.println(client2);
//		
//		List<Client> client3 = clientDao.findAllByTitle(Titre.MME);
//		System.out.println(client3);
//		
//		List<Client> client4 = clientDao.findAllByCity("Paris");
//		System.out.println(client4);
		
//		List<Client> client5 = clientDao.findAllByYear(1916);
////		System.out.println(client5);
//		for(Client c:client5)
//			System.out.println(c.getAgence());
		
		List<Object[]> client6 = clientDao.findAllWithAgency();
		for(Object[] o:client6){
			Client clicos = (Client) o[0];
			Agence agence = (Agence) o[1];
			System.out.println(clicos);
			System.out.println(agence);
		}
//		List<Client> client7 = clientDao.findAllByAgencyCity("Paris");
//		System.out.println(client7);
		
		
	}

}
