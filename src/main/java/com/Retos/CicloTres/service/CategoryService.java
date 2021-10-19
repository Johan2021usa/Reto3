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
    public Category update(Category categoria){
        if(categoria.getId()!=null){
            Optional<Category>cat=categoryRepository.getCategory(categoria.getId());
            if(!cat.isEmpty()){
                if(categoria.getName()!=null){
                    cat.get().setName(categoria.getName());
                }
                if(categoria.getDescription()!=null){
                    cat.get().setDescription(categoria.getDescription());
                }
                return categoryRepository.save(cat.get());
            }
        }
        return categoria;
    }
    public boolean deleteCategory(int id){
        Optional<Category> cat=getCategory(id);
        if(!cat.isEmpty()){
            categoryRepository.delete(cat.get());
            return true;
        }
        return false;
    }
}
