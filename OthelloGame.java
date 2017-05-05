public class Othello implements Game{
    private OthelloBoard board;
    public Othello(){
        board=new OthelloBoard();
    }
    public void start(){
        board=new OthelloBoard();
        play();
    }
    public boolean isLegal(int i, int j, int player){
        //implement later
    }
    public void play(){
        while(!gameOver()){
            //plays the game
        }
    }
    /**
     * Checks for legal moves left and board space
     */ 
    public boolean gameOver(){
        
    }
}