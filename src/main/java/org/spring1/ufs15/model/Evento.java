package org.spring1.ufs15.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.Date;

@Entity
@Table(name = "Eventi")
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    @Size(min = 1, max = 25)
    String titolo;

    @NotNull
    @Size(min = 1)
    String descrizione;

    @NotNull
    @Size(min = 1, max = 25)
    String organizzatore;

    @NotNull
    Date dataInizio;

    @NotNull
    Date dataFine;

    @NotNull
    @Size(min = 1)
    Integer limitePersone;

    @NotNull
    @Size(min = 1, max = 21)
    Integer etaMinima;

    @NotNull
    Integer idStanza;

    @NotNull
    Integer idTipo;

    public Evento(int id, String titolo, String organizzatore, int mostraEvento, String descrizione, java.sql.Date dataIn, java.sql.Date dataFin, int etaMin, int limitePers, String stanza) {
    }
}
