package com.workshop.voting_intention.api.controller;
import com.workshop.voting_intention.api.dto.CandiadateDTO;
import com.workshop.voting_intention.model.entity.Candidate;
import com.workshop.voting_intention.dao.CandiadateDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/candidatos")
@RequiredArgsConstructor
public class CandidateController {
    private final CandiadateDAO candidateDAO;

    @PostMapping("/salvar")
    public ResponseEntity salvar(@RequestBody CandiadateDTO dto) {
        Candidate candidate = Candidate.builder().numero(dto.getNumero()).nome(dto.getNome()).build();

        try {
            Candidate candidatoSalvo = candidateDAO.salvarCandidato(candidate);
            return new ResponseEntity<>(candidatoSalvo, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Não foi possivel salvar o candidato");
        }
    }

    @GetMapping
    public ResponseEntity buscarCandidatos() {
        try {
            List<Candidate> candidates = candidateDAO.buscarCandidatos();
            return ResponseEntity.ok(candidates);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Não foi possivel buscar os dados");
        }
    }
}
