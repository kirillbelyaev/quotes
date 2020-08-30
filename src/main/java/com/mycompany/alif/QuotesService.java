/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.alif;

import com.mycompany.alif.Constants.RETURN_CODES;
import static com.mycompany.alif.Constants.ZERO;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author kirill
 */
public class QuotesService {
    
    /* indirect interface to object operations */
    public int createQuote(String id, Quote q) {
         
        if (q == null || id == null || id.isEmpty())
            return RETURN_CODES.INVALID_PARAMETER.getValue();
         
        Quote quote = new Quote();
        quote = q;
        
        QuotesDAO.getInstance().getModel().put(id, quote);
         
        return RETURN_CODES.SUCCESS.getValue();
    }
    
    public int getSize() {
        return QuotesDAO.getInstance().getModel().size();
    }
    
    public int deleteQuote(String id) {
         
        if (id == null || id.isEmpty())
            return RETURN_CODES.INVALID_PARAMETER.getValue();
         
        Quote q  = QuotesDAO.getInstance().getModel().remove(id);
        
        if (q == null) return RETURN_CODES.NOT_FOUND.getValue();
         
        return RETURN_CODES.SUCCESS.getValue();
    }
    
    public int deleteAllQuotes() {
         
        QuotesDAO.getInstance().getModel().clear();
         
        return RETURN_CODES.SUCCESS.getValue();
    }
    
    public List<Quote> getAllQuotes() {
        List<Quote> quotes = new ArrayList<Quote>();
        quotes.addAll(QuotesDAO.getInstance().getModel().values() );
        
        //Collection values = QuotesDAO.getInstance().getModel().values();
        //QuotesDAO.getInstance().getModel().
       //List<Quote> result = new ArrayList(QuotesDAO.getInstance().getModel().values());
                
                
//        System.out.println("\n Values are: ");
//        
//        Iterator  it = values.iterator(); 
//        while (it.hasNext()) {
//         System.out.println(it.next());
//      }
                
        //quotes.addAll(QuotesDAO.getInstance().getModel().values());
        
//        System.out.println("Quote in list is: " + quotes.get(0).getQuote() );
//        System.out.println("Quote in list is: " + quotes.get(1).getQuote() );
//        System.out.println("Quote in list is: " + quotes.get(2).getQuote() );
        
        return quotes;
    }
    
    public Quote getRandomQuote() {
        List<Quote> quotes = new ArrayList<Quote>();
        quotes.addAll(QuotesDAO.getInstance().getModel().values() );
        
        int min = 0;
        int max = quotes.size() - 1;
           
        Quote q = new Quote();
        
        if (max < 0)
            return q;
        
        int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);   
        
        q = quotes.get(randomNum);
        
        return q;
    }
    
    public List <Quote> getAllQuotesByCategory(String category) {
        
        if (category == null || category.isEmpty()) return null;
        
        List<Quote> quotes = new ArrayList<Quote>();
        quotes.addAll(QuotesDAO.getInstance().getModel().values() );
        
        int size = quotes.size();
        //System.out.println("quotes size is: " + size);
        
        /* if no quotes found send a single empty quote object with blank fields instead of NULL for descriptiveness */
        if (size == ZERO) {
             Quote q = new Quote();
             quotes.add(q);
             return quotes;
         }
        
        /* 1st removal pass */
        for (int i = 0; i < size; i++) {
            if (!quotes.get(i).getCategory().equals(category)){
                System.out.println("category does not match. deleting quote. ");
                System.out.println("quotes size is: " + size);
                quotes.remove(i);
                
                size = size - 1;
            }
        }
        
        /* 2nd removal pass */
        for (int i = 0; i < size; i++) {
            if (!quotes.get(i).getCategory().equals(category)){
                System.out.println("category does not match. deleting quote. ");
                System.out.println("quotes size is: " + size);
                quotes.remove(i);
                
                size = size - 1;
            }
        }
        
        //System.out.println("quotes size is: " + size);   
        
        return quotes;
    }
    
    
    public int deteleDailyQuotes() { 
        
        Set <String> keys = QuotesDAO.getInstance().getModel().keySet();
        LocalDate Currentdate = LocalDate.now();
        Iterator  it = keys.iterator();
        
        while (it.hasNext()) {
            //System.out.println(it.next());
            //quotes.add(QuotesDAO.getInstance().getModel().get(it.next()));
            
                   LocalDate elementDate = LocalDate.parse(QuotesDAO.getInstance().getModel().get(it.next()).getDate() );
                   //System.out.println("date obtained from map is: " + elementDate);
                   
                   /* compare the obtained dates */
                   if (Currentdate.isAfter(elementDate) == true){
                       QuotesDAO.getInstance().getModel().remove(it.next());
                   }
                   
                    //Quote q = QuotesDAO.getInstance().getModel().get(it.next());
                    //quotes.add(q);
                    //System.out.println("Quote obtained from map is: " + q.getQuote() );
                    //q = null;
        }
        
        return Constants.SUCCESS;
    }
    
