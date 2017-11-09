package com.ynov.appbancairev2.validation;

public class PasswordValidation {

	public static boolean validPassword(String pass) {
		
		if (pass.length() <8)
			return false;
		
		char c;
		int count=0;
        for (int i = 0; i < pass.length(); i++) {  
            c = pass.charAt(i);  
           if (Character.isDigit(c)) 
                count++;    
        }  
        if (count<2)
        	return false;
        
        
        return true;
	}
}
