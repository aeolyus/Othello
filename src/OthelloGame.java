import java.util.*;
public class OthelloGame implements Game{
    private OthelloBoard board;
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
            board.printBoard();
            do{
                System.out.println("Player 1, Enter x-coord");
                x = in.nextInt();
                System.out.println("Player 1, Enter y-coord");
                y = in.nextInt();
            }while(board.isLegal(x, y, 1) != true);
            board.place(x,y,1);
            do{
                System.out.println("Player 2, Enter x-coord");
                x = in.nextInt();
                System.out.println("Player 2, Enter y-coord");
                y = in.nextInt();
            } while(board.isLegal(x, y, 2) != true);
            board.place(x,y,2);
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
                    if(board.isLegal(i,j,currentPlayer))
                        return false;
            int winner=board.getScore1()>board.getScore2()?1:2;
            System.out.println("Player "+winner+" wins!");
            return true;
        }
        return false;
    }
}