package com.workshop.voting_intention.model.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "candidato", schema = "voto")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Candidate {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero")
    private Long numero;

    @Column(name = "nome")
    private String nome;

    @Column(name = "imagem")
    private String imagem;

    private Long quantidade;

    private Long total_votos;
}
