public class Board {
    private char[] plugs;

    public Board(){
        plugs = new char[26];
        String alph = "abcdefghijklmnopqrstuvwxyz";
        plugs = alph.toCharArray();
    }
    public void defaultBoard(){
        String def = "swaqnpfovyuxmkclhtzj";
        for(int i = 0 ; i < def.length(); i+=2){
            setPlugs(def.charAt(i), def.charAt(i+1));
        }
    }
    public int convertCharToIndex(char c){
        return (int)c - 97;
    }
    public char convertIdexToChar(int num){
        num += 97;
        return (char)num;
    }
    public void setPlugs(char plugA, char plugB){

        disconnectPlugs(plugA);
        disconnectPlugs(plugB);
        plugs[convertCharToIndex(plugA)] = plugB;
        plugs[convertCharToIndex(plugB)] = plugA;


    }
    public char[] getPlugs(){
        return plugs;
    }
    public String cipher(String text){
        String newText = "";
        for(int i = 0 ; i < text.length(); i++){
            newText += plugs[convertCharToIndex(text.charAt(i))];
        }
        return newText;
    }
    public boolean isPlugTaken(char plug){
        if(plugs[convertCharToIndex(plug)] == plug) return false;
        return true;
    }
    public void disconnectPlugs(char plugA){
        char a = plugs[convertCharToIndex(plugA)];
        plugs[convertCharToIndex(a)] = a;
    }
    public char cipherChar(char c){
        return plugs[convertCharToIndex(c)];
    }
}

