package org.spring1.ufs15.dao;

import org.spring1.ufs15.model.Evento;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;
public interface EventoDao extends CrudRepository<Evento, Long> {
    List<Evento> findByTitolo(String titolo);
    List<Evento> findByOrganizzatore(String organizzatore);
    List<Evento> findByIdTipo(int idTipo);
    List<Evento> findByDescrizione(String descrizione);
    List<Evento> findByDataInizio(Date dataInizio);
    List<Evento> findByDataFine(Date dataFine);
    List<Evento> findByEtaMinima(int etaMinima);
    List<Evento> findByLimitePersone(int limitePersone);
    List<Evento> findByIdStanza(int idStanza);

    Evento findById(long id);

}
