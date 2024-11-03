package org.spring1.ufs15.config;

import org.spring1.ufs15.dao.AdminDao;
import org.spring1.ufs15.dao.EventoDao;
import org.spring1.ufs15.dao.TipoDao;
import org.spring1.ufs15.model.Admin;
import org.spring1.ufs15.model.Evento;
import org.spring1.ufs15.model.Tipo;
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
            adminRepo.save(new Admin("pippo@pera.it", "SafePass@8", "Pippo", "Pera"));
            adminRepo.save(new Admin("francesco@lanza.it", "SafePass@8", "Francesco", "Lanza"));
        };
    }

    @Bean
    CommandLineRunner dataStarter(EventoDao eventiRepo, TipoDao tipiRepo) {
        return args -> {

            // TIPI
            Tipo tipoMostra = new Tipo("Mostra d'Arte");
            Tipo tipoEvento = new Tipo("Evento Sociale");
            tipiRepo.save(tipoMostra);
            tipiRepo.save(tipoEvento);

            // MOSTRE
            eventiRepo.save(new Evento(
                    "Van Gogh",
                    "Mostra assurda",
                    "Amsterdam",
                    LocalDateTime.of(2024, 1, 8, 14, 45),
                    LocalDateTime.of(2024, 2, 12, 18, 30),
                    104,
                    8,
                    2,
                    tipoMostra
            ));

            eventiRepo.save(new Evento(
                    "Picasso",
                    "Esposizione unica",
                    "Madrid",
                    LocalDateTime.of(2024, 3, 15, 10, 15),
                    LocalDateTime.of(2024, 4, 30, 20, 45),
                    105,
                    9,
                    3,
                    tipoMostra
            ));

            eventiRepo.save(new Evento(
                    "Monet",
                    "Impressionismo",
                    "Paris",
                    LocalDateTime.of(2024, 6, 1, 12, 0),
                    LocalDateTime.of(2024, 7, 31, 16, 30),
                    106,
                    10,
                    4,
                    tipoMostra
            ));

            eventiRepo.save(new Evento(
                    "Da Vinci",
                    "Rinascimento",
                    "Firenze",
                    LocalDateTime.of(2024, 9, 1, 15, 45),
                    LocalDateTime.of(2024, 10, 31, 21, 0),
                    107,
                    11,
                    5,
                    tipoMostra
            ));

            eventiRepo.save(new Evento(
                    "Michelangelo",
                    "Capolavori",
                    "Roma",
                    LocalDateTime.of(2024, 1, 8, 9, 30),
                    LocalDateTime.of(2024, 2, 12, 13, 15),
                    108,
                    12,
                    6,
                    tipoMostra
            ));

            // EVENTI
            eventiRepo.save(new Evento(
                    "Conferenza sull'ambiente",
                    "Tutti ambientalisti quando si parla delle cose degli altri",
                    "Francesco Mazzi",
                    LocalDateTime.of(2024, 1, 8, 9, 30),
                    LocalDateTime.of(2024, 2, 12, 13, 15),
                    108,
                    12,
                    6,
                    tipoEvento
            ));
        };
    }
}
