package br.com.edukacode.api.dto;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarLead(
    @NotNull
    Long id, 
    String nome, 
    String email, 
    String telefone, 
    String cpf) {

}
