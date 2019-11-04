public class Main {
    public static void main(String[] args) {

        Board board = new Board();
        System.out.println(board.getPlugs());
        board.defaultBoard();
        System.out.println(board.getPlugs());

        System.out.println(board.cipher("michal"));
        System.out.println(board.cipher("dima"));
        System.out.println(board.cipher("saar"));
        System.out.println(board.isPlugTaken('i'));

        board.setPlugs('m','a');
        System.out.println(board.getPlugs());






    }
}