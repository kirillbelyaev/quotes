/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.alif;

import com.mycompany.alif.Constants.RETURN_CODES;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author kirill
 */
public class QuotesDAO {
    
    private QuotesDAO() {
    }
    
    public static QuotesDAO getInstance() 
    {
        return QuotesHolder.INSTANCE;
    }
    
    private static Map<String, Quote> quotesProvider = new HashMap<>();
     
    /* direct access to object operations */
    public Map<String, Quote> getModel()
    {
        return this.quotesProvider;
    }
    
    /* indirect interface to object operations */
//    public int create(Quote quote, String id) {
//         
//        if (quote == null || id == null)
//            return RETURN_CODES.INCORRECT_PARAMETER.getValue();
//         
//        this.quotesProvider.put(id, quote);
//         
//        return RETURN_CODES.SUCCESS.getValue();
//    }
        
    private static class QuotesHolder {

        private static final QuotesDAO INSTANCE = new QuotesDAO();  
    }
}
