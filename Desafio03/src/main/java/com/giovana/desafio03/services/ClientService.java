package com.giovana.desafio03.services;

import com.giovana.desafio03.entities.Client;
import com.giovana.desafio03.repositories.ClientRepository;
import com.giovana.desafio03.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService {

    @Autowired
    ClientRepository repository;

    // Busca de recurso por id - falta adicionar a exceção
    @Transactional(readOnly = true)
    public Client findById(Long id){
        Client client = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Não existe um cliente com o ID informado"));
        return client;
    }

    // Busca paginada de recursos
    @Transactional(readOnly = true)
    public Page<Client> findAll(Pageable pageable){
        Page<Client> result =  repository.findAll(pageable);
        return result.map(x -> new Client(x));
    }

    // Inserir novo recurso
    @Transactional
    public Client insert(Client client){
        repository.save(client);
        return client;
    }

    // Atualizar recurso
    @Transactional
    public Client update(Long id, Client client){
        try{
            Client c = repository.getReferenceById(id);
            updateData(client, c);
            c = repository.save(c);
            return new Client(c);
        }catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("Não existe um cliente com o ID informado");
        }


    }

    private void updateData(Client client, Client c){
        c.setName(client.getName());
        c.setCpf(client.getCpf());
        c.setIncome(client.getIncome());
        c.setBirthDate(client.getBirthDate());
        c.setChildren(client.getChildren());
    }

    // Deletar recurso
    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete (Long id){
        if (!repository.existsById(id)){
            throw new ResourceNotFoundException("Não existe um cliente com o ID informado");
        }
        repository.deleteById(id);
    }

}
