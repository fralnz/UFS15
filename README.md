# UFS15

**Autori**: Francesco Lanza, Giulia Andreea Banica, Francesco Mazzi, Dario Chin, Jacopo Grassi, Federico Giacomantonio.

<a href="https://github.com/fralnz/UFS15/graphs/contributors">
  <img src="https://contrib.rocks/image?repo=fralnz/UFS15" />
</a>

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

```mermaid
---
title: Classi Controller
---

classDiagram
    class AdminController {
        +AdminController()
        +String redirectToDashBoard()
        +String adminDashboard(HttpSession session, Model model)
        +String gestisciUtenti(Model model, HttpSession session)
        +String eliminaUtente(long id, HttpSession session)
        +String creaAdmin(Model model, HttpSession session)
        +String postCreaAdmin(@Valid Admin a, BindingResult bindingResult, Model model, HttpSession session)
        +String modificaAdmin(long id, Model model, HttpSession session)
    }

    class EventoDao {
        <<interface>>
    }
    
    class TipoDao {
        <<interface>>
    }
    
    class AdminDao {
        <<interface>>
    }

    class HttpSession {
    }

    class Model {
    }

    class BindingResult {
    }

    AdminController --> EventoDao : uses
    AdminController --> TipoDao : uses
    AdminController --> AdminDao : uses
    AdminController --> HttpSession : uses
    AdminController --> Model : uses
    AdminController --> BindingResult : uses

    class AdminController {
        +String redirectToDashBoard()
        +String adminDashboard(HttpSession session, Model model)
        +String gestisciUtenti(Model model, HttpSession session)
        +String eliminaUtente(long id, HttpSession session)
        +String creaAdmin(Model model, HttpSession session)
        +String postCreaAdmin(@Valid Admin a, BindingResult bindingResult, Model model, HttpSession session)
        +String modificaAdmin(long id, Model model, HttpSession session)
    }
    
    class EventiController {
        +String eventi(String searchTerm, Model model, HttpSession session)
        +String cercaEventi(String s, Model model, HttpSession session)
        +String eliminaEvento(long id, HttpSession session)
        +String modificaEvento(long id, Model model, HttpSession session)
        +String aggiornaEvento(@Valid Evento e, BindingResult bindingResult, Model model, HttpSession session)
        +String evento(Model model, HttpSession session)
    }
    
    class HomeController {
        +String homeRedirect(Model model)
        +String infoEvento(long id, Model model)
        +String elencoEventi(Model model)
        +String elencoMostre(Model model)
    }
    
    class LoginController {
        +String postLoginPage(Model model, HttpSession session)
        +String postLogin(@Valid Admin admin, BindingResult bindingResult, HttpSession session)
        +String postLogout(HttpSession session)
    }

    class EventoDao {
        <<interface>>
    }

    class TipoDao {
        <<interface>>
    }

    class AdminDao {
        <<interface>>
    }

    class HttpSession {
    }

    class Model {
    }

    class BindingResult {
    }

    AdminController --> AdminDao : uses
    AdminController --> EventoDao : uses
    AdminController --> TipoDao : uses
    AdminController --> HttpSession : uses
    AdminController --> Model : uses
    AdminController --> BindingResult : uses

    EventiController --> EventoDao : uses
    EventiController --> TipoDao : uses
    EventiController --> HttpSession : uses
    EventiController --> Model : uses
    EventiController --> BindingResult : uses

    HomeController --> EventoDao : uses
    HomeController --> TipoDao : uses
    HomeController --> Model : uses

    LoginController --> AdminDao : uses
    LoginController --> HttpSession : uses
    LoginController --> Model : uses
    LoginController --> BindingResult : uses

```


