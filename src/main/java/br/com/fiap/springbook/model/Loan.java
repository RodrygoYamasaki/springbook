package br.com.fiap.springbook.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 2, max = 100)
    private String borrowerName;

    @NotBlank
    @Size(min = 2, max = 200)
    private String bookTitle;

    @PastOrPresent
    private LocalDate loanDate;

    @FutureOrPresent
    private LocalDate returnDate;

    @Enumerated(EnumType.STRING)
    private LoanType type;
}