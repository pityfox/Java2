package banque.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("")
	public String home(Model model) {
		model.addAttribute("page", "home");
		return "home";
	}
	
	@RequestMapping("/header")
	public String header() {
		return "header";
	}

}
