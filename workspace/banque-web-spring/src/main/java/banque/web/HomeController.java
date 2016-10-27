package banque.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import banque.model.Agence;

@Controller
@RequestMapping({"/",""})
public class HomeController {

	@RequestMapping({"/home",""})
	public String home(Model model) {
		
		model.addAttribute("page", "home/home.jsp");
		
		return "pagebody";
	}
	
}
