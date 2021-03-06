import java.util.*;
public class OthelloGame implements Game{
    OthelloBoard board;
    private int currentPlayer;
    private boolean cpu=true;
    private Scanner in;
    /**
     * Creates a new Othello  game
     */
    public OthelloGame(){
        board=new OthelloBoard();
        currentPlayer=1;
    }
    /**
     * Starts the game
     */
    public void start(){
    	in=new Scanner(System.in);
        board=new OthelloBoard();
        System.out.print("Enter 1 for PvP or 2 for PvCPU: ");
        cpu=in.nextInt()>1?true:false;
        play(1);
    }
    
    //Richard is abusive
    
    /**
     * Plays the game
     * @param player current player
     */
    public void play(int player){
    	int x,y;
    	board.printBoard();
    	if(!gameOver()){
    		if(!cpu){
    			System.out.print("Player "+player+" , Enter y-coord: ");
    			x=in.nextInt();
    			System.out.print("Player "+player+" , Enter x-coord: ");
    			y=in.nextInt();
    			System.out.println();
    			if(board.isLegal(x,y,player)){
    				board.place(x,y,player);
    				if(player==1)
    					play(2);
    				else
    					play(1);
    			}else{
    				System.out.println("Illegal move. Try again.");
    				play(player);
    			}
    		}else{
    			if(player==1){
    				System.out.print("Player "+player+" , Enter y-coord: ");
        			x=in.nextInt();
        			System.out.print("Player "+player+" , Enter x-coord: ");
        			y=in.nextInt();
        			System.out.println();
        			if(board.isLegal(x,y,player)){
        				board.place(x,y,player);
        				if(player==1)
        					play(2);
        				else
        					play(1);
        			}else{
        				System.out.println("Illegal move. Try again.");
        				play(player);
        			}
    			}else if(player==2){//cpu
    				boolean placed=false;
    				for(int i=0;i<8&&!placed;i++){
    					for(int j=0;j<8&&!placed;j++){
    						if(board.isLegal(i,j,player)){
    							placed=true;
    							board.place(i,j,player);
    						}
    					}
    				}
    				play(1);
    			}
    		}
    	}else{
    		int winner=board.getScore1()>board.getScore2()?1:2;
    		board.printBoard();
    		System.out.println("Player "+winner+" wins!");
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
            return true;
        }
        return false;
    }
}      