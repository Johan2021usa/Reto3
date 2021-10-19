/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Retos.CicloTres.repository.crud;

import com.Retos.CicloTres.model.Message;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Juan Camilo
 */
public interface MessageCrudRepository extends CrudRepository<Message, Integer>{
    
}
