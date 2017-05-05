public class extends Board{
    public OthelloBoard(){
        super(8,8);//0- blank, 1- player 1, 2- player 2
        board[3][3]=board[4][4]=1;
        board[3][4]=board[4][3]=2;
    }
    public void place(int x, int y, int player){
        //TODO: places a player piece
            capture();
        
    }
    /**
     * Captures the pieces that are in adjacent to it linear-ly
     */
    public void capture(){
        //TODO
    }
    /**
     * Calculates the score for player 1
     */
    public int calculateScore1(){
        score1=0;
        for(int i=0;i<8;i++)
            for(int j=0;j<8;j++)
                if(board[i][j]==1)
                    score1++;
    }
    /**
     * Calculates the score for player 2
     */
    public int calculateScore2(){
        score2=0;
        for(int i=0;i<8;i++)
            for(int j=0;j<8;j++)
                if(board[i][j]==2)
                    score2++;
        
    }
    /**
     * Prints the board out
     */
     public void printBoard(){
        System.out.println("Player 1 (X) Score: "+getScore1());
        System.out.println("Player 2 (O) Score: "+getScore2());
        for(int i=0;i<8;i++)
            for(int j=0;j<8;j++){
                if(board[i][j]==1)
                    System.out.println("X");
                else if(board[i][j]==2)
                    System.out.println("O");
                else
                    System.out.println("-");
            }
     }
}