package clases;

import java.util.ArrayList;

public class NoParentesis {

    private String regularExpression;
    private String alpahabet; 
    
    public NoParentesis(String regularExpression) {
        this.regularExpression = regularExpression;
        this.alpahabet = Alphabet.ALPHABET;
    }

    public String getRegularExpression() {
        return regularExpression;
    }

    public void setRegularExpression(String regularExpression) {
        this.regularExpression = regularExpression;
    }

    public String getAlpahabet() {
        return alpahabet;
    }

    public void setAlpahabet(String alpahabet) {
        this.alpahabet = alpahabet;
    }
    
    public String [] separate(String string){
        return string.split("\\|");
    }
    
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
    
    public ArrayList<String> getListResult(String string){
        ArrayList<ArrayList<String>> listOfArrayList = new ArrayList<>();
        String [] symbolsArray = string.split("\\.");
        //System.out.println("le : " + symbolsArray.length);
        int i;
        int cant = symbolsArray.length;
        Symbol symbol;
        for(i = 0; i < cant ; i++){
            if(symbolsArray[i].length() == 1){
                symbol = new Symbol(symbolsArray[i], false);
                listOfArrayList.add(symbol.getSetOfWords());
            }else{
                symbol = new Symbol(symbolsArray[i].substring(0, 1), true);
                listOfArrayList.add(symbol.getSetOfWords());
            }
        }
        return getMatrixMultiplication(listOfArrayList);
    }
    
    public ArrayList<String> getMatrix(){
        String [] subStrings = separate(regularExpression);
        System.out.println("subStrings lenght : " + subStrings.length);
        /*for(String a  : subStrings){
            System.out.println(a);
        }*/
        //if not contains the operator OR
        if(subStrings.length == 1){
            return getListResult(subStrings[0]);
        }
        else{
            ArrayList<String> listOfWords = new ArrayList<>();
            ArrayList<String> aux;
            int size = subStrings.length;
            int size2;
            int i, j;
            
            for(i = 0; i < size ; i++){
                aux = getListResult(subStrings[i]);
                size2 = aux.size();
                for(j = 0; j < size2; j++){
                    listOfWords.add(aux.get(j));
                }
            }
            return listOfWords;
        }
        
    }
    
}
