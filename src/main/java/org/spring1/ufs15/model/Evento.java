package org.spring1.ufs15.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
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
    @Size(min = 1, max = 25)
    String organizzatore;

    @NotNull
    Integer idTipo;

    @NotNull
    @Size(min = 1)
    String descrizione;

    @NotNull
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate dataInizio;

    @NotNull
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate dataFine;

    @Min(1)
    @Max(15)
    Integer etaMinima;

    @NotNull
    @Min(1)
    Integer limitePersone;

    @NotNull
    Integer idStanza;


    public Evento(int id, String titolo, String organizzatore, int mostraEvento, String descrizione, java.sql.Date dataIn, java.sql.Date dataFin, int etaMin, int limitePers, String stanza) {
    }

    public Evento(Integer id, String titolo, String descrizione, String organizzatore, LocalDate dataInizio, LocalDate dataFine, Integer limitePersone, Integer etaMinima, Integer idStanza, Integer idTipo) {
        this.id = id;
        this.titolo = titolo;
        this.descrizione = descrizione;
        this.organizzatore = organizzatore;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
        this.limitePersone = limitePersone;
        this.etaMinima = etaMinima;
        this.idStanza = idStanza;
        this.idTipo = idTipo;
    }

    public Evento() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getOrganizzatore() {
        return organizzatore;
    }

    public void setOrganizzatore(String organizzatore) {
        this.organizzatore = organizzatore;
    }

    public LocalDate getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(LocalDate dataInizio) {
        this.dataInizio = dataInizio;
    }

    public LocalDate getDataFine() {
        return dataFine;
    }

    public void setDataFine(LocalDate dataFine) {
        this.dataFine = dataFine;
    }

    public Integer getLimitePersone() {
        return limitePersone;
    }

    public void setLimitePersone(Integer limitePersone) {
        this.limitePersone = limitePersone;
    }

    public Integer getEtaMinima() {
        return etaMinima;
    }

    public void setEtaMinima(Integer etaMinima) {
        this.etaMinima = etaMinima;
    }

    public Integer getIdStanza() {
        return idStanza;
    }

    public void setIdStanza(Integer idStanza) {
        this.idStanza = idStanza;
    }

    public Integer getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(Integer idTipo) {
        this.idTipo = idTipo;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "id=" + id +
                ", titolo='" + titolo + '\'' +
                ", organizzatore='" + organizzatore + '\'' +
                ", idTipo=" + idTipo +
                ", descrizione='" + descrizione + '\'' +
                ", dataInizio=" + dataInizio +
                ", dataFine=" + dataFine +
                ", etaMinima=" + etaMinima +
                ", limitePersone=" + limitePersone +
                ", idStanza=" + idStanza +
                '}';
    }
}
