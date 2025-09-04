package br.com.edukacode.api.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")

public class HelloController {
    @GetMapping

    public String mostrarMensagem() {
        return "Hello, World!";
    }
    @PostMapping
    public String criarMensagem(@RequestBody String json){
        System.out.println("Mensagem recebida: " + json);
        return "Mensagem recebida com sucesso!";
    }

}
