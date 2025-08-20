package br.com.fiap.springbook.model;

public class Category {
    private Long id;
    private String name;
    private String autor;

    public Category(Long id, String name, String autor) {
        this.id = id;
        this.name = name;
        this.autor = autor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}