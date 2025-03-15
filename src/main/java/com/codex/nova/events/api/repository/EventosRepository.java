package com.codex.nova.events.api.repository;

import com.codex.nova.events.api.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventosRepository extends JpaRepository<Evento,Long> {
    List<Evento> findAllByOrderByPrioridadeAsc();
}
