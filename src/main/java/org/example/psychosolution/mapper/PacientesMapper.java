package org.example.psychosolution.mapper;

import lombok.experimental.UtilityClass;
import org.example.psychosolution.entity.Pacientes;
import org.example.psychosolution.request.PacientesRequest;
import org.example.psychosolution.response.PacientesResponse;

@UtilityClass
public class PacientesMapper {

    public static Pacientes toPacientes(PacientesRequest pacientesRequest) {
        return Pacientes
                .builder()
                .nome(pacientesRequest.nome())
                .cpf(pacientesRequest.cpf())
                .idade(pacientesRequest.idade())
                .telefone(pacientesRequest.telefone())
                .email(pacientesRequest.email())
                .senha(pacientesRequest.senha())
                .dataNascimento(pacientesRequest.dataNascimento())
                .build();
    }

    public static PacientesResponse toPacientesResponse(Pacientes pacientes) {
        return PacientesResponse
                .builder()
                .id(pacientes.getId())
                .nome(pacientes.getNome())
                .cpf(pacientes.getCpf())
                .telefone(pacientes.getTelefone())
                .email(pacientes.getEmail())
                .idade(pacientes.getIdade())
                .dataNascimento(pacientes.getDataNascimento())
                .build();
    }
}
