package com.n1.atividade.service.impl;

import com.n1.atividade.entity.Medico;
import com.n1.atividade.repository.MedicoRepository;
import com.n1.atividade.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MedicoServiceImpl implements MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    @Override
    public Medico createMedico(Medico medico) {
        return medicoRepository.save(medico);
    }

    @Override
    public List<Medico> getAllMedicos() {
        return medicoRepository.findAll();
    }

    @Override
    public Optional<Medico> getMedicoById(Long id) {
        return medicoRepository.findById(id);
    }

    @Override
    public Medico updateMedico(Long id, Medico medico) {
        return medicoRepository.findById(id).map(existing -> {
            existing.setNome(medico.getNome());
            existing.setEspecialidade(medico.getEspecialidade());
            existing.setCrm(medico.getCrm());
            return medicoRepository.save(existing);
        }).orElseThrow(() -> new RuntimeException("Médico não encontrado"));
    }

    @Override
    public void deleteMedico(Long id) {
        medicoRepository.deleteById(id);
    }
}
