package br.com.edukacode.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroGenero(
    @NotNull
    Long id,
    @NotBlank
    String nome) {}
