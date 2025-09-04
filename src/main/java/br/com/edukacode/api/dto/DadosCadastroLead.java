package br.com.edukacode.api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroLead(
    @NotNull
    Long id,

    @NotBlank
    String nome, 

    @NotBlank
    @Email
    String email, 

    @NotBlank
    @Pattern(regexp = "\\d{10,11}")
    String telefone,

    @NotBlank
    @Pattern(regexp = "\\d{12}")
    String cpf) {}