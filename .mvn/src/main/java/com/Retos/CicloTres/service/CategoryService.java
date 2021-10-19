/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Retos.CicloTres.service;

import com.Retos.CicloTres.model.Category;
import com.Retos.CicloTres.repository.CategoryRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    public List<Category> getAll(){
        return  categoryRepository.getAll();
    }
    public Optional<Category> getCategory(int id){
        return categoryRepository.getCategory(id);
    }

    public Category save(Category categoria){
        if(categoria.getId()==null){
            return categoryRepository.save(categoria);
        }else{
            Optional<Category> paux=categoryRepository.getCategory(categoria.getId());
            if(paux.isEmpty()){
                return categoryRepository.save(categoria);
            }else{
                return categoria;
            }
        }
    }
}
