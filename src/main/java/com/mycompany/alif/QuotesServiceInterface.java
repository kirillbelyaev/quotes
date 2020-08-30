/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.alif;

import java.util.List;

/**
 *
 * @author kirill
 */
public interface QuotesServiceInterface {
    
    public int createQuote(String id, Quote q);
    
    public int getSize();
    
    public int deleteQuote(String id);
    
    public int deleteAllQuotes();
    
    public List<Quote> getAllQuotes();
    
    public Quote getRandomQuote();
    
    public List <Quote> getAllQuotesByCategory(String category);
    
    public int deteleDailyQuotes();
    
    public void createSampleQuotes();
    
    public int editQuoteAuthor(String id, String author);
    
    public int editQuoteCategory(String id, String category);
    
    public int editQuote(String id, String quote);
}
