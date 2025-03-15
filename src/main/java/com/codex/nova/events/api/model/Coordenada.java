package com.codex.nova.events.api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Coordenada {

    @Column(name = "coordenada_x")
    private double x;

    @Column(name = "coordenada_y")
    private double y;
}
