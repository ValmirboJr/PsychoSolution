package org.example.psychosolution.mapper;

import lombok.experimental.UtilityClass;
import org.example.psychosolution.entity.Consulta;
import org.example.psychosolution.request.ConsultaRequest;
import org.example.psychosolution.response.ConsultaResponse;

@UtilityClass
public class ConsultaMapper {
    public static Consulta toConsulta(ConsultaRequest consultaRequest){
        return Consulta
                .builder()
                .paciente(consultaRequest.paciente())
                .data(consultaRequest.data())
                .status(consultaRequest.status())
                .build();
    }
    public static ConsultaResponse toConsultaResponse(Consulta consulta){
        return ConsultaResponse
                .builder()
                .id(consulta.getId())
                .paciente(consulta.getPaciente())
                .status(consulta.getStatus())
                .data(consulta.getData())
                .build();
    }
}
