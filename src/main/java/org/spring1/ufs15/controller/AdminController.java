package org.spring1.ufs15.controller;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.spring1.ufs15.dao.EventoDao;
import org.spring1.ufs15.dao.TipoDao;
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


    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public String adminDashboard(HttpSession session) {
        return "Dashboard";
    }

    @RequestMapping(value = "/eventi/", method = RequestMethod.GET)
    public String adminDashboard(Model model, HttpSession session) {
        List<Evento> eventi = eventiRepository.getEventiList();
        model.addAttribute("eventi", eventi);
        model.addAttribute("tipiList", tipoRepository.findAll());
        return "GestisciEventi";
    }

    @RequestMapping("/eventi/eliminaEvento/{id}")
    public String deleteEvento(@PathVariable("id") long id) {
        System.out.println(id);
        eventiRepository.deleteById(id);
        return "redirect:/admin/eventi/";
    }

    @RequestMapping("/eventi/modificaEvento/{id}")
    public String editEvento(@PathVariable("id") long id, Model model) {
        Evento evento = eventiRepository.findById(id);
        if (evento == null) {
            return (null);
        }
        model.addAttribute("evento", evento);
        model.addAttribute("tipiList", tipoRepository.findAll());

        return "ModificaEvento";
    }

    @PostMapping("/eventi/modificaEvento/aggiornaEvento/")
    public String save(@Valid Evento e, BindingResult bindingResult) {
        System.out.println(e);
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getAllErrors());
            return (null);
        }
        eventiRepository.save(e);
        return "redirect:/admin/eventi/";
    }
}
