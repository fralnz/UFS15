package org.spring1.ufs15.dao;

import org.spring1.ufs15.model.Evento;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface EventoDao extends CrudRepository<Evento, Long> {

    @Query("SELECT e FROM Evento e")
    public List<Evento> getEventiList();

    Evento findById(long id);

    @Query("SELECT e FROM Evento e WHERE e.titolo = :titolo")
    public List<Evento> findByTitolo(String titolo);

    @Query("SELECT e FROM Evento e WHERE LOWER(e.titolo) LIKE LOWER(CONCAT('%', :titolo, '%'))")
    public List<Evento> searchByTitolo(String titolo);
}
