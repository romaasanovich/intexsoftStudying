package com.intexsoft.bookservice.dao.repository.customrepositories;

import com.intexsoft.bookservice.dao.entity.Author;
import com.intexsoft.bookservice.dao.entity.Book;
import com.intexsoft.bookservice.dao.entity.Publisher;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

public class BookRepositoryCriteriaBuilderImpl implements BookRepositoryCriteriaBuilder {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Book> getBestSellersCriteriaBuilder(Double fromRate, Publisher publisher, Author author) {
        Session session = entityManager.unwrap(Session.class);
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Book> query = criteriaBuilder.createQuery(Book.class);
        Root<Book> root = query.from(Book.class);
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
        query.where(criteriaBuilder.and(arrayRestrictions));
        Query<Book> bookQuery = session.createQuery(query);
        return bookQuery.getResultList();
    }

    @Override
    public List<Book> getBooksByPriceIntervalCriteriaBuilder(Double minPrice, Double maxPrice, Publisher publisher, Author author) {
        Session session = entityManager.unwrap(Session.class);
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Book> query = criteriaBuilder.createQuery(Book.class);
        Root<Book> root = query.from(Book.class);
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
        query.where(criteriaBuilder.and(arrayRestrictions));
        Query<Book> bookQuery = session.createQuery(query);
        return bookQuery.getResultList();
    }
}
