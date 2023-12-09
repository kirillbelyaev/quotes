
package com.company.quotes;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    int send(String target, List <Quote> ql){
        System.out.println("SenderTask activated. ");
        
        if (this.validateEmail(target) != Constants.SUCCESS)
            return Constants.RETURN_CODES.INVALID_PARAMETER.getValue();
        
        System.out.println("SenderTask: sending quotes ... ");
                    
        return Constants.SUCCESS;
    }
    
    int validateEmail(String email){
        if (email == null || email.isEmpty()) 
            return Constants.RETURN_CODES.INVALID_PARAMETER.getValue();
        
        final String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        //initialize the Pattern object
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        
        if (matcher.matches() != true )
            return Constants.RETURN_CODES.NO_MATCH.getValue();
            
        return Constants.SUCCESS;
    } 
    
}
