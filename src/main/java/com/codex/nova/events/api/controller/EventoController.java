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
        String nick = eventoFormRequest.getUsuario_nickname();
        Usuario usuario = usuarioRepository.findById(nick)
                .orElseThrow(() -> new RuntimeException("Usuario com nick não encontrado: " + nick));
        evento.setUsuario(usuario);
        eventoRepository.save(evento);

        return ResponseEntity.ok(EventoFormRequest.fromModel(evento));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EventoFormRequest> putEvento(@RequestBody EventoFormRequest request,@PathVariable Long id) {
        Evento evento = request.toModel();

        eventoRepository.save(evento);

        return ResponseEntity.ok().body(EventoFormRequest.fromModel(evento));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvento(@PathVariable Long id) {
        eventoRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
