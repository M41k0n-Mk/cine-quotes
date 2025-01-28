package me.m41k0n.cine_quotes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;

@Service
public class QuoteService {
    @Autowired
    private QuoteRepository quoteRepository;

    public List<Quote> getQuote(String title, String character) {
        Specification<Quote> spec = Specification.where(null);
        spec = addSpecificationIfNotNull(spec, title, QuoteSpecification::hasTitle);
        spec = addSpecificationIfNotNull(spec, character, QuoteSpecification::hasCharacter);

        return quoteRepository.findAll(spec);
    }

    private <T> Specification<Quote> addSpecificationIfNotNull(Specification<Quote> spec, T value,
                                                               Function<T, Specification<Quote>> specificationFunction) {
        if (value != null) {
            spec = spec.and(specificationFunction.apply(value));
        }
        return spec;
    }
}