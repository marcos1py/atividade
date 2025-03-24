package com.n1.atividade.service;

import com.n1.atividade.entity.Consulta;
import java.util.List;
import java.util.Optional;

public interface ConsultaService {
    Consulta createConsulta(Consulta consulta);
    List<Consulta> getAllConsultas();
    Optional<Consulta> getConsultaById(Long id);
    Consulta updateConsulta(Long id, Consulta consulta);
    void deleteConsulta(Long id);
    
    // Métodos para atualizar o status da consulta
    Consulta cancelarConsulta(Long id);
    Consulta realizarConsulta(Long id);
}
