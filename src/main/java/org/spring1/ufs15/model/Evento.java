package org.spring1.ufs15.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "Eventi")
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    @Size(min = 1, max = 30)
    String titolo;

    @NotNull
    @Size(min = 1, max = 25)
    String organizzatore;

    @ManyToOne
    @JoinColumn(name = "id_tipo", nullable = false)
    private Tipo tipo;

    @NotNull
    @Size(min = 1)
    String descrizione;

    @NotNull
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDateTime dataInizio;

    @NotNull
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDateTime dataFine;

    @Min(1)
    @Max(15)
    Integer etaMinima;

    @NotNull
    @Min(1)
    Integer limitePersone;

    @NotNull
    Integer idStanza;

    String urlImmagine;

    public Evento() {
    }

    public Evento(String titolo, String descrizione, String organizzatore, LocalDateTime dataInizio, LocalDateTime dataFine, Integer limitePersone, Integer etaMinima, Integer idStanza, Tipo tipo) {
        this.titolo = titolo;
        this.organizzatore = organizzatore;
        this.tipo = tipo;
        this.descrizione = descrizione;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
        this.etaMinima = etaMinima;
        this.limitePersone = limitePersone;
        this.idStanza = idStanza;
    }

    public Evento(String titolo, String descrizione, String organizzatore, LocalDateTime dataInizio, LocalDateTime dataFine, Integer limitePersone, Integer etaMinima, Integer idStanza, Tipo tipo, String urlImmagine) {
        this.titolo = titolo;
        this.organizzatore = organizzatore;
        this.tipo = tipo;
        this.descrizione = descrizione;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
        this.etaMinima = etaMinima;
        this.limitePersone = limitePersone;
        this.idStanza = idStanza;
        this.urlImmagine = urlImmagine;
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

    public String getOrganizzatore() {
        return organizzatore;
    }

    public void setOrganizzatore(String organizzatore) {
        this.organizzatore = organizzatore;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public LocalDateTime getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(LocalDateTime dataInizio) {
        this.dataInizio = dataInizio;
    }

    public LocalDateTime getDataFine() {
        return dataFine;
    }

    public void setDataFine(LocalDateTime dataFine) {
        this.dataFine = dataFine;
    }

    public Integer getEtaMinima() {
        return etaMinima;
    }

    public void setEtaMinima(Integer etaMinima) {
        this.etaMinima = etaMinima;
    }

    public Integer getLimitePersone() {
        return limitePersone;
    }

    public void setLimitePersone(Integer limitePersone) {
        this.limitePersone = limitePersone;
    }

    public Integer getIdStanza() {
        return idStanza;
    }

    public void setIdStanza(Integer idStanza) {
        this.idStanza = idStanza;
    }

    public String getUrlImmagine() {
        return urlImmagine;
    }

    public void setUrlImmagine(String urlImmagine) {
        this.urlImmagine = urlImmagine;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Evento evento = (Evento) o;
        return Objects.equals(id, evento.id) && Objects.equals(titolo, evento.titolo) && Objects.equals(organizzatore, evento.organizzatore) && Objects.equals(tipo, evento.tipo) && Objects.equals(descrizione, evento.descrizione) && Objects.equals(dataInizio, evento.dataInizio) && Objects.equals(dataFine, evento.dataFine) && Objects.equals(etaMinima, evento.etaMinima) && Objects.equals(limitePersone, evento.limitePersone) && Objects.equals(idStanza, evento.idStanza) && Objects.equals(urlImmagine, evento.urlImmagine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, titolo, organizzatore, tipo, descrizione, dataInizio, dataFine, etaMinima, limitePersone, idStanza, urlImmagine);
    }

    @Override
    public String toString() {
        return "Evento{" +
                "id=" + id +
                ", titolo='" + titolo + '\'' +
                ", organizzatore='" + organizzatore + '\'' +
                ", tipo=" + tipo +
                ", descrizione='" + descrizione + '\'' +
                ", dataInizio=" + dataInizio +
                ", dataFine=" + dataFine +
                ", etaMinima=" + etaMinima +
                ", limitePersone=" + limitePersone +
                ", idStanza=" + idStanza +
                ", urlImmagine='" + urlImmagine + '\'' +
                '}';
    }
}
