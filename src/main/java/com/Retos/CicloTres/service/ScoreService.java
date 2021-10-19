/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Retos.CicloTres.service;

import com.Retos.CicloTres.model.Score;
import com.Retos.CicloTres.repository.ScoreRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScoreService {
    @Autowired
    private ScoreRepository scoreRepository;

    public List<Score> getAll(){
        return scoreRepository.getAll();
    }

    public Optional<Score> getScore(int id){
        return scoreRepository.getScore(id);
    }

    public Score save(Score puntaje){
        if(puntaje.getIdScore()==null){
            return scoreRepository.save(puntaje);
        }else{
            Optional<Score> paux=scoreRepository.getScore(puntaje.getIdScore());
            if(paux.isEmpty()){
                return scoreRepository.save(puntaje);
            }else{
                return puntaje;
            }
        }
    }
    public Score update(Score puntaje){
        if(puntaje.getIdScore()!=null){
            Optional<Score>puntos=scoreRepository.getScore(puntaje.getIdScore());
            if(!puntos.isEmpty()){
                if(puntaje.getCalificacion()!=null){
                    puntos.get().setCalificacion(puntaje.getCalificacion());
                }
                if(puntaje.getMensaje()!=null){
                    puntos.get().setMensaje(puntaje.getMensaje());
                }
        }
        }
        return puntaje;
    }
    
    public boolean deleteScore(int id){
        Optional<Score> puntaje=getScore(id);
        if(!puntaje.isEmpty()){
            scoreRepository.delete(puntaje.get());
            return true;
        }
        return false;
    }
}
