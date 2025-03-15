package com.codex.nova.events.api.model;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Entity
@Table(name = "usuario")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id
    private String nickname;

    @Setter
    @Column(nullable = false)
    private String email;

    @Setter
    @Column(nullable = false)
    private String senha;

}
