package br.com.edukacode.api.dto;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarGenero(
    @NotNull 
    Long id, 
    String nome) {
    
}
