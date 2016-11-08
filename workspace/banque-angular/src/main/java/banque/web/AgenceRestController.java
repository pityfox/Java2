package banque.web;

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

import banque.dao.AgenceDao;
import banque.model.Agence;
import banque.model.AgenceId;

@RestController
public class AgenceRestController {

	@Autowired
	private AgenceDao agenceDao;

	@RequestMapping(value = "/agence/", method = RequestMethod.GET)
	public ResponseEntity<List<Agence>> listAll() {
		List<Agence> agences = agenceDao.findAll();
		if (agences == null) {
			return new ResponseEntity<List<Agence>>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<Agence>>(agences, HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/agence/{numAgence}:{numBanque}", method = RequestMethod.GET)
	public ResponseEntity<Agence> get(@PathVariable("numAgence") Integer numAgence, @PathVariable("numBanque") Integer numBanque) {
		AgenceId id = new AgenceId(numBanque, numAgence);
		Agence agence = agenceDao.find(id);
		if (agence == null) {
			return new ResponseEntity<Agence>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Agence>(agence, HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/agence/", method = RequestMethod.POST)
	public ResponseEntity<Void> create(@RequestBody Agence agence, UriComponentsBuilder ucBuilder) {
		if (agence.getId() != null && agenceDao.find(agence.getId()) != null) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		} else {
			agenceDao.create(agence);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(ucBuilder.path("/agence/{id}").buildAndExpand(agence.getId()).toUri());
			return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
		}
	}

	@RequestMapping(value = "/agence/{numAgence}:{numBanque}", method = RequestMethod.PUT)
	public ResponseEntity<Agence> update(@PathVariable("numAgence") Integer numAgence, @PathVariable("numBanque") Integer numBanque, @RequestBody Agence agence) {
		AgenceId id = new AgenceId(numBanque, numAgence);
		Agence currentAgence = agenceDao.find(id);
		if (currentAgence == null) {
			return new ResponseEntity<Agence>(HttpStatus.NOT_FOUND);
		} else {
			currentAgence.setLibelle(agence.getLibelle());
			currentAgence.setHoraires(agence.getHoraires());
			currentAgence.setAdresse(agence.getAdresse());
			currentAgence = agenceDao.update(currentAgence);
			currentAgence = agenceDao.find(currentAgence.getId());
			return new ResponseEntity<Agence>(currentAgence, HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/agence/{numAgence}:{numBanque}", method = RequestMethod.DELETE)
	public ResponseEntity<Agence> delete(@PathVariable("numAgence") Integer numAgence, @PathVariable("numBanque") Integer numBanque) {
		AgenceId id = new AgenceId(numBanque, numAgence);
		Agence agence = agenceDao.find(id);
		if (agence == null) {
			return new ResponseEntity<Agence>(HttpStatus.NOT_FOUND);
		}
		agenceDao.delete(agence);
		return new ResponseEntity<Agence>(HttpStatus.NO_CONTENT);
	}

}
