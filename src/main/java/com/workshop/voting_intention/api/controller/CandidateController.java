package com.workshop.voting_intention.api.controller;
import com.workshop.voting_intention.api.dto.CandiadateDTO;
import com.workshop.voting_intention.model.entity.Candidate;
import com.workshop.voting_intention.dao.CandidateDAO;
import com.workshop.voting_intention.factory.PersonFactory;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/candidatos")
@RequiredArgsConstructor
public class CandidateController implements PersonFactory{
    private final CandidateDAO candidateDAO;

    @PostMapping("/salvar")
    public ResponseEntity salvar(@RequestBody CandiadateDTO dto) {
        Candidate candidate = Candidate.builder().numero(dto.getNumero()).nome(dto.getNome()).imagem(dto.getImagem()).build();

        try {
            Candidate candidatoSalvo = candidateDAO.salvarCandidato(candidate);
            return new ResponseEntity<>(candidatoSalvo, HttpStatus.CREATED);
        } catch (Exception e) {
            if (e.getCause().getCause().getMessage().contains("candidato_numero_key")) {
                return ResponseEntity.badRequest().body("Já existe o número do candidato cadastrado");
            }
            return ResponseEntity.badRequest().body("Não foi possivel salvar o candidato");
        }
    }

    @Override
    @GetMapping
    public ResponseEntity busca() {
        try {
            List<Candidate> candidates = candidateDAO.buscarCandidatos();
            return ResponseEntity.ok(candidates);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Não foi possivel buscar os dados");
        }
    }

    @GetMapping("{id}")
    public ResponseEntity buscaPorId(@PathVariable("id") Long id) {
        Optional<Candidate> candidate = candidateDAO.obterPorId(id);

        try {
            if (candidate.isEmpty() || candidate == null) {
                return ResponseEntity.badRequest().body("Este candidato não foi encontrado em nosso banco de dados");
            }
            return ResponseEntity.ok(candidate);
        } catch (Exception e ) {
            return ResponseEntity.badRequest().body("Não foi possivel buscar o usuario");
        }
    }
}
