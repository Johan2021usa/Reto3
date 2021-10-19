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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="category")
public class Category implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name="id", columnDefinition = "number")
    private Integer id;
    @Column(name="name", columnDefinition = "varchar(45)")
    private String name;
    @Column(name="description", columnDefinition = "varchar(250)")
    private String description;

    //Uno a muchos Categoria-Partyroom
    
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "category")
    @JsonIgnoreProperties({"partyroom", "category"})
    public List<Partyroom> partyrooms;
    

    public List<Partyroom> getPartyrooms() {
        return partyrooms;
    }

    public void setPartyrooms(List<Partyroom> partyrooms) {
        this.partyrooms = partyrooms;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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


    
}

//package com.Retos.CicloTres.model;
//
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import java.io.Serializable;
//import java.util.List;
//import javax.persistence.CascadeType;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.OneToMany;
//import javax.persistence.Table;
//
//@Entity
//@Table(name="category")
//public class Category implements Serializable{
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//     
//    private Integer id;
//    private String name;
//    private String description;
//
//    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "category")
//    @JsonIgnoreProperties("category")
//    public List<Client> client;
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//
//    
//}
