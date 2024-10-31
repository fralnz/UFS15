package org.spring1.ufs15.controller;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.spring1.ufs15.dao.EventoDao;
import org.spring1.ufs15.model.Evento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping("/eventi/eliminaEvento/{id}")
    public String deleteEvento(@PathVariable("id") long id) {
        System.out.println(id);
        eventiRepository.deleteById(id);
        return "redirect:/admin/eventi/"; // Redirect to the list of events after deletion
    }
}
