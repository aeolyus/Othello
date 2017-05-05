public abstract class Board{
    int[][] board;
    public Board(int i){
        board=new int[i][i];
    }
    public abstract void place(int x, int y, int player);
}