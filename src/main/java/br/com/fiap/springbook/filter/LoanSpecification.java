package br.com.fiap.springbook.filter;

import org.springframework.data.jpa.domain.Specification;

import br.com.fiap.springbook.model.Loan;
import br.com.fiap.springbook.model.LoanFilters;

public class LoanSpecification {

    public static Specification<Loan> build(LoanFilters filters) {
         
        return (root, query, cb) -> {
            var predicate = cb.conjunction();

            if (filters.borrowerName() != null && !filters.borrowerName().isEmpty()) {
                predicate = cb.and(predicate,
                        cb.like(cb.lower(root.get("borrowerName")), "%" + filters.borrowerName().toLowerCase() + "%"));
            }

            if (filters.bookTitle() != null && !filters.bookTitle().isEmpty()) {
                predicate = cb.and(predicate,
                        cb.like(cb.lower(root.get("bookTitle")), "%" + filters.bookTitle().toLowerCase() + "%"));
            }

            if (filters.loanDateFrom() != null) {
                predicate = cb.and(predicate,
                        cb.greaterThanOrEqualTo(root.get("loanDate"), filters.loanDateFrom()));
            }

            if (filters.loanDateTo() != null) {
                predicate = cb.and(predicate,
                        cb.lessThanOrEqualTo(root.get("loanDate"), filters.loanDateTo()));
            }

            if (filters.returnDateFrom() != null) {
                predicate = cb.and(predicate,
                        cb.greaterThanOrEqualTo(root.get("returnDate"), filters.returnDateFrom()));
            }

            if (filters.returnDateTo() != null) {
                predicate = cb.and(predicate,
                        cb.lessThanOrEqualTo(root.get("returnDate"), filters.returnDateTo()));
            }

            if (filters.type() != null) {
                predicate = cb.and(predicate,
                        cb.equal(root.get("type"), filters.type()));
            }

            return predicate;
        };
    }
}