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
    ArrayList<Evento> utentiSalvati = new ArrayList();

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("registrati")
    public String registrati(Model model) {
        model.addAttribute("persona", new Evento());
        return "registrati";
    }

    @PostMapping("registrati")
    public String registrati(@Valid Evento evento, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "registrati";

        utentiSalvati.add(evento);

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
