package me.m41k0n.cine_quotes;

import org.springframework.data.jpa.domain.Specification;


public class QuoteSpecification {
    public static Specification<Quote> hasTitle(String title) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("title"), title);
    }

    public static Specification<Quote> hasCharacter(String character) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("character"), character);
    }
}