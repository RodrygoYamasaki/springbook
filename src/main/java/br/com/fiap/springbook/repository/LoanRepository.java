package br.com.fiap.springbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.springbook.model.Loan;

public interface LoanRepository extends JpaRepository<Loan, Long> {
    
}