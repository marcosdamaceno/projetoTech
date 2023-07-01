package com.tech.projetoTech.controller;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import com.tech.projetoTech.model.EletroDomestico;
import com.tech.projetoTech.repository.EletrodomesticoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.transform.Source;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/eletrodomestico")
@Api(tags = "EletroDomestico", description = "API para gestão de eletrodomésticos")
public class EletrodomesticoController {
    @Autowired
    private EletrodomesticoRepository eletrodomesticoRepository;

    @PostMapping
    @ApiOperation(value = "Cadastrar um eletrodoméstico")
    public ResponseEntity<EletroDomestico> addEletroDomestico(@Valid @RequestBody EletroDomestico eletroDomestico){
        try {
            EletroDomestico saveEletroDomestico  = eletrodomesticoRepository.save(eletroDomestico) ;
            return new ResponseEntity<>(saveEletroDomestico, HttpStatus.CREATED);
        }catch (Exception e ){
            System.out.println("Erro ao salvar o edereço" + e.getMessage());
            e.printStackTrace();
            return  new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
