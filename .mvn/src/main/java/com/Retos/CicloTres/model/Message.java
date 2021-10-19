/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Retos.CicloTres.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="message")
public class Message implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idMessage", columnDefinition = "number")
    private Integer idMessage;
    @Column(name="messageText", columnDefinition = "varchar(250)")
    private String messageText;

    //Relacion uno a uno mensajes - partyroom
    @OneToOne(cascade = {CascadeType.PERSIST},mappedBy = "messages")
    @JsonIgnoreProperties("messages")
    public Partyroom partyrooms;

    public Partyroom getPartyrooms() {
        return partyrooms;
    }

    public void setPartyrooms(Partyroom partyrooms) {
        this.partyrooms = partyrooms;
    }

    
    
    public Integer getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }



    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }
    


}



