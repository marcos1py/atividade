package com.n1.atividade.service.impl;

import com.n1.atividade.entity.Consulta;
import com.n1.atividade.entity.StatusConsulta;
import com.n1.atividade.repository.ConsultaRepository;
import com.n1.atividade.service.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ConsultaServiceImpl implements ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Override
    public Consulta createConsulta(Consulta consulta) {
        consulta.setStatus(StatusConsulta.AGENDADA);
        return consultaRepository.save(consulta);
    }

    @Override
    public List<Consulta> getAllConsultas() {
        return consultaRepository.findAll();
    }

    @Override
    public Optional<Consulta> getConsultaById(Long id) {
        return consultaRepository.findById(id);
    }

    @Override
    public Consulta updateConsulta(Long id, Consulta consulta) {
        return consultaRepository.findById(id).map(existing -> {
            existing.setData(consulta.getData());
            existing.setHorario(consulta.getHorario());
            existing.setMedico(consulta.getMedico());
            existing.setPaciente(consulta.getPaciente());
            existing.setStatus(consulta.getStatus());
            return consultaRepository.save(existing);
        }).orElseThrow(() -> new RuntimeException("Consulta não encontrada"));
    }

    @Override
    public void deleteConsulta(Long id) {
        consultaRepository.deleteById(id);
    }
    
    @Override
    public Consulta cancelarConsulta(Long id) {
        return consultaRepository.findById(id).map(existing -> {
            existing.setStatus(StatusConsulta.CANCELADA);
            return consultaRepository.save(existing);
        }).orElseThrow(() -> new RuntimeException("Consulta não encontrada"));
    }

    @Override
    public Consulta realizarConsulta(Long id) {
        return consultaRepository.findById(id).map(existing -> {
            existing.setStatus(StatusConsulta.REALIZADA);
            return consultaRepository.save(existing);
        }).orElseThrow(() -> new RuntimeException("Consulta não encontrada"));
    }
}
