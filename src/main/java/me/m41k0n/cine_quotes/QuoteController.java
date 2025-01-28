package me.m41k0n.cine_quotes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/series")
public class QuoteController {
    @Autowired
    private QuoteService quoteService;

    @GetMapping("/quote")
    public List<Quote> getFrase(@RequestParam(required = false) String title,
                                @RequestParam(required = false) String character) {
        return quoteService.getFrase(title, character);
    }
}