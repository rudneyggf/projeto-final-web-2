package com.codex.nova.events.api.model;

import jakarta.persistence.*;
@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    private String nickname;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String senha;

    public String getNickname() {
        return nickname;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Usuario(String nickname, String email, String senha) {
        this.nickname = nickname;
        this.email = email;
        this.senha = senha;
    }

    public Usuario() {
        super();
    }
}
