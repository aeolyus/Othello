public class OthelloBoard extends Board{
    public OthelloBoard(){
        super(8);//0- blank, 1- player 1, 2- player 2
        board[3][3]=board[4][4]=1;
        board[3][4]=board[4][3]=2;
    }
    
    public boolean isLegal(int i, int j, int player){
        boolean canDo = false;
        int otherPlayer=0;
        if (player == 1){
            otherPlayer = 2;
        }else if (player == 2){
            otherPlayer = 1;
        }
        
        if (board[i][j] == player || board[i][j] == otherPlayer){
            System.out.print("Error: That space is not empty");
            return canDo;
        }
        
        int topLeft = board[i-1][j-1];
            if (topLeft == otherPlayer){
                int y = j-2;
                for (int x = i-2; x >= 0 && y >= 0; x--){
                    if (board[x][y] == player){
                        canDo = true;
                        break;
                    }else if(board[x][y] == 0){
                        break;
                    }else if(board[x][y] == otherPlayer){
                        y--;
                    }
                }
            }
        int topMid = board[i-1][j];
            if (topMid == otherPlayer){
                int y = i;
                for (int x = i-2; x >= 0; x--){
                    if (board[x][y] == player){
                        canDo = true;
                        break;
                    }else if(board[x][y] == 0){
                        break;
                    }else if(board[x][y] == otherPlayer){
                    }
                }
            }
        int topRight = board[i-1][j+1];
            if (topRight == otherPlayer){
                int x = j-2;
                for (int y = i+2; y < board[0].length && y < board.length; x++){
                    if (board[x][y] == player){
                        canDo = true;
                        break;
                    }else if(board[x][y] == 0){
                        break;
                    }else if(board[x][y] == otherPlayer){
                        x--;
                    }
                }
            }
        int midLeft = board[i-1][j];
            if (midLeft == otherPlayer){
                int y = j;
                for (int x = i-2; x >= 0; x--){
                    if (board[x][y] == player){
                        canDo = true;
                        break;
                    }else if(board[x][y] == 0){
                        break;
                    }else if(board[x][y] == otherPlayer){
                    }
                }
            }
        int midRight = board[i-1][j];
            if (midRight == otherPlayer){
                int y = j;
                for (int x = i-2; x >= 0; x--){
                    if (board[x][y] == player){
                        canDo = true;
                        break;
                    }else if(board[x][y] == 0){
                        break;
                    }else if(board[x][y] == otherPlayer){
                    }
                }
            }
        int botLeft = board[i+1][j-1];
            if (topLeft == otherPlayer){
                int y = j-2;
                for (int x = i-2; x >= 0 && y >= 0; x--){
                    if (board[x][y] == player){
                        canDo = true;
                        break;
                    }else if(board[x][y] == 0){
                        break;
                    }else if(board[x][y] == otherPlayer){
                        y--;
                    }
                }
            }
        int botMid = board[i+1][j];
        int botRight = board[i+1][j+1];
        return canDo;
    }
    /**
     * Places a piece on the board (coordinates start at (0,0))
     */
    public void place(int x, int y, int player){
            board[x][y]=player;
            capture(x,y,player);
    }
    /**
     * Captures the pieces that are in adjacent to it linear-ly
     */
    public void capture(int x,int y,int player){
        boolean flag=true; //true until first piece is found
        //horizontal right
        for(int i=1;x+i<board[0].length&&flag;i++)
            if(board[x+i][y]==player){
                flag=false;
                for(int j=x+i;j>x;j--)
                    board[j][y]=player;
            }
        flag=true;
        //vertical down
        for(int j=1;y+j<board.length&&flag;j++)
            if(board[x][y+j]==player){
                flag=false;
                for(int k=y+j;k>x;k--)
                    board[x][k]=player;
            }
        flag=true;
        //horizontal left
        for(int i=1;x-i>=0&&flag;i++)
            if(board[x-i][y]==player){
                flag=false;
                for(int j=x-i;j<x;j++)
                    board[j][y]=player;
            }
        flag=true;
        //vertical up
        for(int j=1;y-j>=0&&flag;j++)
            if(board[x][y-j]==player){
                flag=false;
                for(int k=y-j;k<x;k++)
                    board[x][k]=player;
            }
        flag=true;
        //diagonal right-down
        for(int i=1;x+i<board[0].length&&y+i<board.length&&flag;i++)
            if(board[x+i][y+i]==player){
                flag=false;
                for(int j=i;j>0;j--)
                    board[x+j][y+j]=player;
            }
        flag=true;
        //diagonal right-up
        for(int i=1;x+i<board[0].length&&y-i>=0&&flag;i++)
            if(board[x+i][y-i]==player){
                flag=false;
                for(int j=i;j>0;j--)
                    board[x+j][y-j]=player;
            }
        flag=true;
        //diagonal left-down
        for(int i=1;x-i>=0&&y+i<board.length&&flag;i++)
            if(board[x-i][y+i]==player){
                flag=false;
                for(int j=i;j>0;j--)
                    board[x-j][y+j]=player;
            }
        flag=true;
        //diagonal left-up
        for(int i=1;x-i>=0&&y-i>=0&&flag;i++)
            if(board[x-i][y-i]==player){
                flag=false;
                for(int j=i;j>0;j--)
                    board[x-j][y-j]=player;
            }
    }
    /**
     * Calculates the score for player 1
     */
    public void calculateScore1(){
        score1=0;
        for(int i=0;i<8;i++)
            for(int j=0;j<8;j++)
                if(board[i][j]==1)
                    score1++;
    }
    /**
     * Calculates the score for player 2
     */
    public void calculateScore2(){
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
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(board[i][j]==1)
                    System.out.print("X  ");
                else if(board[i][j]==2)
                    System.out.print("O  ");
                else
                    System.out.print("~  ");
            }
            System.out.println();
        }
     }
}