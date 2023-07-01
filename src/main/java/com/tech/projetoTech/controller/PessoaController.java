package com.tech.projetoTech.controller;

import com.tech.projetoTech.model.Pessoa;
import com.tech.projetoTech.repository.PessoaRepository;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;

    @PostMapping
    public ResponseEntity<Pessoa>addPessoa(@Valid @RequestBody Pessoa pessoa) {
        try {
            Pessoa savePessoa = pessoaRepository.save(pessoa);
            return new ResponseEntity<>(savePessoa, HttpStatus.CREATED);
        } catch (Exception e){
            System.out.println("Erro ao salvar o pessoa: " + e.getMessage());
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
