package com.intexsoft.bookservice.dao.repository.customrepositories.specification;

import com.intexsoft.bookservice.dao.entity.Author;
import com.intexsoft.bookservice.dao.entity.Book;
import com.intexsoft.bookservice.dao.entity.Publisher;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

public class BookSpecifications {

    public static Specification<Book> getBestsellers(Double fromRate, Publisher publisher, Author author) {
        return new Specification<Book>() {
            @Override
            public Predicate toPredicate(Root<Book> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> restrictions = new ArrayList<>();
                if (publisher != null) {
                    restrictions.add(criteriaBuilder.equal(root.get("publisher"), publisher));
                }
                if (author != null) {
                    Join<Book, Author> authors = root.join("authors");
                    restrictions.add(criteriaBuilder.equal(authors.get("id"), author.getId()));
                }
                if (fromRate != null) {
                    restrictions.add(criteriaBuilder.greaterThanOrEqualTo(root.get("rate"), fromRate));
                }
                Predicate[] arrayRestrictions = restrictions.toArray(new Predicate[0]);
                return criteriaBuilder.and(arrayRestrictions);
            }
        };
    }

    public static Specification<Book> getBooksByPriceInterval(Double minPrice, Double maxPrice, Publisher publisher, Author author) {
        return new Specification<Book>() {
            @Override
            public Predicate toPredicate(Root<Book> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> restrictions = new ArrayList<>();
                if (minPrice != null) {
                    restrictions.add(criteriaBuilder.greaterThanOrEqualTo(root.get("price"), minPrice));
                }
                if (maxPrice != null) {
                    restrictions.add(criteriaBuilder.lessThanOrEqualTo(root.get("price"), maxPrice));
                }
                if (publisher != null) {
                    restrictions.add(criteriaBuilder.equal(root.get("publisher"), publisher));
                }
                if (author != null) {
                    Join<Book, Author> authors = root.join("authors");
                    restrictions.add(criteriaBuilder.equal(authors.get("id"), author.getId()));
                }
                Predicate[] arrayRestrictions = restrictions.toArray(new Predicate[0]);
                return criteriaBuilder.and(arrayRestrictions);
            }
        };
    }

}