package clases;

import java.util.ArrayList;

public class Symbol {
    
    private String token;
    private boolean  loop;
    private ArrayList<String> listWords;
    private int numberWords = 20;
    
    public Symbol(String token, boolean loop) {
        this.token = token;
        this.loop = loop;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean isLoop() {
        return loop;
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }

    public int getNumberWords() {
        return numberWords;
    }

    public void setNumberWords(int numberWords) {
        this.numberWords = numberWords;
    }
    
    
    
    public ArrayList<String> getSetOfWords(){
        if (loop) {
            if(listWords == null){
                listWords = new ArrayList<>();
                int i;
                listWords.add(Lambda.VALUE);
                StringBuilder stringBuilder = new StringBuilder();
                for(i=1 ;i<numberWords; i++){
                    stringBuilder.append(token);
                    listWords.add(stringBuilder.toString());
                }
                return listWords;
            }
            return listWords;
        }
        listWords = new ArrayList<>();
        listWords.add(token);
        return listWords;
    }
    
}
