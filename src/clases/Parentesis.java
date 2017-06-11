package clases;

import java.util.ArrayList;
import java.util.Stack;

public class Parentesis {

    private ArrayList<String> listOfParentesis = new ArrayList<>();
    
    public String transformRegularExpression(String regularExpression){
        int size = regularExpression.length();
        int i;

        ArrayList<Integer> indexBegin = new ArrayList<>();
        ArrayList<Integer> indexEnd = new ArrayList<>();
        Stack stack = new Stack();
        Boolean existsFirstParentesis = false;
        for(i = 0; i < size; i++){
            if(regularExpression.charAt(i) == '('){
                stack.add("X");
                if(!existsFirstParentesis){
                    indexBegin.add(i);
                    existsFirstParentesis = true;
                }
            }
            else if(regularExpression.charAt(i) == ')'){
                if(stack.size() == 1){
                    indexEnd.add(i);
                    existsFirstParentesis = false;
                }
                stack.pop();
            } 
        }
       
        //System.out.println("Tam : " + indexBegin.size());
        int aux = 0;
        int listSize = listOfParentesis.size();
        StringBuilder stringBuilder = new StringBuilder(regularExpression);
        for(i = 0; i < indexBegin.size(); i++){
            
            if(i == 0){
                stringBuilder.replace(indexBegin.get(i),
                    indexEnd.get(i) + 1, String.valueOf(listSize));
            }else{
                aux = indexEnd.get(i - 1) - indexBegin.get(i - 1) + aux;
                stringBuilder.replace(indexBegin.get(i) - aux,
                    indexEnd.get(i) + 1 -aux, String.valueOf(listSize));
            }
            listSize++;
        }
        
        for(i = 0; i < indexBegin.size(); i++){
            listOfParentesis.add(regularExpression.substring(indexBegin.get(i), indexEnd.get(i) + 1));
        }
        /*
        for(i = 0 ; i < listOfParentesis.size() ; i++){
            System.out.println("list Parentesis: "+ listOfParentesis.get(i));
        }
        */
        return stringBuilder.toString();        
    }
    
    public String [] separate(String regularExpression){
        return regularExpression.split("\\|");
    }
    
    public ArrayList<String> AsteriscoParentesis(ArrayList<String> list){
        ArrayList<String> listOfWords = new ArrayList<>();
        list.add(Lambda.VALUE);
        
        int i, j, k;
        //number of lenght
        for(i=0; i<6; i++){
            //number of intents
            for(j=0; j<3500; j++){
                StringBuilder stringBuilder = new StringBuilder();
                for(k=0; k<6; k++){
                    int random = (int)((Math.random()*100)%list.size());
                    stringBuilder.append(list.get(random));
                    if(stringBuilder.length() == i){
                        break;
                    }
                }

                if(!listOfWords.contains(stringBuilder.toString())){
                    listOfWords.add(stringBuilder.toString());
                }

            }
        }
        return listOfWords;
    }
    
    
    //recibe listas para multiplicarse
    public ArrayList<String> getMatrixMultiplication(ArrayList<ArrayList<String>> lists){
        
        //combinatoria de total de listas
        ArrayList<String> listParent;
        ArrayList<String> listParentNext;
        ArrayList<String> listParentAux;
        
        listParentAux = lists.get(0);
        
        String stringParent, stringToSave;
        int i, j ,k;
        for(i = 1; i < lists.size(); i++){
            listParent = listParentAux;
            listParentAux = new ArrayList<>();
            listParentNext = lists.get(i);
            for(j = 0; j < listParent.size() ; j++){
                stringParent = listParent.get(j);
                for (k = 0; k < listParentNext.size(); k++) {
                    stringToSave = stringParent + listParentNext.get(k);
                    listParentAux.add(stringToSave);
                }
            }   
        }
        
        //Save final words in the listWords 
        Boolean band;
        String word;
        
        ArrayList<String> listWords = new ArrayList<>();
        for(i = 0; i< listParentAux.size() ; i++){
            band = false; // no existe
            word = listParentAux.get(i);
            for(j = 0; j < listWords.size() ; j++){
                if(listWords.get(j).equals(word)){
                    band = true;
                    break;
                }
            }
            if(!band){
                listWords.add(word);
            }
            
        }
        
        return listWords;
    }
    
    public ArrayList<String> getMatrixResult(String regularExpression){//System.out.println("1");
        String regularExpressionTransformed = transformRegularExpression(regularExpression);
        //System.out.println("tTTT : " + regularExpressionTransformed);
        Symbol symbol;
        ArrayList<ArrayList<String>> lists;
        ArrayList<String> list;
        String [] subStrings = separate(regularExpressionTransformed);
        int size , i;//System.out.println("2");
        if(subStrings.length == 1){
            lists = new ArrayList<>();
            String [] subStringsAnds = subStrings[0].split("\\.");
            //for(String s : subStringsAnds){
              //  System.out.println("----> " + s);
            //}
            size = subStringsAnds.length;//System.out.println("3 size and : "+size);
            for(i = 0; i < size ; i++){//System.out.println("4 for : "+subStringsAnds[i]);
                if(subStringsAnds[i].length() == 1){//sin asteriscos
                    if(Alphabet.ALPHABET.contains(subStringsAnds[i])){//System.out.println("letra sin asterisco");
                        symbol = new Symbol(subStringsAnds[i],false);
                        symbol.setNumberWords(5);
                        lists.add(symbol.getSetOfWords());
                    }
                    else{//System.out.println("help  : " + listOfParentesis.get(Integer.valueOf(subStringsAnds[i])).length());
                        int lenght = listOfParentesis.get(Integer.valueOf(subStringsAnds[i])).length();
                        //System.out.println("lenght : "+ lenght);
                        System.out.println("paren : "+
                                listOfParentesis.get(Integer.valueOf(subStringsAnds[i])).substring(1,lenght-1));
                        lists.add(getMatrixResult(
                                listOfParentesis.get(Integer.valueOf(subStringsAnds[i])).substring(1,lenght - 1)));
                    }
                }else{//con asteriscos
                    if(Alphabet.ALPHABET.contains(subStringsAnds[i].substring(0, 1))){
                        symbol = new Symbol(subStringsAnds[i].substring(0, 1),true);
                        symbol.setNumberWords(5);
                        lists.add(symbol.getSetOfWords());
                    }
                    else{//System.out.println("pase por aqui");System.out.println("ññ"+listOfParentesis.get(Integer.valueOf(subStringsAnds[i].substring(0, 1))));
                        list = getMatrixResult(listOfParentesis.get(Integer.valueOf(subStringsAnds[i].substring(0, 1))));
                        lists.add(AsteriscoParentesis(list));
                    }
                }
                //System.out.println("---------------");
            }   
            return getMatrixMultiplication(lists);
        }
        else{
            lists = new ArrayList<>();
            size = subStrings.length;
            for(i = 0 ; i < size ; i++){
                lists.add(getMatrixResult(subStrings[i]));
            }
            
            //put all the list in only one listAll
            ArrayList<String> listAll = new ArrayList<>();
            size = lists.size();
            for(i = 0; i < size ; i++){
                for(String s : lists.get(i)){
                    listAll.add(s);
                }
            }
            
            return listAll;
        }
        
    }
    
}
