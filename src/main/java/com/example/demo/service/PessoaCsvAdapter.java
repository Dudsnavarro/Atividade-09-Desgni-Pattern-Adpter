package com.example.demo.service;


import com.example.demo.model.Pessoa;
import com.example.demo.repository.RepositorioDePessoas;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
@Service
public class PessoaCsvAdapter implements RepositorioDePessoas {

    private final String caminhoArquivo = "pessoas.csv";

    @Override
    public List<Pessoa> listarPessoas() {
        List<Pessoa> pessoas = new ArrayList<>();
        try {
            var resource = new ClassPathResource(caminhoArquivo);
            BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()));
            String linha;
            boolean primeira = true;
            while ((linha = reader.readLine()) != null) {
                if (primeira) {
                    primeira = false; // Ignorar cabeçalho
                    continue;
                }
                String[] campos = linha.split(",");
                Pessoa p = new Pessoa(campos[0], Integer.parseInt(campos[1]), campos[2]);
                pessoas.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pessoas;
    }
}