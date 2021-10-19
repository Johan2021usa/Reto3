/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Retos.CicloTres.repository;

import com.Retos.CicloTres.model.Partyroom;
import com.Retos.CicloTres.repository.crud.PartyroomCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PartyroomRepository {
    
    @Autowired
    private PartyroomCrudRepository PartyroomCrudRepository;

    public List<Partyroom> getAll(){
        return (List<Partyroom>) PartyroomCrudRepository.findAll();
    }
    public Optional<Partyroom> getPartyroom(int id){
        return PartyroomCrudRepository.findById(id);
    }

    public Partyroom save(Partyroom partyroom){
        return PartyroomCrudRepository.save(partyroom);
    }
    
}
