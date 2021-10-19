/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Retos.CicloTres.service;

import com.Retos.CicloTres.model.Partyroom;
import com.Retos.CicloTres.repository.PartyroomRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PartyroomService {
    @Autowired
    private PartyroomRepository partyroomRepository;

    public List<Partyroom> getAll(){
        return partyroomRepository.getAll();
    }

    public Optional<Partyroom> getPartyroom(int id){
        return partyroomRepository.getPartyroom(id);
    }

    public Partyroom save(Partyroom partyroom){
        if(partyroom.getId()==null){
            return partyroomRepository.save(partyroom);
        }else{
            Optional<Partyroom> paux=partyroomRepository.getPartyroom(partyroom.getId());
            if(paux.isEmpty()){
                return partyroomRepository.save(partyroom);
            }else{
                return partyroom;
            }
        }
    }
}
