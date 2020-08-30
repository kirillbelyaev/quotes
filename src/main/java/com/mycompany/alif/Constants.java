/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.alif;

/**
 *
 * @author kirill
 */
public interface Constants {
    
    int SUCCESS = 0;
    int ERROR = -1;
    int ZERO = 0;
    
    public enum RETURN_CODES {
        SUCCESS(0),
        ERROR(1),
        NOT_FOUND(2),
        INVALID_PARAMETER(3),
        NO_MATCH(4);

        private final int value;

        private RETURN_CODES(final int value) {
            this.value = value;
        }

        public int getValue() { return value; }
    }
    
    
    String ID_EMPTY = "ID field is empty";
    String AUTHOR_EMPTY = "Author field is empty";
    String QUOTE_EMPTY = "Quote field is empty";
    String CATEGORY_EMPTY = "Category field is empty";
    String OPERATION_FAIL = "Operation failed";
    String OPERATION_SUCCESS = "Operation successful";
    String INVALID_OBJECT = "Invalid object - NULL";
    String CATEGORY_DAILY = "Daily";
    
}
