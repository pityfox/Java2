package banque.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import banque.dao.ClientDao;
import banque.model.Client;
import banque.model.Titre;

@Controller
@RequestMapping("/client")
public class ClientController {

	@Autowired
	private ClientDao clientDao;

	
	public ClientController() {
		super();
	}

	
	@RequestMapping({"/list",""})
	public String list(Model model) {
		List<Client> mesClients = clientDao.findAll();
		
		model.addAttribute("mesClients", mesClients);

		return "client/clients";
	}

	@RequestMapping("/add")
	public ModelAndView add() {
		ModelAndView mav = new ModelAndView("client/clientEdit", "titres", Titre.values());
		mav.addObject("client", new Client());
		
		return mav;
	}

	@RequestMapping("/edit")
	public String edit(@RequestParam("id") Long idClient, Model model) {
		Client client = clientDao.find(idClient);
		
		model.addAttribute("client", client);
		model.addAttribute("titres", Titre.values());
		
		return "client/clientEdit";
	}

	@RequestMapping("/save")
	public String save(@ModelAttribute("client") @Valid Client client, BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			model.addAttribute("titres", Titre.values());
			
			return "client/clientEdit";
		}
		
		if(client.getId()!=null) {
			clientDao.update(client);
		} else {
			clientDao.create(client);
		}
		
		return "forward:list";
	}

	@RequestMapping("/delete")
	public String delete(@RequestParam("id") Long idClient) {
		Client client = clientDao.find(idClient);
		
		clientDao.delete(client);
		
		return "forward:list";
	}

	

}
