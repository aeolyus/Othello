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
        boolean canDo = false;
        int otherPlayer;
        if (player == 1){
            otherPlayer == 2;
        }else if (player == 2){
            otherPlayer == 1;
        }
        
        if (board[i][j] == player || board[i][j] == otherPlayer){
            System.out.print("Error: That space is not empty");
            return canDo;
        }
        
        int topLeft = board[i-1][j-1];
        if (topLeft == otherPlayer){
            int y = j-2;
            for (int x = i-2; x >= 0; x--){
                if (board[x][y] == player){
                    canDo = true;
                    break;
                }else if(board[x][y] == 0){
                    break;
                }else(board[x][y] == otherPlayer){
                    y--;
                }
            }
        }
        int topMid = board[i-1][j];
        if (topMid == otherPlayer){
            for (int x = i-2; x >= 0; x--){
                if (board[x][y] == player){
                    canDo = true;
                    break;
                }else if(board[x][y] == 0){
                    break;
                }else(board[x][y] == otherPlayer){
                    y--;
                }
            }
        }
        int topRight = board[i-1][j+1];
        int midLeft = board[i][j-1];
        int midRight = board[i][j+1];
        int botLeft = board[i+1][j-1];
        int botMid = board[i+1][j];
        int botRight = board[i+1][j+1];
    }
    public void play(){
        Scanner in = new Scanner(System.in);
        while(!gameOver()){
            System.out.println("Player 1, Enter x-coord");
            int x = in.nextInt();
            System.out.println("Player 1, Enter y-coord");
            int y = in.nextInt();
            while (isLegal(x, y, 1) != true){
                System.out.println("Error: Invalid move")
                System.out.println("Player 1, Enter x-coord");
                int x = in.nextInt();
                System.out.println("Player 1, Enter y-coord");
                int y = in.nextInt();
            }
            System.out.println("Player 2, Enter x-coord");
            int x = in.nextInt();
            System.out.println("Player 2, Enter y-coord");
            int y = in.nextInt();
            while (isLegal(x, y, 1) != true){
                System.out.println("Error: Invalid move")
                System.out.println("Player 2, Enter x-coord");
                int x = in.nextInt();
                System.out.println("Player 2, Enter y-coord");
                int y = in.nextInt();
            }
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
                    if(isLegal(i,j,currentPlayer))
                        return false;
            return true;
            int winner=board.getScore1()>board.getScore2()?1:2;
            System.out.println("Player "+winner+" wins!");
        }
    }
}