package org.example.psychosolution.mapper;

import lombok.experimental.UtilityClass;
import org.example.psychosolution.entity.Psicologos;
import org.example.psychosolution.request.PsicologosRequest;
import org.example.psychosolution.response.PsicologosResponse;

@UtilityClass
public class PsicologosMapper {

    public static Psicologos toPsicologos(PsicologosRequest request) {
        return Psicologos
                .builder()
                .nome(request.nome())
                .senha(request.senha())
                .email(request.email())
                .crp(request.crp())
                .telefone(request.telefone())
                .build();
    }
    public static PsicologosResponse toPsicologosResponse(Psicologos psicologos) {
        return PsicologosResponse
                .builder()
                .id(psicologos.getId())
                .email(psicologos.getEmail())
                .crp(psicologos.getCrp())
                .telefone(psicologos.getTelefone())
                .build();
    }
}
