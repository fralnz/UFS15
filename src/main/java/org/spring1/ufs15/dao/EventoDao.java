package org.spring1.ufs15.dao;

import org.spring1.ufs15.model.Evento;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface EventoDao extends CrudRepository<Evento, Long> {

    @Query("SELECT e FROM Evento e")
    public List<Evento> getEventiList();

    Evento findById(long id);
}
