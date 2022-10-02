package com.workshop.voting_intention.dao.impl;
import com.workshop.voting_intention.dao.CandidateDAO;
import com.workshop.voting_intention.model.entity.Candidate;
import com.workshop.voting_intention.model.repository.CandidateRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CandidateDAOImpl implements CandidateDAO{
    private CandidateRepository repository;

    public CandidateDAOImpl(CandidateRepository repository) {
        super();
        this.repository = repository;
    }

    @Override
    public Candidate salvarCandidato(Candidate candidato) {
        return repository.saveCustom(candidato.getNumero(), candidato.getNome(), candidato.getImagem());
    }

    @Override
    public List<Candidate> buscarCandidatos() {
        return repository.findAll();
    }

    @Override
    public Candidate obterPorNumero(Long numero) {
        return repository.findByNumero(numero);
    }

    @Override
    public Optional<Candidate> obterPorId(Long id) {
        return repository.findById(id);
    }
    
}
