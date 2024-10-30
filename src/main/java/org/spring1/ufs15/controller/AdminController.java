package org.spring1.ufs15.controller;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.spring1.ufs15.dao.EventoDao;
import org.spring1.ufs15.model.Evento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/admin/")
public class AdminController {

    @Autowired
    EventoDao eventiRepository;

    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public String adminDashboard(HttpSession session) {
        return "Dashboard";
    }

    @RequestMapping(value = "/eventi/", method = RequestMethod.GET)
    public String adminDashboard(Model model, HttpSession session) {
        List<Evento> eventi = eventiRepository.getEventiList();
        model.addAttribute("eventi", eventi);
        return "GestisciEventi";
    }

    @PostMapping("/eventi/eliminaEvento/")
    public String save(@Valid Evento evento, BindingResult bindingResult) {
        System.out.println("evento da eliminare: " + evento);
        eventiRepository.delete(evento);
        return "redirect:/admin/eventi/";
    }
}
