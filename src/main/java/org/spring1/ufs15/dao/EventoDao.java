package org.spring1.ufs15.dao;

import org.spring1.ufs15.model.Evento;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;
public interface EventoDao extends CrudRepository<Evento, Integer> {
    List<Evento> findByTitolo(String titolo);
    List<Evento> findByOrganizzatore(String organizzatore);
    List<Evento> findByMostraEvento(int mostraEvento);
    List<Evento> findByDescrizione(String descrizione);
    List<Evento> findByDataIn(Date dataIn);
    List<Evento> findByDataFin(Date dataFin);
    List<Evento> findByEtaMin(int etaMin);
    List<Evento> findByLimitePers(int limitePersone);
    List<Evento> findByStanza(int idStanza);

    Evento findByID(long id);

}
