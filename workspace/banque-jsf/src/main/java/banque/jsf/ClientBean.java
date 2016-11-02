package banque.jsf;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import banque.dao.ClientDao;
import banque.model.Client;
import banque.model.Titre;

@Component
@Scope("request")
public class ClientBean {

	@Autowired
	private ClientDao clientDao;

	private Long clientId = null;

	private Client selectedClient = new Client();

	public List<Client> getClients() {
		return clientDao.findAll();
	}

	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	public Client getSelectedClient() {
		return selectedClient;
	}

	public void setSelectedClient(Client selectedClient) {
		this.selectedClient = selectedClient;
	}

	public Titre[] getTitres() {
		return Titre.values();
	}

	public String add() {
		return "clientEdit";
	}

	public String edit() {
		this.selectedClient = clientDao.find(clientId);

		return "clientEdit";
	}

	public String save() {
		if (selectedClient.getId() != null) {
			clientDao.update(selectedClient);
		} else {
			clientDao.create(selectedClient);
		}

		return "clients";
	}

	public String delete(Long id) {
		selectedClient = clientDao.find(id);

		return delete();
	}
	
	public String delete() {
		clientDao.delete(selectedClient);

		return "clients";
	}
}
