package com.n1.atividade.controller;

import com.n1.atividade.entity.Consulta;
import com.n1.atividade.service.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/consultas")
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;

    @PostMapping
    public ResponseEntity<Consulta> createConsulta(@RequestBody Consulta consulta) {
        return ResponseEntity.ok(consultaService.createConsulta(consulta));
    }

    @GetMapping
    public ResponseEntity<List<Consulta>> getAllConsultas() {
        return ResponseEntity.ok(consultaService.getAllConsultas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Consulta> getConsultaById(@PathVariable Long id) {
        return consultaService.getConsultaById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Consulta> updateConsulta(@PathVariable Long id, @RequestBody Consulta consulta) {
        try {
            Consulta updated = consultaService.updateConsulta(id, consulta);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConsulta(@PathVariable Long id) {
        consultaService.deleteConsulta(id);
        return ResponseEntity.noContent().build();
    }
    
    // Endpoint para cancelar a consulta
    @PutMapping("/{id}/cancelar")
    public ResponseEntity<Consulta> cancelarConsulta(@PathVariable Long id) {
        try {
            Consulta updated = consultaService.cancelarConsulta(id);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    // Endpoint para marcar a consulta como realizada
    @PutMapping("/{id}/realizar")
    public ResponseEntity<Consulta> realizarConsulta(@PathVariable Long id) {
        try {
            Consulta updated = consultaService.realizarConsulta(id);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
