package com.workshop.voting_intention.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CandiadateDTO {
    private Long numero;
    private String nome;
    private String imagem;
}