/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Retos.CicloTres.service;

import com.Retos.CicloTres.model.Client;
import com.Retos.CicloTres.repository.ClientRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;
    public List<Client> getAll(){
        return clientRepository.getAll();
    }

    public Optional<Client> getClient(int id){
        return clientRepository.getClient(id);
    }

    public Client save(Client cliente){
        if(cliente.getIdClient()==null){
            return clientRepository.save(cliente);
        }else{
            Optional<Client> paux=clientRepository.getClient(cliente.getIdClient());
            if(paux.isEmpty()){
                return clientRepository.save(cliente);
            }else{
                return cliente;
            }
        }
    }
}
