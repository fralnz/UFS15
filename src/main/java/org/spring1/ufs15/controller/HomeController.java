package org.spring1.ufs15.controller;

import jakarta.servlet.http.HttpSession;
import org.spring1.ufs15.dao.AdminDao;
import org.spring1.ufs15.dao.EventoDao;
import org.spring1.ufs15.dao.TipoDao;
import org.spring1.ufs15.model.Admin;
import org.spring1.ufs15.model.Evento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    private EventoDao eventiRepository;

    @Autowired
    private TipoDao tipoRepository;

    @RequestMapping(value = "/")
    public String homeRedirect(Model model) {
        Iterable<Evento> eventi = eventiRepository.findAll();
        List<Evento> mostreList = new ArrayList<>();
        List<Evento> eventiList = new ArrayList<>();
        for (Evento evento : eventi) {
            if (Objects.equals(evento.getTipo().getNome(), "Mostra d'Arte")) {
                mostreList.add(evento);
            } else {
                eventiList.add(evento);
            }
        }
        model.addAttribute("mostre", mostreList);
        model.addAttribute("eventi", eventiList);
        return "HomePage";
    }

    @RequestMapping("/evento/{id}")
    public String infoEvento(@PathVariable("id") long id, Model model) {
        Evento evento = eventiRepository.findById(id);
        if (evento == null) {
            return (null);
        }
        model.addAttribute("evento", evento);
        model.addAttribute("tipiList", tipoRepository.findAll());

        return "DettagliEvento";
    }

}
