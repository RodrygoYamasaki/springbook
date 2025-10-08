package br.com.fiap.springbook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import br.com.fiap.springbook.filter.LoanSpecification;
import br.com.fiap.springbook.model.Loan;
import br.com.fiap.springbook.model.LoanFilters;
import br.com.fiap.springbook.repository.LoanRepository;

@Service
public class LoanService {
    
    @Autowired
    private LoanRepository repository;

    public Page<Loan> getLoans(Specification<Loan> specification, Pageable pageable) {
        return repository.findAll(specification, pageable);
    }

    public Loan save(Loan loan) {
        return repository.save(loan);
    }
}