//    public List<Quote> getAllQuotes2() {
//        List<Quote> quotes = new ArrayList<Quote>();
//        //quotes.addAll(QuotesDAO.getInstance().getModel().values() );
//        
//        Set <String> keys = QuotesDAO.getInstance().getModel().keySet();
//        
//        Iterator  it = keys.iterator();
//        
//        while (it.hasNext()) {
//            //System.out.println(it.next());
//            //quotes.add(QuotesDAO.getInstance().getModel().get(it.next()));
//            
//                    Quote q = QuotesDAO.getInstance().getModel().get(it.next());
//                    quotes.add(q);
//                    System.out.println("Quote obtained from map is: " + q.getQuote() );
//                    q = null;
//        }
//        
////        Collection values = QuotesDAO.getInstance().getModel().values();
////        //QuotesDAO.getInstance().getModel().
////        List<Quote> result = new ArrayList(QuotesDAO.getInstance().getModel().values());
////                
////                
////        System.out.println("\n Values are: ");
////        
////        Iterator  it = values.iterator(); 
////        while (it.hasNext()) {
////         System.out.println(it.next());
////      }
//                
//        //quotes.addAll(QuotesDAO.getInstance().getModel().values());
//        
//        System.out.println("Quote in list is: " + quotes.get(0).getQuote() );
//        System.out.println("Quote in list is: " + quotes.get(1).getQuote() );
//        System.out.println("Quote in list is: " + quotes.get(2).getQuote() );
//      
//        return quotes;
//        //return result;
//    }
    
    public void createSampleQuotes(){
        String author = "Jack London";
        String author1 = "Mark Twen";
        String quote = "Famous quote from the past";
        String quote1 = "Famous quote from the future";
        String quote2 = "Famous quote from the present";
        String category = "daily";
        String ID = "1";
        String ID1 = "2";
        String ID2 = "3";
        
        Quote q = new Quote();
        Quote q1 = new Quote();
        Quote q2 = new Quote();
        
        q.setAuthor(author);
        q.setQuote(quote);
        q.setCategory(category);
        
        System.out.println("Quote is: " + q.getQuote());
        
        this.createQuote(ID, q);
        
        System.out.println("Quote in map is: " + QuotesDAO.getInstance().getModel().get(ID).getQuote() );
        
        q1.setAuthor(author);
        q1.setQuote(quote1);
        q1.setCategory(category);
        
        System.out.println("Quote is: " + q1.getQuote());
        
        this.createQuote(ID1, q1);
        
        System.out.println("Quote in map is: " + QuotesDAO.getInstance().getModel().get(ID1).getQuote() );
        
        q2.setAuthor(author1);
        q2.setQuote(quote2);
        q2.setCategory(category);
        
        System.out.println("Quote is: " + q2.getQuote());
        
        this.createQuote(ID2, q2);
        
        System.out.println("Quote in map is: " + QuotesDAO.getInstance().getModel().get(ID2).getQuote() );
    }
    
    
    public int editQuoteAuthor(String id, String author) {
         
        if (id == null || id.isEmpty())
            return RETURN_CODES.INVALID_PARAMETER.getValue();
        
        if (author == null || author.isEmpty())
            return RETURN_CODES.INVALID_PARAMETER.getValue();     
        
        if (QuotesDAO.getInstance().getModel().get(id) == null)
            return RETURN_CODES.NOT_FOUND.getValue();
        
        QuotesDAO.getInstance().getModel().get(id).setAuthor(author);
         
        return RETURN_CODES.SUCCESS.getValue();
    }
    
    public int editQuoteCategory(String id, String category) {
         
        if (id == null || id.isEmpty())
            return RETURN_CODES.INVALID_PARAMETER.getValue();
        
        if (category == null || category.isEmpty())
            return RETURN_CODES.INVALID_PARAMETER.getValue();     
        
        if (QuotesDAO.getInstance().getModel().get(id) == null)
            return RETURN_CODES.NOT_FOUND.getValue();
        
        QuotesDAO.getInstance().getModel().get(id).setCategory(category);
         
        return RETURN_CODES.SUCCESS.getValue();
    }
    
    public int editQuote(String id, String quote) {
         
        if (id == null || id.isEmpty())
            return RETURN_CODES.INVALID_PARAMETER.getValue();
        
        if (quote == null || quote.isEmpty())
            return RETURN_CODES.INVALID_PARAMETER.getValue();     
        
        if (QuotesDAO.getInstance().getModel().get(id) == null)
            return RETURN_CODES.NOT_FOUND.getValue();
        
        QuotesDAO.getInstance().getModel().get(id).setQuote(quote);
         
        return RETURN_CODES.SUCCESS.getValue();
    }
}
