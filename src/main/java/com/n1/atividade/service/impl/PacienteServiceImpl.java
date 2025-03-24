package com.n1.atividade.service.impl;

import com.n1.atividade.entity.Paciente;
import com.n1.atividade.repository.PacienteRepository;
import com.n1.atividade.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PacienteServiceImpl implements PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Override
    public Paciente createPaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    @Override
    public List<Paciente> getAllPacientes() {
        return pacienteRepository.findAll();
    }

    @Override
    public Optional<Paciente> getPacienteById(Long id) {
        return pacienteRepository.findById(id);
    }

    @Override
    public Paciente updatePaciente(Long id, Paciente paciente) {
        return pacienteRepository.findById(id).map(existing -> {
            existing.setNome(paciente.getNome());
            existing.setCpf(paciente.getCpf());
            existing.setDataNascimento(paciente.getDataNascimento());
            existing.setTelefone(paciente.getTelefone());
            return pacienteRepository.save(existing);
        }).orElseThrow(() -> new RuntimeException("Paciente não encontrado"));
    }

    @Override
    public void deletePaciente(Long id) {
        pacienteRepository.deleteById(id);
    }
}
