package clases;

import java.util.Stack;


public class Principal {
    
    
    public static Boolean existsParenetesis(String regularExpression){
        int size = regularExpression.length();
        int i;
        for(i = 0; i <size; i++){
            if(regularExpression.charAt(i) == '('){
                return true;
            }
        }
        return false;
    }
    
    public static Boolean validateRegularExpression(String regularExpression){
        int i;
        int j;
        char actual;
        char next;
        int lenght = regularExpression.length();
        
        for(i=0; i<lenght; i++){
            
            if(i != lenght-1){
                actual = regularExpression.charAt(i);
                j = i + 1;
                next = regularExpression.charAt(j);

                if(actual == '(' && next == ')'){
                    return false;
                }

                if(actual == '|' && ( next == '|' || next == '*' || next == ')') ){
                    return false;
                }
                
                if(actual == '|' && next == ')'){
                    return false;
                }   
            }
        }
        
        Stack stack = new Stack();
        
        try{
            for(i = 0; i<lenght; i++){
                actual = regularExpression.charAt(i);
                if(actual == '('){
                    stack.push("X");
                }
                
                if(actual == ')'){
                    stack.pop();
                }
            }
        }catch(Exception e){
            return false;
        }
        
        return stack.isEmpty();
    }
    
    public static String enterDots(String alphabet,String regularExpression){
        int size = regularExpression.length();
        int i,j;
        char actual,next;
        
        StringBuilder stringBuilder = new StringBuilder();
        
        for(i=0; i<size; i++){
            actual = regularExpression.charAt(i);
            stringBuilder.append(actual);
            
            if(i != size-1){
                j = i + 1;
                next = regularExpression.charAt(j);
            
                if(alphabet.contains(String.valueOf(actual)) && alphabet.contains(String.valueOf(next))){
                    stringBuilder.append(".");
                }
                else if(actual == '*' && alphabet.contains(String.valueOf(next))){
                    stringBuilder.append(".");
                }
                else if(actual == ')' && next == '('){
                    stringBuilder.append(".");
                }
                else if(actual == ')' && alphabet.contains(String.valueOf(next))){
                    stringBuilder.append(".");
                }
                else if(alphabet.contains(String.valueOf(actual)) && next == '('){
                    stringBuilder.append(".");
                }
                else if(actual == '*' && next == '('){
                    stringBuilder.append(".");
                }
            }
            
        }
        return stringBuilder.toString();
}
    
    public static String deleteSpacesFromRegularExpression(String regularExpression){
        StringBuilder expressionWithoutSpaces = new StringBuilder();
        int cant = regularExpression.length();
        int i;
        for(i=0; i<cant; i++){
            if(regularExpression.charAt(i) != ' '){
                expressionWithoutSpaces.append(regularExpression.charAt(i));
            }
        }
        return expressionWithoutSpaces.toString();
    }

}