public class Main {
    public static void main(String[] args) {

        PlugBoard board = new PlugBoard();
        board.defaultPlugs();
        System.out.println(board.getPlugs());
        board.changePlug('a','f');
        System.out.println(board.getPlugs());


    }
}