package com.codex.nova.events.api.model;

import com.codex.nova.events.api.model.enums.Tipo;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;
import java.util.Date;


@Entity
@Table(name = "eventos")
@Getter
@NoArgsConstructor
public class Eventos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter
    private Long id;

    @Embedded
    @Column(nullable = false)
    @Setter
    private Coordenada coordenada;

    @Column(nullable = false)
    @Setter
    private String descricao;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @Setter
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
    private int HorasDuracao;


    public Eventos(Coordenada coordenada, String descricao, Tipo tipo, int prioridade, Usuario usuario,
                   LocalDateTime dataHoraCadastro, int HorasDuracao) {
        this.coordenada = coordenada;
        this.descricao = descricao;
        this.tipo = tipo;
        this.prioridade = prioridade;
        this.usuario = usuario;
        this.dataHoraCadastro = dataHoraCadastro;
        this.HorasDuracao = HorasDuracao;

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
