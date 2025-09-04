package br.com.edukacode.api.dto;

import br.com.edukacode.api.Entities.Genero;

public record DadosListagemGenero(String nome) {
    
    public DadosListagemGenero(Genero genero) {
        this(genero.getNome());
    }

}
