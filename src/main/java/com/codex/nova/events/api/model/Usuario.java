package com.codex.nova.events.api.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "usuario")
@NoArgsConstructor
@AllArgsConstructor
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

}
