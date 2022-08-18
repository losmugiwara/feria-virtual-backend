package com.portafolio.feriavirtual.services;

import com.portafolio.feriavirtual.entities.Category;
import com.portafolio.feriavirtual.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;


    public List<Category> getAll(){
        return (List<Category>) categoryRepository.findAll();
    }

    public void save(Category category){
        categoryRepository.save(category);
    }


}
