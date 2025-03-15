package com.codex.nova.events.api.controller;

import com.codex.nova.events.api.model.Coordenada;
import com.codex.nova.events.api.model.Evento;
import com.codex.nova.events.api.model.Usuario;
import com.codex.nova.events.api.model.enums.Tipo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@NoArgsConstructor
public class EventoFormRequest {


    private Long id;

    private Coordenada coordenada;

    private String descricao;

    private Tipo tipo;

    private int prioridade;

    private String usuario_nickname;

    private Date dataInicio;

    private int horasDuracao;


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Coordenada getCoordenada() {
        return coordenada;
    }
    public void setCoordenada(Coordenada coordenada) {
        this.coordenada = coordenada;
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public Tipo getTipo() {
        return tipo;
    }
    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
    public int getPrioridade() {
        return prioridade;
    }
    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }
    public String getUsuarioNickname() {
        return usuario_nickname;
    }
    public void setUsuarioNickname(String usuarioNickname) {
        this.usuario_nickname = usuarioNickname;
    }

    public Date getDataInicio() {
        return dataInicio;
    }
    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }
    public int getHorasDuracao() {
        return horasDuracao;
    }
    public void setHorasDuracao(int horasDuracao) {
        this.horasDuracao = horasDuracao;
    }

    public EventoFormRequest(Long id, Coordenada coordenada, String descricao, Tipo tipo, String usuario_nickname, int prioridade, Date dataInicio, int horasDuracao) {
        this.id = id;
        this.coordenada = coordenada;
        this.descricao = descricao;
        this.tipo = tipo;
        this.usuario_nickname = usuario_nickname;
        this.prioridade = prioridade;
        this.dataInicio = dataInicio;
        this.horasDuracao = horasDuracao;

    }

    public Evento toModel(){
        return new Evento(id,coordenada,descricao,tipo,prioridade,dataInicio,horasDuracao);
    }

    public static EventoFormRequest fromModel(Evento model){
        return new EventoFormRequest(model.getId(),model.getCoordenada(),model.getDescricao(),
                model.getTipo(),model.getUsuario().getNickname(), model.getPrioridade(),model.getDataInicio(),model.getHorasDuracao());
    }

}
