public class Plug {
    private char plugA;
    private char plugB;

    public Plug(char plugA, char plugB){
        if(checkClashing(plugA, plugB))
        {
            this.plugA = plugA;
            this.plugB = plugB;
        }

    }
    public Plug(){
        this.plugA = 'a';
        this.plugB = 'b';
    }

    public char getPlugA(){return plugA;}
    public char getPlugB(){return plugB;}

    public boolean checkClashing(char plugA, char plugB){
        if(plugA == plugB) return false;
        return true;
    }
    public char getOutput(char input){
        if(input == plugA) return plugB;
        else if(input == plugB) return plugA;
        return '-';
    }
    public void changePair(char plug){
        this.plugB = plug;
    }
    public boolean equals(Plug obj){
        if(this.plugA == obj.plugA && this.plugB == obj.plugB) return true;
        return false;
    }

    @Override
    public String toString() {
        return plugA + " " + plugB;
    }
}
