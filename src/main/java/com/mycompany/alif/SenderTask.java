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
public class SenderTask implements Runnable {

    @Override
    public void run() {
        
//        String target = "";
//        send(target);
        throw new UnsupportedOperationException("SenderTask exception."); //To change body of generated methods, choose Tools | Templates.
    }

    int send(String target){
        System.out.println("SenderTask activated. ");
        
        if (this.validateEmail(target) != Constants.SUCCESS)
            return Constants.RETURN_CODES.INVALID_PARAMETER.getValue();
                    
        return Constants.SUCCESS;
    }
    
    int validateEmail(String email){
        if (email == null || email.isEmpty()) 
            return Constants.RETURN_CODES.INVALID_PARAMETER.getValue();
        
        return Constants.SUCCESS;
    } 
    
}
