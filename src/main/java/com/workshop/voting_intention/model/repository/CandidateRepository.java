package com.workshop.voting_intention.model.repository;

import com.workshop.voting_intention.model.entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {

    @Query(value = "select candidato.*, count(usuario.voto) as quantidade, (select count(usuario.id) from voto.usuario) as total_votos from voto.candidato left join voto.usuario ON usuario.voto = candidato.id GROUP by candidato.id", nativeQuery = true)
    List<Candidate> findAll();
}
