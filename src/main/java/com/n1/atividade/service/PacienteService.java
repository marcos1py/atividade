package com.n1.atividade.service;

import com.n1.atividade.entity.Paciente;
import java.util.List;
import java.util.Optional;

public interface PacienteService {
    Paciente createPaciente(Paciente paciente);
    List<Paciente> getAllPacientes();
    Optional<Paciente> getPacienteById(Long id);
    Paciente updatePaciente(Long id, Paciente paciente);
    void deletePaciente(Long id);
}
