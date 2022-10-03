package com.workshop.voting_intention.dao;

import com.workshop.voting_intention.model.entity.Candidate;

import java.util.List;
import java.util.Optional;

public interface CandidateDAO {

    Candidate salvarCandidato(Candidate candidato);

    List<Candidate> buscarCandidatos();

    Candidate obterPorNumero(Long numero);
    
    Optional<Candidate> obterPorId(Long id);
}
