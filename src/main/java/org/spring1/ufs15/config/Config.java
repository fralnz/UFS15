package org.spring1.ufs15.config;

import org.spring1.ufs15.dao.AdminDao;
import org.spring1.ufs15.dao.EventoDao;
import org.spring1.ufs15.model.Admin;
import org.spring1.ufs15.model.Evento;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class Config {

    @Bean
    CommandLineRunner adminStarter(AdminDao adminRepo) {
        return args -> {
            adminRepo.save(new Admin(1, "pippo@pera.it", "puppa", "Pippo", "Pera"));
        };
    }

    @Bean
    CommandLineRunner eventiStarter(EventoDao eventiRepo) {
        return args -> {
            eventiRepo.save(new Evento(1, "Van Gogh", "Mostra assurda", "Amsterdam", LocalDate.of(2024, 1, 8), LocalDate.of(2024, 2, 12), 104, 8, 2, 1));
            eventiRepo.save(new Evento(2, "Picasso", "Esposizione unica", "Madrid", LocalDate.of(2024, 2, 8), LocalDate.of(2024, 2, 22), 105, 9, 3, 1));
            eventiRepo.save(new Evento(3, "Monet", "Impressionismo", "Paris", LocalDate.of(2024, 1, 8), LocalDate.of(2024, 2, 12), 106, 10, 4, 1));
            eventiRepo.save(new Evento(4, "Da Vinci", "Rinascimento", "Florence", LocalDate.of(2024, 1, 8), LocalDate.of(2024, 2, 12), 107, 11, 5, 1));
            eventiRepo.save(new Evento(5, "Michelangelo", "Capolavori", "Rome", LocalDate.of(2024, 1, 8), LocalDate.of(2024, 2, 12), 108, 12, 6, 1));
        };
    }
}
