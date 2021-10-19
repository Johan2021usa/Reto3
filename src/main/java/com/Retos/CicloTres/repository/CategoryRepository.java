/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Retos.CicloTres.repository;

import com.Retos.CicloTres.model.Category;
import com.Retos.CicloTres.repository.crud.CategoryCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryRepository {
    @Autowired
    private CategoryCrudRepository categoryCrudRepository;

    public List<Category> getAll(){
        return (List<Category>) categoryCrudRepository.findAll();
    }
    public Optional<Category>getCategory(int id){
        return categoryCrudRepository.findById(id);
    }
    public Category save(Category categoria){
        return categoryCrudRepository.save(categoria);
    }
    public void delete(Category partyroom){
        categoryCrudRepository.delete(partyroom);
    }
}
