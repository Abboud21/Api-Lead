package br.com.edukacode.api.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.edukacode.api.Entities.Genero;
import br.com.edukacode.api.Repository.GeneroRepository;
import br.com.edukacode.api.dto.DadosCadastroGenero;
import br.com.edukacode.api.dto.DadosListagemGenero;

import org.springframework.web.bind.annotation.RequestBody;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/genero")

public class GeneroController {

    @Autowired
    private GeneroRepository repository;

    @PostMapping
    @Transactional
    public String criarGenero(@RequestBody @Valid DadosCadastroGenero dados) {
        System.out.println("Genero criado com sucesso: ");
        repository.save(new Genero(null, dados.nome()));
        return "Gênero criado com sucesso!";
    }

    @GetMapping
    public Page<DadosListagemGenero> listarGeneros(@PageableDefault(size = 5, sort = {"nome"}) Pageable paginacao) {
        return repository.findAll(paginacao).map(DadosListagemGenero::new);
    }

    

}
