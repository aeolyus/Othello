public abstract class Board{
    private int score1,score2;
    int[][] board;
    public Board(int i){
        board=new int[i][i];
    }
    public abstract void place(int x, int y, int player);
    public boolean full(){
        for(int i:board)
            if(i==0)
                return false;
        return true;
    }
     public int getScore1(){
        calculateScore1();
        return score1;
    }
    public int getScore2(){
        calculateScore2();
        return score2;
    }
    public abstract calculateScore1();
    public abstract calculateScore2();
    public abstract printBoard();
}