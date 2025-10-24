package org.example.psychosolution.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public record PacientesRequest(String nome,
                               String cpf,
                               int idade,
                               String telefone,
                               String email,
                               String senha,
                               @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
                               LocalDate dataNascimento
                               ) {
}
