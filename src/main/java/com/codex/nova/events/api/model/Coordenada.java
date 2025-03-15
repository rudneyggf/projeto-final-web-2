package com.codex.nova.events.api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Coordenada {

    @Column(name = "coordenada_x")
    private double x;

    @Column(name = "coordenada_y")
    private double y;


    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Coordenada(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Coordenada() {
        super();
    }
}
