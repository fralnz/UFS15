package org.spring1.ufs15.controller;

import jakarta.validation.Valid;
import org.spring1.ufs15.dao.EventoDao;
import org.spring1.ufs15.model.Evento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Calendar;
import java.util.Date;

@Controller
@RequestMapping(path = "/eventi")
public class EventiController {

    @Autowired
    private EventoDao eventoRepository;

    @GetMapping("/")
    public String evento(Model model) {
        ModelAndView modelAndView = new ModelAndView();

        Evento evento = new Evento(
                0,
                "Titolo",
                "Descrizione",
                "Organizzatore",
                new Date(12, Calendar.MARCH, 12),
                new Date(12, Calendar.MARCH, 14),
                8,
                12,
                3,
                2);
        model.addAttribute("evento", evento);

        return "CreazioneEvento";
    }
    @PostMapping("/creaEvento")
    public String save(@Valid Evento e, BindingResult bindingResult) { //BindingResult controlla se lìevento è valido
        eventoRepository.save(e);
        return "redirect:";
    }
}
