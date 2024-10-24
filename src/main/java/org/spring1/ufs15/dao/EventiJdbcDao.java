package org.spring1.ufs15.dao;

import java.util.List;
import java.util.Date;

import org.spring1.ufs15.model.Evento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EventiJdbcDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Evento> creazione(String titolo, String organizzatore, int mostraEvento, String descrizione, Date dataIn,Date dataFin, int etaMin, int limitePers, String stanza){
        return jdbcTemplate.query(
                "select * from evento",
                new Object[]{titolo,organizzatore, mostraEvento, descrizione, dataIn, dataFin,etaMin, limitePers, stanza  },
                (rs, rowNum) ->
                        new Evento(
                                rs.getInt("id"),
                                rs.getString("titolo"),
                                rs.getString("organizzatore"),
                                rs.getInt("mostraEvento"),
                                rs.getString("descrizione"),
                                rs.getDate("dataIn"),
                                rs.getDate("dataFin"),
                                rs.getInt("etaMin"),
                                rs.getInt("limitePers"),
                                rs.getString("stanza")
                        )
        );

    }
}
