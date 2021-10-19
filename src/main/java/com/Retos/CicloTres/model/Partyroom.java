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
import javax.persistence.Table;

@Entity
@Table(name="partyroom")
public class Partyroom implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", columnDefinition = "number")
    private Integer id;
    @Column(name="name", columnDefinition = "varchar(45)")
    private String name;
    @Column(name="owner", columnDefinition = "varchar(45)")
    private String owner;
    @Column(name="capacity", columnDefinition = "number")
    private Integer capacity;
    @Column(name="description", columnDefinition = "varchar(250)")
    private String description;

    
    //Relacion muchos a uno partyroom - categoria
    @ManyToOne
    @JoinColumn(name="category")
    @JsonIgnoreProperties("partyrooms")
    private Category category;

    //Relacion uno a muchos partyroom - mensajes
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "partyroom")
    @JsonIgnoreProperties({"partyroom","client"})
    public List<Message> messages;

    //Relacion uno a muchos partyroom - reservas
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "partyroom")
    @JsonIgnoreProperties("partyroom")
    public List<Reservation> reservations;

    
    
    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
     
    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
    
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
   
    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
        public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}



