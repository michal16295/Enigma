import java.util.ArrayList;

public class PlugBoard {
    private ArrayList<Plug> plugs;
    private int size = 10;

    public PlugBoard(){
        plugs = new ArrayList<>();

    }
    private void setPlugs(char plugA, char plugB){
        if(plugs.size() < size) {
            Plug plug = new Plug(plugA, plugB);
            plugs.add(plug);
        }
        else throw new OutOfMemoryError("THE PLUG-BOARD IS FULL!");

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
        plugs.removeAll(plugs);
        for(int i = 0 ; i < chars.length() ; i+=2){
            plugs.add(new Plug(chars.charAt(i) ,chars.charAt(i+1)));
        }
    }
    public ArrayList<Plug> getPlugs(){
        return plugs;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
