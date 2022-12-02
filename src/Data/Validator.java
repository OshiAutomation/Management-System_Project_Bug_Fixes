/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

/**
 *
 * @author Senali
 */
public class Validator {
    
    public boolean isNumber(String s) {
        //using thins can check whether entered content of a field is numeric
    boolean isANumber = true;
        
    for(int i=0; i<s.length(); i++) {
        
        char ch = s.charAt(i);  
        
        if(!Character.isDigit(ch)) {
            isANumber = false;
            break;
        }

        }
    
        return isANumber;
    }
    
    public boolean isText(String s) {
        
        //using thins can check whether entered content of a field is text
    boolean isAText = true;
        
    for(int i=0; i<s.length(); i++) {
        
        char ch = s.charAt(i);  
        
        if(!Character.isLetter(ch) && !Character.isWhitespace(ch) && ch!='.') {
            isAText = false;
            break;
        }
      
        }
    
        return isAText;
    }
    
    public boolean checkEmail(String s) {
        
        boolean status = false;
        int index=0;
        int count=0;
        
        for(int i=0; i<s.length(); i++) {
            
            char ch = s.charAt(i);
            if(ch=='@') {
                
                count ++;
                status = true;
                index=i;
                
                for(int j=index; j<s.length(); j++) {
                    
                    char cha = s.charAt(j);
                    if(cha=='.') {
                        status = true;
                        break;
                    }
                    
                }
        }
            
            
        }
        
        if(count>1)
            status = false;
        
     
        return status;
    }
    
    public boolean isAddress(String s) {
        
        //using thins can check whether entered content of a field is text
    boolean isAText = true;
        
    for(int i=0; i<s.length(); i++) {
        
        char ch = s.charAt(i);  
        
        if((ch=='@') || (ch=='#') || (ch=='$') || (ch=='%') || (ch=='^') || (ch=='&') || (ch=='*') || (ch=='{') || (ch=='}')) {
        
            isAText = false;
            break;
        }
      
        }
    
        return isAText;
    }
   
}