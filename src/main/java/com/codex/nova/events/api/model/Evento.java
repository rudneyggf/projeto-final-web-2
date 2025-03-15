package com.codex.nova.events.api.model;

import com.codex.nova.events.api.model.enums.Tipo;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;
import java.util.Date;


@Entity
@Table(name = "eventos")
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    @Column(nullable = false)
    private Coordenada coordenada;

    @Column(nullable = false)
    private String descricao;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Tipo tipo;

    @Min(1)
    @Max(3)
    private int prioridade;

    @ManyToOne @JoinColumn(nullable = false, name = "usuario_nickname")
    private Usuario usuario;

    @CreationTimestamp
    @Column(nullable = false, updatable = false, name = "data_cadastro")
    private LocalDateTime dataHoraCadastro;

    @Column(nullable = false,name = "data_inicio")
    private Date dataInicio;

    @Column(nullable = false, name = "horas_duracao")
    private int horasDuracao;


    public Long getId() {
        return id;
    }

    public Coordenada getCoordenada() {
        return coordenada;
    }
    public String getDescricao() {
        return descricao;
    }
    public Tipo getTipo() {
        return tipo;
    }
    public int getPrioridade() {
        return prioridade;
    }
    public Usuario getUsuario() {
        return usuario;
    }
    public LocalDateTime getDataHoraCadastro() {
        return dataHoraCadastro;
    }
    public Date getDataInicio() {
        return dataInicio;
    }
    public int getHorasDuracao() {
        return horasDuracao;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setCoordenada(Coordenada coordenada) {
        this.coordenada = coordenada;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }
    public void setHorasDuracao(int horasDuracao) {
        this.horasDuracao = horasDuracao;
    }

    public Evento(){
        super();
    }

    public Evento(Long id, Coordenada coordenada, String descricao, Tipo tipo, int prioridade, Date dataInicio, int horasDuracao) {

        this.id = id;
        this.coordenada = coordenada;
        this.descricao = descricao;
        this.tipo = tipo;
        this.prioridade = prioridade;
        this.dataInicio = dataInicio;
        this.horasDuracao = horasDuracao;

        if (prioridade < 1 || prioridade > 3) {
            throw new IllegalArgumentException("A prioridade deve estar entre 1 e 3.");
        }
    }

    public Evento(Long id, Coordenada coordenada, String descricao, Tipo tipo, int prioridade, Usuario usuario,
                  LocalDateTime dataHoraCadastro,Date dataInicio, int horasDuracao) {
        this.id = id;
        this.coordenada = coordenada;
        this.descricao = descricao;
        this.tipo = tipo;
        this.prioridade = prioridade;
        this.usuario = usuario;
        this.dataHoraCadastro = dataHoraCadastro;
        this.dataInicio = dataInicio;
        this.horasDuracao = horasDuracao;

        if (prioridade < 1 || prioridade > 3) {
            throw new IllegalArgumentException("A prioridade deve estar entre 1 e 3.");
        }
    }



    public void setPrioridade(int prioridade) {
        if (prioridade < 1 || prioridade > 3) {
            throw new IllegalArgumentException("A prioridade deve estar entre 1 e 3.");
        }
        this.prioridade = prioridade;
    }

}
