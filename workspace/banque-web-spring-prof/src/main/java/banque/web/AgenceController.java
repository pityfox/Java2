package banque.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import banque.dao.AgenceDao;
import banque.model.Agence;
import banque.model.AgenceId;
import banque.model.Client;

@Controller
@RequestMapping("/agence")
public class AgenceController {

	@Autowired
	private AgenceDao agenceDao;

	@RequestMapping({ "/list", "" })
	public String list(Model model) {
		List<Agence> agences = agenceDao.findAll();

		model.addAttribute("agences", agences);
		model.addAttribute("page", "agence");

		return "agence/agences";
	}

	@RequestMapping("/add")
	public ModelAndView add() {
		ModelAndView mav = new ModelAndView("agence/agenceEdit", "agence", new Agence());

		return mav;
	}

	@RequestMapping("/edit")
	public String edit(@RequestParam("numBanque") Integer numBanque, @RequestParam("numAgence") Integer numAgence,
			Model model) {
		Agence agence = agenceDao.find(new AgenceId(numBanque, numAgence));

		model.addAttribute("agence", agence);
		model.addAttribute("mode", "edit");

		return "agence/agenceEdit";
	}

	@RequestMapping("/save")
	public String save(@ModelAttribute("agence") Agence agence, @RequestParam("mode") String mode) {

		if("edit".equals(mode)) {
			agenceDao.update(agence);
		} else {
			agenceDao.create(agence);
		}
		
		return "forward:list";
	}

	@RequestMapping("/delete")
	public String delete(@RequestParam("numBanque") Integer numBanque, @RequestParam("numAgence") Integer numAgence) {
		Agence agence = agenceDao.find(new AgenceId(numBanque, numAgence));

		agenceDao.delete(agence);

		return "redirect:list";
	}
}
 