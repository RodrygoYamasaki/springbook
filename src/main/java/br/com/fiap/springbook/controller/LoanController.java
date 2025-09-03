package br.com.fiap.springbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.springbook.model.Loan;
import br.com.fiap.springbook.repository.LoanRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("loans")
@Slf4j
public class LoanController {
    
    @Autowired
    private LoanRepository repository;

    @GetMapping
    public List<Loan> index() {
        return repository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Loan create(@RequestBody @Valid Loan loan) {
        log.info("cadastrando emprestimo " + loan);
        return repository.save(loan);
    }
}