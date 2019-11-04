public class Main {
    public static void main(String[] args) {

        PlugBoard board = new PlugBoard();
        board.defaultPlugs();
        System.out.println(board.getPlugs());
        board.changePlug('a','f');
        System.out.println(board.getPlugs());
        board.changePlug('s','m');
        System.out.println(board.getPlugs());
        board.defaultPlugs();
        System.out.println(board.getPlugs());


        System.out.println( "michal->" + board.cipher("michal"));
        System.out.println( "dima->" + board.cipher("dima"));
        System.out.println( "saar->" + board.cipher("saar"));






    }
}