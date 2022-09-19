package com.workshop.voting_intention.dao.impl;
import com.workshop.voting_intention.dao.CandiadateDAO;
import com.workshop.voting_intention.model.entity.Candidate;
import com.workshop.voting_intention.model.repository.CandidateRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateDAOImpl implements CandiadateDAO{
    private CandidateRepository repository;

    public CandidateDAOImpl(CandidateRepository repository) {
        super();
        this.repository = repository;
    }

    @Override
    public Candidate salvarCandidato(Candidate candidato) {
        return repository.save(candidato);
    }

    @Override
    public List<Candidate> buscarCandidatos() {
        return repository.findAll();
    }
    
}
