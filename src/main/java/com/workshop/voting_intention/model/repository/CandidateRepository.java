package com.workshop.voting_intention.model.repository;

import com.workshop.voting_intention.model.entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {

    String pricipalQuey = "select candidato.*, count(usuario.voto) as quantidade, CAST(CAST(count(usuario.voto) AS float) / CAST((select count(usuario.id) from voto.usuario) AS float) * 100 as NUMERIC(6,2)) AS total_votos from voto.candidato left join voto.usuario ON usuario.voto = candidato.id";
    @Query(
        value = pricipalQuey + " GROUP by candidato.id",
        nativeQuery = true)
    List<Candidate> findAll();

    @Query(
        value = pricipalQuey + " where candidato.numero=? GROUP by candidato.id",
        nativeQuery = true)
    Candidate findByNumero(Long numero);

    @Query(
        value = "insert into voto.candidato (numero, nome, imagem) values (?,?,?)",
        nativeQuery = true)
    Candidate saveCustom(Long numero, String nome, String imagem);

    @Query(
        value = pricipalQuey + " where candidato.id=? GROUP by candidato.id",
        nativeQuery = true)
    Optional<Candidate> findById(Long id);
}
