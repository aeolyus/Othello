public class Othello implements Game{
    private OthelloBoard board;
    private int currentPlayer;
    public Othello(){
        board=new OthelloBoard();
        currentPlayer=1;
    }
    public void start(){
        board=new OthelloBoard();
        play();
    }
    public boolean isLegal(int i, int j, int player){
        //TODO: implement later
        for (int y = 0; y < i; y++){
            
        }
    }
    public void play(){
        while(!gameOver()){
            //TODO: current player plays
            board.printBoard();
        }
    }
    /**
     * Checks for legal moves left and board space
     */ 
    public boolean gameOver(){
        if(board.full()){
            for(int i=0;i<8;i++)
                for(int j=0;j<8;j++)
                    if(isLegal(i,j,currentPlayer)
                        return false;
            return true;
            int winner=board.getScore1()>board.getScore2()?1:2;
            System.out.println("Player "+winner+" wins!");
        }
    }
}