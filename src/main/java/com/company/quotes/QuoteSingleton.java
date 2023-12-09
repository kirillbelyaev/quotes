
package com.company.quotes;

/**
 *
 * @author kirill
 */
public class QuoteSingleton {
    
    private QuoteSingleton() {
    }
    
    public static QuoteSingleton getInstance() {
        return NewSingletonHolder.INSTANCE;
    }
    
    private static class NewSingletonHolder {

        private static final QuoteSingleton INSTANCE = new QuoteSingleton();
        
        private String quote = "";
        
        private String author = "";

        private String category = "";
        
        
        public String getQuote() {
            return quote;
        }

        public void setQuote(String quote) {
            this.quote = quote;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }
        
    }
}
