package br.com.edukacode.api.Entities;

import br.com.edukacode.api.dto.DadosCadastroGenero;
import br.com.edukacode.api.dto.DadosAtualizarGenero;
import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;


@Entity(name = "tbgenero")
@Table(name = "Genero")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Genero {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    public Genero(DadosCadastroGenero dados) {
        this.id = null;
        this.nome = dados.nome();
    }
    
    public void atualizarInformacoesGenero(DadosAtualizarGenero dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
    }
    
}


