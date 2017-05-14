/**
 * Abstract class for a board
 */
public abstract class Board{
    protected int score1,score2;
    int[][] board;
    public Board(int i){
        board=new int[i][i];
    }
    /**
     * Places a player piece on the coordinates
     * @param y y coordinate
     * @param x x coordiante
     * @param player current player
     */
    public abstract void place(int y, int x, int player);
    public boolean full(){
        for(int i[]:board)
            for(int j:i)
                if(j==0)
                    return false;
        return true;
    }
    /**
     * Gets the score of player 1
     * @return returns the score of player 1
     */
     public int getScore1(){
        calculateScore1();
        return score1;
    }
     /**
      * Gets the score of player 2
      * @return returns the score of player 2
      */
    public int getScore2(){
        calculateScore2();
        return score2;
    }
    /**
     * Calculates the score of player 1
     */
    public abstract void calculateScore1();
    /**
     * Calculates the score of player 1
     */
    public abstract void calculateScore2();
    /**
     * Prints the board
     */
    public abstract void printBoard();
    /**
     * Returns if the move is legal
     * @param i y coord
     * @param j x coord
     * @param player current player
     * @return true if the move is legal and false if the move is illegal
     */
    public abstract boolean isLegal(int i, int j,int player);
}