package br.com.fiap.springbook.validation;

import java.util.List;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class GenreValidator implements ConstraintValidator<Genre, String>{
    
    private final List<String> validGenres = List.of(
        "Science Fiction",
        "Fantasy",
        "Mystery",
        "Thriller",
        "Romance",
        "Western",
        "Dystopian",
        "Contemporary"
    );

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value.isBlank() || validGenres.contains(value);
    }
}