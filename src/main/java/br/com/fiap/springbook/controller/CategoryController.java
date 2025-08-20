package br.com.fiap.springbook.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.springbook.model.Category;

@RestController
public class CategoryController {

    @GetMapping("/categories")
    public List<Category> index() { 
        List<Category> categories = new ArrayList<>();
        categories.add(new Category(1L, "Cem Anos de Solidão", "Gabriel García Márquez"));
        categories.add(new Category(2L, "O Senhor dos Anéis", "J.R.R. Tolkien"));
        categories.add(new Category(3L, "Dom Casmurro", "Machado de Assis"));

        return categories;
    }
    
}