package com.n1.atividade.service;

import com.n1.atividade.entity.Medico;
import java.util.List;
import java.util.Optional;

public interface MedicoService {
    Medico createMedico(Medico medico);
    List<Medico> getAllMedicos();
    Optional<Medico> getMedicoById(Long id);
    Medico updateMedico(Long id, Medico medico);
    void deleteMedico(Long id);
}
