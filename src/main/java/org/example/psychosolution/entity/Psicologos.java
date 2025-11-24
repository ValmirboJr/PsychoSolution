package org.example.psychosolution.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "psicologos")
@Entity
public class Psicologos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    private String nome;

    private String email;

    private String telefone;

    @Column(unique = true)
    private String crp;

    private String senha;
}
