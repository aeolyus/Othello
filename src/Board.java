public abstract class Board{
    protected int score1,score2;
    int[][] board;
    public Board(int i){
        board=new int[i][i];
    }
    public abstract void place(int x, int y, int player);
    public boolean full(){
        for(int i[]:board)
            for(int j:i)
                if(j==0)
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
    public abstract void calculateScore1();
    public abstract void calculateScore2();
    public abstract void printBoard();
    public abstract boolean isLegal(int i, int j,int player);
}