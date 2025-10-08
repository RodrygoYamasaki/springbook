package br.com.fiap.springbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.springbook.filter.LoanSpecification;
import br.com.fiap.springbook.model.Loan;
import br.com.fiap.springbook.model.LoanFilters;
import br.com.fiap.springbook.repository.LoanRepository;
import br.com.fiap.springbook.service.LoanService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("loans")
@Slf4j
public class LoanController {

    @Autowired
    private LoanService loanService;

    @Autowired
    private LoanRepository repository;

    @GetMapping
    public Page<Loan> index(LoanFilters filters, @PageableDefault(size = 10, sort = "loanDate", direction = Direction.DESC) Pageable pageable) {
        var specification = LoanSpecification.build(filters);
        return loanService.getLoans(specification, pageable);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Loan create(@RequestBody @Valid Loan loan) {
        log.info("cadastrando emprestimo " + loan);
        return repository.save(loan);
    }
}