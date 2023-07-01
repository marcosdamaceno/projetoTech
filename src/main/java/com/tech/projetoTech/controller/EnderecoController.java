package com.tech.projetoTech.controller;
import com.tech.projetoTech.model.Endereco;
import com.tech.projetoTech.repository.EnderecoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {
    @Autowired
    private EnderecoRepository enderecoRepository;

    @PostMapping
    public ResponseEntity<Endereco> addEndereco(@Valid @RequestBody Endereco endereco){
        System.out.println(endereco.getBairro());

        try {
            Endereco  saveEndereco = enderecoRepository.save(endereco);
            return new ResponseEntity<>(saveEndereco, HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println("Erro ao salvar o endereço: " + e.getMessage());
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}