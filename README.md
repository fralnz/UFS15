# UFS15

**Autori**: Francesco Lanza, Giulia Andreea Banica, Francesco Mazzi, Dario Chin, Jacopo Grassi, Federico Giacomantonio.

### Traccia

**Eventi e Mostre**: si devono gestire gli Eventi e delle Mostre, dovrà essere creata una Agenda degli eventi, pianificare mostre e assegnare gli spazi all’interno del Museo per tali eventi.

## Modelli

```mermaid
---
title: Classi Modello
---
classDiagram
    class Admin {
        +Integer id
       +String mail
        +String passwordChiara
        +String password
        +String nome
        +String cognome
        
        +Admin()
        +Admin(String mail, String passwordChiara, String nome, String cognome)
        +Admin(Integer id, String mail, String passwordChiara, String nome, String cognome)
    }

classDiagram
    class Evento {
        +Integer id
        +String titolo
        +String organizzatore
        +Tipo tipo
        +String descrizione
        +LocalDateTime dataInizio
        +LocalDateTime dataFine
        +Integer etaMinima
        +Integer limitePersone
        +Integer idStanza
        +String urlImmagine

        +Evento()
        +Evento(...)
    }

classDiagram
    class Tipo {
        +Integer id
        +String nome
        
        +Tipo()
        +Tipo(String nome)
        +Tipo(Integer id, String nome)
    }
```
