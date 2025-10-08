package br.com.fiap.springbook.config;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.fiap.springbook.model.Loan;
import br.com.fiap.springbook.model.LoanType;
import br.com.fiap.springbook.repository.LoanRepository;
import jakarta.annotation.PostConstruct;

public class DatabaseSedder {
    
    @Autowired
    private LoanRepository loanRepository;

    private Random random = new Random();

    private final List<String> borrowers = List.of(
        "Maria Souza", "Carlos Silva", "Ana Lima", "Bruno Costa", "Lucas Fonseca",
        "Fernanda Alves", "João Martins", "Patricia Duarte", "Rafael Nunes", "Juliana Assis"
    );

    private final List<String> bookTitles = List.of(
        "Java em Ação", "Aprenda Spring Boot", "Código Limpo", "Algoritmos e Estruturas de Dados",
        "Padrões de Projeto", "Refatoração", "Dominando Microservices", "Banco de Dados Oracle",
        "Testes em Java", "REST API Design"
    );

    private final LoanType[] loanTypes = LoanType.values();

    @PostConstruct
    public void seeder() {
        for (int i = 0; i < 50; i++) {
            String borrowerName = borrowers.get(random.nextInt(borrowers.size()));
            String bookTitle = bookTitles.get(random.nextInt(bookTitles.size()));
            LocalDate loanDate = LocalDate.now().minusDays(random.nextInt(30));
            LocalDate returnDate = loanDate.plusDays(7 + random.nextInt(14));
            LoanType type = loanTypes[random.nextInt(loanTypes.length)];

            Loan loan = new Loan();
            loan.setBorrowerName(borrowerName);
            loan.setBookTitle(bookTitle);
            loan.setLoanDate(loanDate);
            loan.setReturnDate(returnDate);
            loan.setType(type);

            loanRepository.save(loan);
        }
    }

}
