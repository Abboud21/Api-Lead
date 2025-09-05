package br.com.edukacode.api.Controller;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.edukacode.api.Entities.Lead;

import br.com.edukacode.api.Repository.LeadRepository;
import br.com.edukacode.api.dto.DadosAtualizarLead;
import br.com.edukacode.api.dto.DadosCadastroLead;
import br.com.edukacode.api.dto.DadosListagemLead;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/lead")
public class LeadController {

    @Autowired //injeção de dependência
    private LeadRepository repository;

    @PostMapping
    @Transactional
    public String criarLead(@RequestBody @Valid DadosCadastroLead dados) {
        // Lógica para criar um lead
        System.out.println("Leade criado com os dados: " + dados);
        repository.save(new Lead(null,dados.nome(), dados.email(), dados.telefone(), dados.cpf()));
        return "Lead criado com sucesso!";
    }

    @GetMapping
    public Page<DadosListagemLead> listarLeads(@PageableDefault(size = 15, sort = {"nome"}) Pageable paginacao) {
        //implementação da listagem de leads
        return repository.findAll(paginacao).map(DadosListagemLead::new);
    }

    @PutMapping
    @Transactional
    public void atualizarLead(@RequestBody DadosAtualizarLead dados) {
        // Lógica para atualizar um lead
        var lead = repository.getReferenceById(dados.id());
        lead.atualizarInformacoesLead(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluirLead(@PathVariable Long id) {
        // Implementação do metodo para excluir um lead
        repository.deleteById(id);
    }
    
}
