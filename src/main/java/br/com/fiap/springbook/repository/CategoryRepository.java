package br.com.fiap.springbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.springbook.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{
    
}
