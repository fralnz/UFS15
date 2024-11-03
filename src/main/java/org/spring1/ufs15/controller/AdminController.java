package org.spring1.ufs15.controller;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.spring1.ufs15.dao.AdminDao;
import org.spring1.ufs15.dao.EventoDao;
import org.spring1.ufs15.dao.TipoDao;
import org.spring1.ufs15.model.Admin;
import org.spring1.ufs15.model.Evento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin/")
public class AdminController {

    @Autowired
    EventoDao eventiRepository;

    @Autowired
    private TipoDao tipoRepository;

    @Autowired
    AdminDao adminRepository;

    @RequestMapping(value = "/dashboard/", method = RequestMethod.GET)
    public String adminDashboard(HttpSession session) {
        Admin user = (Admin) session.getAttribute("loggedUser");
        if (user == null) {
            return "redirect:/login/";
        }
        return "Dashboard";
    }

    @RequestMapping(value = "/eventi/", method = RequestMethod.GET)
    public String eventi(@RequestParam(required = false) String searchTerm, Model model, HttpSession session) {
        if (session.getAttribute("loggedUser") == null) {
            return "redirect:/login/";
        }
        List<Evento> eventi;
        if (searchTerm == null || searchTerm.trim().isEmpty()) {
            eventi = eventiRepository.getEventiList();
        } else {
            eventi = eventiRepository.searchByTitolo(searchTerm);
        }
        model.addAttribute("eventi", eventi);
        model.addAttribute("tipiList", tipoRepository.findAll());
        return "GestisciEventi";
    }

    @RequestMapping("/eventi/{searchTerm}")
    public String cercaEventi(@PathVariable("searchTerm") String s, Model model, HttpSession session) {
        if (session.getAttribute("loggedUser") == null) {
            return "redirect:/login/";
        }
        if (s.isEmpty()) {
            return "redirect:/admin/eventi/";
        }
        System.out.println("Cercando eventi con il nome: " + s);
        List<Evento> eventi = eventiRepository.findByTitolo(s);
        model.addAttribute("eventi", eventi);
        model.addAttribute("tipiList", tipoRepository.findAll());
        model.addAttribute("searchTerm", s);
        return "GestisciEventi";
    }

    // OGNI TANTO MI DA QUESTO URL: http://localhost:8080/admin/eventi/;jsessionid=BAC7309E66B1D59D95824FA7E6576BA5?searchTerm=Picasso

    @RequestMapping("/eventi/eliminaEvento/{id}")
    public String eliminaEvento(@PathVariable("id") long id, HttpSession session) {
        if (session.getAttribute("loggedUser") == null) {
            return "redirect:/login/";
        }
        System.out.println(id);
        eventiRepository.deleteById(id);
        return "redirect:/admin/eventi/";
    }

    @RequestMapping("/eventi/modificaEvento/{id}")
    public String modificaEvento(@PathVariable("id") long id, Model model, HttpSession session) {
        if (session.getAttribute("loggedUser") == null) {
            return "redirect:/login/";
        }
        Evento evento = eventiRepository.findById(id);
        if (evento == null) {
            return (null);
        }
        model.addAttribute("evento", evento);
        model.addAttribute("tipiList", tipoRepository.findAll());

        return "ModificaEvento";
    }

    @PostMapping("/eventi/modificaEvento/aggiornaEvento/")
    public String aggiornaEvento(@Valid Evento e, BindingResult bindingResult, HttpSession session) {
        if (session.getAttribute("loggedUser") == null) {
            return "redirect:/login/";
        }
        System.out.println(e);
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getAllErrors());
            return (null);
        }
        eventiRepository.save(e);
        return "redirect:/admin/eventi/";
    }

    @RequestMapping("/utenti/")
    public String gestisciUtenti(Model model, HttpSession session) {
        Admin user = (Admin) session.getAttribute("loggedUser");
        if (user == null) {
            return "redirect:/login/";
        }
        model.addAttribute("adminList", adminRepository.findAll());
        model.addAttribute("loggedUser", user);

        return "GestisciUtenti";
    }

    @RequestMapping("/utenti/eliminaUtente/{id}")
    public String eliminaUtente(@PathVariable("id") long id, HttpSession session) {
        Admin user = (Admin) session.getAttribute("loggedUser");
        if (user == null) {
            return "redirect:/login/";
        }
        Admin deletedUser = adminRepository.findById(id);
        System.out.println("utente loggato: " + user);
        System.out.println("utente da eliminare: " + deletedUser);
        System.out.println("sono uguali: " + deletedUser.equals(user));
        if (deletedUser.equals(user)) {
            return "EliminaUtenteLoggato";
        }
        adminRepository.deleteById(id);
        return "redirect:/admin/utenti/";
    }

    @RequestMapping("/utenti/creaAdmin/")
    public String creaAdmin(Model model, HttpSession session) {
        if (session.getAttribute("loggedUser") == null) {
            return "redirect:/login/";
        }
        model.addAttribute("admin", new Admin());
        return "CreazioneUtenti";
    }

    @PostMapping("/utenti/creaAdmin/")
    public String postCreaAdmin(@Valid Admin a, BindingResult bindingResult) {
        adminRepository.save(a);
        return "redirect:/admin/utenti/";
    }

}
