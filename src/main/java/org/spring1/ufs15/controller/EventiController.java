package org.spring1.ufs15.controller;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
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

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(path = "/admin/eventi")
public class EventiController {

    @Autowired
    private EventoDao eventiRepository;

    @Autowired
    private TipoDao tipoRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
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

    @RequestMapping("/{searchTerm}")
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

    @RequestMapping("/eliminaEvento/{id}")
    public String eliminaEvento(@PathVariable("id") long id, HttpSession session) {
        if (session.getAttribute("loggedUser") == null) {
            return "redirect:/login/";
        }
        System.out.println(id);
        eventiRepository.deleteById(id);
        return "redirect:/admin/eventi/";
    }

    @RequestMapping("/modificaEvento/{id}")
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

    @PostMapping("/modificaEvento/aggiornaEvento/")
    public String aggiornaEvento(@Valid Evento e, BindingResult bindingResult, Model model, HttpSession session) {
        if (session.getAttribute("loggedUser") == null) {
            return "redirect:/login/";
        }
        System.out.println(e);
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getAllErrors());

            Evento originalEvento = eventiRepository.findById(e.getId());
            if (originalEvento == null) {
                return "redirect:/error";
            }

            model.addAttribute("evento", e);
            model.addAttribute("tipiList", tipoRepository.findAll());
            model.addAttribute("org.springframework.validation.BindingResult.evento", bindingResult);

            return "ModificaEvento";
        }

        eventiRepository.save(e);
        return "redirect:/admin/eventi/";
    }


    @GetMapping("/creaEvento/")
    public String evento(Model model, HttpSession session) {
        if (session.getAttribute("loggedUser") == null) {
            return "redirect:/login/";
        }
        model.addAttribute("evento", new Evento());
        model.addAttribute("tipiList", tipoRepository.findAll());

        return "ModificaEvento";
    }
}
