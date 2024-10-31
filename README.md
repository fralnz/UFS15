# Breve Spiegazione

I file importanti sono contenuti in 4 cartelle principali:

- `model`

- `dao`

- `controller`

- `resources/templates`

### Model

Qui sono definite le classi e i loro parametri/funzioni.

Tieni a mente che **ogni parametro** non puo' essere di tipo primitivo (`int`, `string`, `char`...), ma **deve essere un oggetto** (`Integer`, `String`...), questo perche' hanno bisogno di costruttori.

Prima di ogni parametro va messo uno o piu' decoratori per definire i suoi requisiti:

```java
@NotNull                    //Non puo' essere null
@Size(min = 1, max = 25)    //La stringa deve essere lunga da 1 a 25
String cognome;             //Il parametro cognome
```

Una volta definiti i parametri, si devono generare i **costruttori** (sia vuoto che completo), `getter` e `setter`, e un `toString`.

### Dao

Qui ci si interfaccia col database: si **definiscono le query** necessarie ad interpellare il DB.

```java
//checkCredentials restituisce un oggetto di tipo Admin che corrisponde alle credenziali fornite.
// Se non esiste un Admin che ha quelle credenziali, restituisce null.
public interface AdminDao extends CrudRepository<Admin, Long> {
    @Query("SELECT a FROM Admin a WHERE a.mail = :mail AND a.password = :password")
    public Admin checkCredentials(String mail, String password);
}
```

**IMPORTANTE**: dato che l'interfaccia estende `CrudRepository`, metodi come:

- save

- delete

- update

sono gia' definiti, quindi non e' necessario riscriverli.

### Controller

Qui si associa il percorso dell'`URL` ad una pagina `html`.

```java
@Controller
@RequestMapping("/login/")    //percorso di base: /login/
public class LoginController {
    //definiamo il percorso esteso, in questo caso rimane /login/
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String postLoginPage(Model model) {
        //con il Model passiamo un oggetto di tipo Admin che puo' essere usato nell'html
        model.addAttribute("admin", new Admin());
        return "Login";        //associa a "Login.html"
    }
}
```


