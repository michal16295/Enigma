import java.util.ArrayList;

public class PlugBoard {
    private ArrayList<Plug> plugs;
    private char[] tmp;
    private int size = 10;

    public PlugBoard(){
        plugs = new ArrayList<>();

    }
    public void setPlugs(char plugA, char plugB){
        if(plugs.size() < 20) {
            Plug plug = new Plug(plugA, plugB);
            plugs.add(plug);
        }
        else throw new OutOfMemoryError("THE PLUGBOARD IS FULL!");

    }
    public void changePlug(char plugA, char plugB){
        Plug tempA = new Plug();
        Plug tempB = new Plug();
        Plug tempC = new Plug();

        for(Plug p: plugs){
            if(p.getPlugA() == plugA) tempA = p;
            if(p.getPlugB() == plugB) tempB = p;
            if(p.getPlugA() == plugB || p.getPlugB() == plugA) tempC = p;
        }
        plugs.remove(tempA);
        plugs.remove(tempB);
        plugs.remove(tempC);
        setPlugs(plugA, plugB);


    }
    public void defaultPlugs(){
        String chars = "swaqnpfovyuxmkclhtzj";
        for(int i = 0 ; i < chars.length() ; i+=2){
            plugs.add(new Plug(chars.charAt(i) ,chars.charAt(i+1)));
        }
    }
    public ArrayList<Plug> getPlugs(){
        return plugs;
    }
    public int convertToIntIndex(char c){
        return (int)c % 32;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
