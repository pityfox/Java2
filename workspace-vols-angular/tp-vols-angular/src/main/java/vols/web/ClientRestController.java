package vols.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import vol.metier.dao.ClientDao;
import vol.metier.model.Client;
import vol.metier.model.ClientEI;
import vol.metier.model.ClientMoral;
import vol.metier.model.ClientPhysique;
import vol.metier.model.TitreMoral;
import vol.metier.model.TitrePhysique;

@RestController
public class ClientRestController {

	@Autowired
	private ClientDao clientDao;

	@RequestMapping(value = "/client/", method = RequestMethod.GET)
	public ResponseEntity<List<Client>> listAll() {
		List<Client> clients = clientDao.findAll();
		if (clients == null) {
			return new ResponseEntity<List<Client>>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<Client>>(clients, HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/client/{id}", method = RequestMethod.GET)
	public ResponseEntity<Client> get(@PathVariable("id") Long id) {
		Client client = clientDao.find(id);
		if (client == null) {
			return new ResponseEntity<Client>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Client>(client, HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/client/Physique/", method = RequestMethod.POST)
	public ResponseEntity<Void> create(@RequestBody ClientPhysique client, UriComponentsBuilder ucBuilder) {
		if (client.getId() != null && clientDao.find(client.getId()) != null) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		} else {
			clientDao.create(client);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(ucBuilder.path("/client/{id}").buildAndExpand(client.getId()).toUri());
			return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
		}
	}
	
	@RequestMapping(value = "/client/Moral/", method = RequestMethod.POST)
	public ResponseEntity<Void> create(@RequestBody ClientMoral client, UriComponentsBuilder ucBuilder) {
		if (client.getId() != null && clientDao.find(client.getId()) != null) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		} else {
			clientDao.create(client);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(ucBuilder.path("/client/{id}").buildAndExpand(client.getId()).toUri());
			return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
		}
	}
	
	@RequestMapping(value = "/client/EI/", method = RequestMethod.POST)
	public ResponseEntity<Void> create(@RequestBody ClientEI client, UriComponentsBuilder ucBuilder) {
		if (client.getId() != null && clientDao.find(client.getId()) != null) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		} else {
			clientDao.create(client);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(ucBuilder.path("/client/{id}").buildAndExpand(client.getId()).toUri());
			return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
		}
	}

	@RequestMapping(value = "/client/Physique/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Client> update(@PathVariable("id") Long id, @RequestBody ClientPhysique client) {
		Client clientDb = clientDao.find(id);
		ClientPhysique currentClient = (ClientPhysique) clientDb;
		if (currentClient == null) {
			return new ResponseEntity<Client>(HttpStatus.NOT_FOUND);
		} else {
			currentClient.setTitre(client.getTitre());
			currentClient.setNom(client.getNom());
			currentClient.setPrenom(client.getPrenom());
			System.out.println(client.getPrenom());
			currentClient.setNumeroFax(client.getNumeroFax());
			currentClient.setNumeroTel(client.getNumeroTel());
			currentClient.setEmail(client.getEmail());
			Client currentClient2 = clientDao.update(currentClient);
			currentClient2 = clientDao.find(currentClient2.getId());
			return new ResponseEntity<Client>(currentClient2, HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/client/Moral/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Client> update(@PathVariable("id") Long id, @RequestBody ClientMoral client) {
		Client clientDb = clientDao.find(id);
		ClientMoral currentClient = (ClientMoral) clientDb;
		if (currentClient == null) {
			return new ResponseEntity<Client>(HttpStatus.NOT_FOUND);
		} else {
			currentClient.setTitre(client.getTitre());
			currentClient.setNom(client.getNom());
			currentClient.setNumeroFax(client.getNumeroFax());
			currentClient.setNumeroTel(client.getNumeroTel());
			currentClient.setSiret(client.getSiret());
			currentClient.setEmail(client.getEmail());
			Client currentClient2 = clientDao.update(currentClient);
			currentClient2 = clientDao.find(currentClient2.getId());
			return new ResponseEntity<Client>(currentClient2, HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/client/EI/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Client> update(@PathVariable("id") Long id, @RequestBody ClientEI client) {
		Client clientDb = clientDao.find(id);
		ClientEI currentClient = (ClientEI) clientDb;
		if (currentClient == null) {
			return new ResponseEntity<Client>(HttpStatus.NOT_FOUND);
		} else {
			currentClient.setTitre(client.getTitre());
			currentClient.setNom(client.getNom());
			currentClient.setPrenom(client.getPrenom());
			currentClient.setNumeroFax(client.getNumeroFax());
			currentClient.setNumeroTel(client.getNumeroTel());
			currentClient.setEmail(client.getEmail());
			Client currentClient2 = clientDao.update(currentClient);
			currentClient2 = clientDao.find(currentClient2.getId());
			return new ResponseEntity<Client>(currentClient2, HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/client/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Client> delete(@PathVariable("id") Long id) {
		Client client = clientDao.find(id);
		if (client == null) {
			return new ResponseEntity<Client>(HttpStatus.NOT_FOUND);
		}
		clientDao.delete(client);
		return new ResponseEntity<Client>(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/titres/Physique", method = RequestMethod.GET)
	public ResponseEntity<TitrePhysique[]> listTitrePhysique() {

		return new ResponseEntity<TitrePhysique[]>(TitrePhysique.values(), HttpStatus.OK);

	}
	
	@RequestMapping(value = "/titres/Moral", method = RequestMethod.GET)
	public ResponseEntity<TitreMoral[]> listTitreMoral() {

		return new ResponseEntity<TitreMoral[]>(TitreMoral.values(), HttpStatus.OK);

	}
	
	@RequestMapping(value = "/titres/EI", method = RequestMethod.GET)
	public ResponseEntity<TitrePhysique[]> listTitreEI() {

		return new ResponseEntity<TitrePhysique[]>(TitrePhysique.values(), HttpStatus.OK);

	}
}
