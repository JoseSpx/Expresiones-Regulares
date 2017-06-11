package clases;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;


public class Principal {
    
    public static void main(String[] args) {
        
        Boolean bandValidate;
        String alphabet = Alphabet.ALPHABET;
        
        String regularExpression = "(a*)";
        int numberOfWords = 20;
        
        regularExpression = deleteSpacesFromRegularExpression(regularExpression);
        bandValidate = validateRegularExpression(regularExpression);
        
        if(!bandValidate){
            System.out.println("No valid");
            return;
        }
        
        regularExpression = enterDots(alphabet, regularExpression);
        
        // verify if exits Parentesis
        Boolean existsParentesis = existsParenetesis(regularExpression);
        int i;
        ArrayList<String> listResult;
        long start = System.nanoTime();
        if(existsParentesis){
            System.out.println("Parentesis");
            Parentesis parentesis = new Parentesis();
            listResult = parentesis.getMatrixResult(regularExpression);
            
            if(listResult == null){
                System.out.println("vacioooo");
                return;
            }

        }
        else{
            System.out.println("No Parentesis");

            NoParentesis np = new NoParentesis(regularExpression);
            listResult = np.getMatrix();
            
        }
        
        Collections.sort(listResult,(String s1, String s2)->{
            int h , s1Count = 0, s2Count = 0;
            for(h = 0;h < s1.length(); h++){
                if(String.valueOf(s1.charAt(h)).equals(Lambda.VALUE)){
                    s1Count++;
                }
            }
            for(h = 0;h < s2.length(); h++){
                if(String.valueOf(s2.charAt(h)).equals(Lambda.VALUE)){
                    s2Count++;
                }
            }
            s1Count = s1.length() - s1Count;
            s2Count = s2.length() - s2Count;
            return s1Count - s2Count;
        });
        
        if(numberOfWords > listResult.size()){
                numberOfWords = listResult.size();
        }
        
        for(i = 0; i < numberOfWords ; i++){
                System.out.println("Word #"+(i+1)+ " : " + listResult.get(i));
        }

        System.out.println("Regular Expression  : " + regularExpression);
        long end = System.nanoTime();
        System.out.println("Tiempo : " + (end - start)/ 1000000000);
  
    }
    
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