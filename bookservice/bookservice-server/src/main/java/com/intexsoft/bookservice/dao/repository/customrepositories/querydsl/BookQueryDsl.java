package com.intexsoft.bookservice.dao.repository.customrepositories.querydsl;

import com.intexsoft.bookservice.dao.entity.Author;
import com.intexsoft.bookservice.dao.entity.Publisher;
import com.intexsoft.bookservice.dao.entity.QBook;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;

import java.util.ArrayList;
import java.util.List;

public class BookQueryDsl {

    public static Predicate getBestsellers(Double fromRate, Publisher publisher, Author author) {
        QBook qBook = QBook.book;
        List<BooleanExpression> booleanExpressions = new ArrayList<>();
        BooleanBuilder booleanBuilder = new BooleanBuilder();
        if (publisher != null) {
            booleanExpressions.add(qBook.publisher.eq(publisher));
        }
        if (author != null) {
            booleanExpressions.add(qBook.authors.any().eq(author));
        }
        if (fromRate != null) {
            booleanExpressions.add(qBook.rate.goe(fromRate));
        }
        for (BooleanExpression booleanExpression : booleanExpressions) {
            booleanBuilder.and(booleanExpression);
        }
        return booleanBuilder;
    }


    public static Predicate getBooksByPriceInterval(Double minPrice, Double maxPrice, Publisher publisher, Author author) {
        QBook qBook = QBook.book;
        List<BooleanExpression> booleanExpressions = new ArrayList<>();
        BooleanBuilder booleanBuilder = new BooleanBuilder();
        if (minPrice != null) {
            booleanExpressions.add(qBook.price.goe(minPrice));
        }
        if (maxPrice != null) {
            booleanExpressions.add(qBook.price.loe(maxPrice));
        }
        if (publisher != null) {
            booleanExpressions.add(qBook.publisher.eq(publisher));
        }
        if (author != null) {
            booleanExpressions.add(qBook.authors.any().eq(author));
        }
        for (BooleanExpression booleanExpression : booleanExpressions) {
            booleanBuilder.and(booleanExpression);
        }
        return booleanBuilder;
    }
}
