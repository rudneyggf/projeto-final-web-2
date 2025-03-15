package com.codex.nova.events.api.controller;

import com.codex.nova.events.api.model.Evento;
import com.codex.nova.events.api.model.Usuario;
import com.codex.nova.events.api.repository.EventosRepository;
import com.codex.nova.events.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/eventos")
@CrossOrigin("*")
public class EventoController {

    @Autowired
    private EventosRepository eventoRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping
    public List<EventoFormRequest> getEventos(){
        return eventoRepository.findAll()
                .stream()
                .map(EventoFormRequest::fromModel)
                .collect(Collectors.toList());
    }

    @GetMapping("/ordenados_prioridade")
    public List<EventoFormRequest> getOrdenadosPrioridade(){
        return eventoRepository.findAllByOrderByPrioridadeAsc()
                .stream()
                .map(EventoFormRequest::fromModel)
                .collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<EventoFormRequest> postEvento(@RequestBody EventoFormRequest eventoFormRequest){
        Evento evento = eventoFormRequest.toModel();

        adicionar_FKey_Evento(eventoFormRequest,evento);
        eventoRepository.save(evento);

        return ResponseEntity.ok(EventoFormRequest.fromModel(evento));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EventoFormRequest> putEvento(@RequestBody EventoFormRequest eventoFormRequest,@PathVariable Long id) {
        Evento evento = eventoRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Evento com id não encontrado: " + id));

        adicionar_FKey_Evento(eventoFormRequest,evento);
        eventoRepository.save(evento);

        return ResponseEntity.ok().body(EventoFormRequest.fromModel(evento));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvento(@PathVariable Long id) {
        eventoRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    public void adicionar_FKey_Evento(EventoFormRequest eventoFormRequest,Evento evento){
        String nick = eventoFormRequest.getUsuarioNickname();
        Usuario usuario = usuarioRepository.findById(nick)
                .orElseThrow(() -> new RuntimeException("Usuario com nick não encontrado: " + nick));
        evento.setUsuario(usuario);
    }
}
