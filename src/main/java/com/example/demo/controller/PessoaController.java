package com.example.demo.controller;


import com.example.demo.model.Pessoa;
import com.example.demo.repository.RepositorioDePessoas;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@RestController
public class PessoaController {

    private final RepositorioDePessoas repositorio;

    public PessoaController(RepositorioDePessoas repositorio) {
        this.repositorio = repositorio;
    }

    @GetMapping("/pessoas")
    public List<Pessoa> listar() {
        return repositorio.listarPessoas();
    }
}
