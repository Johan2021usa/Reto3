/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Retos.CicloTres.repository;

import com.Retos.CicloTres.model.Client;
import com.Retos.CicloTres.repository.crud.ClientCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ClientRepository {
    @Autowired
    private ClientCrudRepository clientCrudRepository;
     public List<Client> getAll(){
        return (List<Client>) clientCrudRepository.findAll();
    }
    public Optional<Client>getClient(int id){
        return clientCrudRepository.findById(id);
    }
    public Client save(Client cliente){
        return clientCrudRepository.save(cliente);
    }
    public void delete(Client cliente){
        clientCrudRepository.delete(cliente);
    }
}
