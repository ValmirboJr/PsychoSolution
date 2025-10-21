package service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import model.Consulta;
import repository.ConsultaRepository;

@Service
public class ConsultaService {
    private final ConsultaRepository consultaRepository;

    @Autowired
    public ConsultaService(ConsultaRepository consultaRepository) {
        this.consultaRepository = consultaRepository;
    }

    @Transactional
    public Consulta agendarConsulta(Consulta consulta){
        consulta.setStatus("AGENDADA");
        return consultaRepository.save(consulta);
    }

    @Transactional
    public void cancelarConsulta(Long consultaId){
        if (consultaRepository.existsById(consultaId)) {
            consultaRepository.deleteById(consultaId);
        }
    }

    public List<Consulta> listarConsultas(){
        return consultaRepository.findAll();
    }
}
