/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.quotes;

/**
 *
 * @author kirill
 */
public class CleanerTask implements Runnable {

    @Override
    public void run() {
        clean();
        throw new UnsupportedOperationException("CleanerTask exception."); //To change body of generated methods, choose Tools | Templates.
    }

    int clean(){
        System.out.println("CleanerTask activated. ");
        return Constants.SUCCESS;
    }
    
}
