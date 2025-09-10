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

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "{loan.borrowerName.notblank}")
    @Size(min = 2, max = 100, message = "{loan.borrowerName.size}")
    private String borrowerName;

    @NotBlank(message = "{loan.bookTitle.notblank}")
    @Size(min = 2, max = 200, message = "{loan.bookTitle.size}")
    private String bookTitle;

    @PastOrPresent(message = "{loan.loanDate.pastorpresent}")
    private LocalDate loanDate;

    @FutureOrPresent(message = "{loan.returnDate.futureorpresent}")
    private LocalDate returnDate;

    @Enumerated(EnumType.STRING)
    private LoanType type;
}