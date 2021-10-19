/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Retos.CicloTres.repository;

import com.Retos.CicloTres.model.Admin;
import com.Retos.CicloTres.repository.crud.AdminCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AdminRepository {
    @Autowired
    private AdminCrudRepository adminCrudRepository;

    public List<Admin> getAll(){
        return (List<Admin>) adminCrudRepository.findAll();
    }
    public Optional<Admin>getAdmin(int id){
        return adminCrudRepository.findById(id);
    }
    public Admin save(Admin administrador){
        return adminCrudRepository.save(administrador);
    }
    public void delete(Admin administrador){
        adminCrudRepository.delete(administrador);
    }
}
