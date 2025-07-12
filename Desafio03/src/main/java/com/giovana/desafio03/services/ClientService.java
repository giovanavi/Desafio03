package com.giovana.desafio03.services;

import com.giovana.desafio03.entities.Client;
import com.giovana.desafio03.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    ClientRepository repository;

    // Busca de recurso por id - falta adicionar a exceção
    @Transactional(readOnly = true)
    public Client findById(Long id){
        Optional<Client> result = repository.findById(id);
        return result.orElse(null);
    }

//    // Busca paginada de recursos
//    @Transactional(readOnly = true)
//    public Page<Client> findAll(Pageable pageable){
//        Page<Client> result =  repository.findAll(pageable);
//        return result.map(x -> new Client(x));
//    }
//
//    // Inserir novo recurso
//    @Transactional
//    public Client insert(Client client){
//        repository.save(client);
//        return client;
//    }
//
//    // Atualizar recurso
//    @Transactional
//    public Client update(Long id, Client client){
//        Client c = repository.getReferenceById(id);
//        c = client;
//        return new Client(c);
//    }
//
//    // Deletar recurso
//    @Transactional(propagation = Propagation.SUPPORTS)
//    public void delete (Long id){
//        repository.deleteById(id);
//    }

}
