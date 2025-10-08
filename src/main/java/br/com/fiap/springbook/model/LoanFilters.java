package br.com.fiap.springbook.model;

import java.time.LocalDate;

public record LoanFilters(
    String borrowerName,
    String bookTitle,
    LocalDate loanDateFrom,
    LocalDate loanDateTo,
    LocalDate returnDateFrom,
    LocalDate returnDateTo,
    LoanType type
) {} 
