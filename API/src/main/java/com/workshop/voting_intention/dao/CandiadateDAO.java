package com.workshop.voting_intention.dao;

import com.workshop.voting_intention.model.entity.Candidate;

import java.util.List;

public interface CandiadateDAO {

    Candidate salvarCandidato(Candidate candidato);

    List<Candidate> buscarCandidatos();
}
