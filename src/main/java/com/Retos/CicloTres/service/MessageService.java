/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Retos.CicloTres.service;

import com.Retos.CicloTres.model.Message;
import com.Retos.CicloTres.repository.MessageRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;
    
    public List<Message> getAll(){
        return messageRepository.getAll();
    }

    public Optional<Message> getMessage(int id){
        return messageRepository.getMessage(id);
    }

    public Message save(Message mensaje){
        if(mensaje.getIdMessage()==null){
            return messageRepository.save(mensaje);
        }else{
            Optional<Message> paux=messageRepository.getMessage(mensaje.getIdMessage());
            if(paux.isEmpty()){
                return messageRepository.save(mensaje);
            }else{
                return mensaje;
            }
        }
    }
    public Message update(Message mensaje){
        if(mensaje.getIdMessage()!=null){
            Optional<Message>comentario=messageRepository.getMessage(mensaje.getIdMessage());
            if(!comentario.isEmpty()){
                if(mensaje.getMessageText()!=null){
                    comentario.get().setMessageText(mensaje.getMessageText());
                }
                return messageRepository.save(comentario.get());
            }
        }
        return mensaje;
    }
    public boolean deleteMessage(int id){
        Optional<Message> mensaje=getMessage(id);
        if(!mensaje.isEmpty()){
            messageRepository.delete(mensaje.get());
            return true;
        }
        return false;
    }
}
