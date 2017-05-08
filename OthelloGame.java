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
    
        
    // Check if there are any more moves to make
       boolean done = true;
       for (int i=1; i<game.HEIGHT-1; i++)
           for (int j=1; j<game.WIDTH-1; j++)
               if ((game.legalMove(i,j,BLACK,false)) ||
                   (game.legalMove(i,j,WHITE,false)))
                   done=false;

       g.setColor(Color.RED);
       if (done) {
           if (wCount > bCount)
               g.drawString("White won with " + wCount + " discs.",10,20);
           else if (bCount > wCount)
               g.drawString("Black won with " + bCount + " discs.",10,20);
           else g.drawString("Tied game",10,20);
       }
       else {     
           if (wCount > bCount)
               g.drawString("White is winning with " + wCount+" discs",10,20);
           else if (bCount > wCount)
               g.drawString("Black is winning with " + bCount+" discs",10,20);
           else g.drawString("Currently tied",10,20);
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
