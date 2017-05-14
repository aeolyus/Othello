import java.util.*;
public class OthelloGame implements Game{
    OthelloBoard board;
    private int currentPlayer;
    public OthelloGame(){
        board=new OthelloBoard();
        currentPlayer=1;
    }
    public void start(){
        board=new OthelloBoard();
        play();
    }
    
    //Richard is abusive
    
    /**
     * Main game runner
     */
    public void play(){
        Scanner in = new Scanner(System.in);
        int x,y;
        while(!gameOver()){
            if(!gameOver()){
                board.printBoard();
                 do{
                    System.out.print("Player 1, Enter y-coord: ");
                    x = in.nextInt();
                    System.out.print("Player 1, Enter x-coord: ");
                    y = in.nextInt();
                    System.out.println();
                 }while(board.isLegal(x, y, 1) != true);
                board.place(x,y,1);
                board.printBoard();
            }
            if(!gameOver()){
                 do{
                    System.out.print("Player 2, Enter y-coord: ");
                    x = in.nextInt();
                    System.out.print("Player 2, Enter x-coord: ");
                    y = in.nextInt();
                    System.out.println();
                 } while(board.isLegal(x, y, 2) != true);
                board.place(x,y,2);
            }
        }
        int winner=board.getScore1()>board.getScore2()?1:2;
        board.printBoard();
        System.out.println("Player "+winner+" wins!");
    }

    /**
     * Checks for legal moves left and board space
     */ 
    public boolean gameOver(){
        if(board.full()){
            for(int i=0;i<8;i++)
                for(int j=0;j<8;j++)
                    if(board.isLegal(i,j,currentPlayer))
                        return false;
            return true;
        }
        return false;
    }
}



 /*public void paintComponent(Graphics g) {
      
       super.paintComponent(g);  // Fill panel with background color
       
       int width = getWidth();
       int height = getHeight();
       int xoff = width/(game.WIDTH-2);
       int yoff = height/(game.HEIGHT-2);

       int bCount=0;                     
       int wCount=0;                        

       // Draw the lines on the board
       g.setColor(Color.BLACK);
       for (int i=1; i<=game.HEIGHT-2; i++) {        
           g.drawLine(i*xoff, 0, i*xoff, height);
           g.drawLine(0, i*yoff, width, i*yoff);
       }

       // Draw discs on the board and show the legal moves
       for (int i=1; i<game.HEIGHT-1; i++) {        
           for (int j=1; j<game.WIDTH-1; j++) {
               // Draw the discs
               if (game.board[i][j] == BLACK) {       
                   g.setColor(Color.BLACK);
                   g.fillOval((j*yoff)-yoff+7,(i*xoff)-xoff+7,50,50); 
                   bCount++;
               }
               else if (game.board[i][j] == WHITE) {  
                   g.setColor(Color.WHITE);
                   g.fillOval((j*yoff)-yoff+7,(i*xoff)-xoff+7,50,50);
                   wCount++;
               }
               // Show the legal moves for the current player
               if (turn == BLACK && game.isLegal(i,j,BLACK,false)) {
                   g.setColor(Color.BLACK);
                   g.fillOval((j*yoff+29)-yoff,(i*xoff+29)-xoff,6,6);
               }
               // If other player cannot move, current player cleans up
               if (turn == WHITE && game.isLegal(i,j,WHITE,false)) {
                   g.setColor(Color.WHITE);
                   g.fillOval((j*yoff+29)-yoff,(i*xoff+29)-xoff,6,6);
               }
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
       }*/
      