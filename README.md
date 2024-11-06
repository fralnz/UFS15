# UFS15

**Autori**: Francesco Lanza, Giulia Andreea Banica, Francesco Mazzi, Dario Chin, Jacopo Grassi, Federico Giacomantonio.

### Traccia

**Eventi e Mostre**: si devono gestire gli Eventi e delle Mostre, dovrà essere creata una Agenda degli eventi, pianificare mostre e assegnare gli spazi all’interno del Museo per tali eventi.

## Classi MVC

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

    class Tipo {
        +Integer id
        +String nome
        
        +Tipo()
        +Tipo(String nome)
        +Tipo(Integer id, String nome)
    }
```

```mermaid

---
title: Classi DAO
---
classDiagram
    class CrudRepository {
        <<interface>>
        +save(T entity)
        +findById(ID id)
        +delete(T entity)
        +findAll() : Iterable<T>
        // Altri metodi standard di CrudRepository
    }

    class AdminDao {
        +Admin checkCredentials(String mail, String password)
        +Admin findByMail(String mail)
        +Admin findById(long id)
    }

    class EventoDao {
        +List<Evento> getEventiList()
        +Evento findById(long id)
        +List<Evento> findByTitolo(String titolo)
        +List<Evento> searchByTitolo(String titolo)
    }

    class TipoDao {
    }

    AdminDao ..|> CrudRepository
    EventoDao ..|> CrudRepository
    TipoDao ..|> CrudRepository

```


