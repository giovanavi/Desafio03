package com.giovana.desafio03.controllers;

import com.giovana.desafio03.entities.Client;
import com.giovana.desafio03.services.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {

    @Autowired
    ClientService service;

    // Busca de recurso por id
    @GetMapping(value = "/{id}")
    public ResponseEntity<Client> findById(@PathVariable Long id){
        Client client = service.findById(id);
        return ResponseEntity.ok(client);
    }

//    // Busca paginada de recursos
//    @GetMapping
//    public ResponseEntity<Page<Client>> findAll(Pageable pageable){
//        Page<Client> result =service.findAll(pageable);
//        return ResponseEntity.ok(result);
//    }
//
//    // Inserir novo recurso
//    @PostMapping
//    public ResponseEntity<Client> insert(@Valid @RequestBody Client client){
//        service.insert(client);
//        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
//                .buildAndExpand(client.getId()).toUri();
//        return ResponseEntity.created(uri).body(client);
//    }
//
//    // Atualizar recurso
//    @PutMapping(value = "/{id}")
//    public ResponseEntity<Client> update(@PathVariable Long id, @Valid @RequestBody Client client){
//        service.update(id, client);
//        return ResponseEntity.ok(client);
//    }
//
//    // Deletar recurso
//    @DeleteMapping(value = "/{id}")
//    public ResponseEntity<Client> update(@PathVariable Long id){
//        service.delete(id);
//        return ResponseEntity.noContent().build();
//    }
}
