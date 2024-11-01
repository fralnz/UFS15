package org.spring1.ufs15.config;

import org.spring1.ufs15.dao.AdminDao;
import org.spring1.ufs15.dao.EventoDao;
import org.spring1.ufs15.model.Admin;
import org.spring1.ufs15.model.Evento;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
            eventiRepo.save(new Evento(1, "Van Gogh", "Mostra assurda", "Amsterdam", LocalDateTime.of(2024, 1, 8, 14, 45), LocalDateTime.of(2024, 2, 12, 18, 30), 104, 8, 2, 1));
            eventiRepo.save(new Evento(2, "Picasso", "Esposizione unica", "Madrid", LocalDateTime.of(2024, 3, 15, 10, 15), LocalDateTime.of(2024, 4, 30, 20, 45), 105, 9, 3, 1));
            eventiRepo.save(new Evento(3, "Monet", "Impressionismo", "Paris", LocalDateTime.of(2024, 6, 1, 12, 0), LocalDateTime.of(2024, 7, 31, 16, 30), 106, 10, 4, 1));
            eventiRepo.save(new Evento(4, "Da Vinci", "Rinascimento", "Firenze", LocalDateTime.of(2024, 9, 1, 15, 45), LocalDateTime.of(2024, 10, 31, 21, 0), 107, 11, 5, 1));
            eventiRepo.save(new Evento(5, "Michelangelo", "Capolavori", "Roma", LocalDateTime.of(2024, 1, 8, 9, 30), LocalDateTime.of(2024, 2, 12, 13, 15), 108, 12, 6, 1));

        };
    }
}
