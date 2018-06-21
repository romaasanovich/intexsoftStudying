package com.intexsoft.bookservice.dao.repository.customrepositories.specification;

import com.intexsoft.bookservice.dao.entity.Author;
import com.intexsoft.bookservice.dao.entity.Book;
import com.intexsoft.bookservice.dao.entity.Publisher;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class BookSpecifications {

    public static Specification<Book> fromRate(Double fromRate, Publisher publisher, Author author) {
        return new Specification<Book>() {
            @Override
            public Predicate toPredicate(Root<Book> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> restrictions = new ArrayList<>();
                if (publisher != null) {
                    restrictions.add(criteriaBuilder.equal(root.get("publisher"), publisher));
                }
                if (author != null) {
                    restrictions.add(criteriaBuilder.equal(root.get("author"), author));
                }
                if (fromRate != null) {
                    restrictions.add(criteriaBuilder.greaterThan(root.get("rate"), fromRate));
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
                    restrictions.add(criteriaBuilder.equal(root.get("author"), author));
                }
                Predicate[] arrayRestrictions = restrictions.toArray(new Predicate[0]);
                return criteriaBuilder.and(arrayRestrictions);
            }
        };
    }

}