package it.itsrizzoli.ScuolaForm;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;

@Controller
public class ScuolaController {
	ArrayList<Persona> utentiSalvati = new ArrayList();

	@GetMapping("/")
	public String index() {
		return "index";
	}
	

	@GetMapping("registrati")
	public String registrati(Model model) {
		model.addAttribute("persona", new Persona());
		return "registrati";
	}
	
	@PostMapping("registrati")
	public String registrati(@Valid Persona persona, BindingResult bindingResult) {
		if(bindingResult.hasErrors())
			return "registrati";
		
		utentiSalvati.add(persona);
		
		return "redirect:/utenti";
	}
	
	@GetMapping("home")
	public String home() {
		return "home";
	}
	
	@GetMapping("utenti")
	public String utenti(Model model) {
		model.addAttribute("utenti", utentiSalvati);
		return "utenti";
	}
}
