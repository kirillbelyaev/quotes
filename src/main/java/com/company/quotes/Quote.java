/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.quotes;

import com.company.quotes.Constants.RETURN_CODES;
import java.time.LocalDate;
import java.util.Objects;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
/**
 *
 * @author kirill
 */
public class Quote {
        
        private String Quote = "";
        
        private String Author = "";

        private String Category = "";
        
        private String ID = "";
        
        private final String Date = LocalDate.now().toString();
        
        
        public String getQuote() {
            return Quote;
        }

        public int setQuote(String quote) {
            
            if (quote == null || quote.isEmpty())
                return RETURN_CODES.ERROR.getValue();
                
            this.Quote = quote;
            
            return RETURN_CODES.SUCCESS.getValue();
        }

        public String getAuthor() {
            return Author;
        }

        public int setAuthor(String author) {
            
            if (author == null || author.isEmpty())
                return RETURN_CODES.ERROR.getValue();
            
            this.Author = author;
            
            return RETURN_CODES.SUCCESS.getValue();
        }

        public String getCategory() {
            return Category;
        }

        public int setCategory(String category) {
            
            if (category == null || category.isEmpty())
                return RETURN_CODES.ERROR.getValue();
            
            this.Category = category;
            
            return RETURN_CODES.SUCCESS.getValue();
        }
        
        @Override
        public int hashCode() 
	{
		int hash = 8;
		hash = 68 * hash + (this.Author != null ? this.Author.hashCode() : 0);
		hash = 68 * hash + (this.Category != null ? this.Category.hashCode() : 0);
                hash = 68 * hash + (this.Quote != null ? this.Quote.hashCode() : 0);
		return hash;
	}

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Quote other = (Quote) obj;
        if (!Objects.equals(this.Quote, other.Quote)) {
            return false;
        }
        if (!Objects.equals(this.Author, other.Author)) {
            return false;
        }
        if (!Objects.equals(this.Category, other.Category)) {
            return false;
        }
        return true;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getDate() {
        return Date;
    }
        
        
}
