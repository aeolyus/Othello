public class OthelloBoard extends Board{
	/**
	 * Creates an Othello board
	 */
    public OthelloBoard(){
        super(8);//0- blank, 1- player 1, 2- player 2
        board[3][3]=board[4][4]=2;
        board[3][4]=board[4][3]=1;
    }
    /**
     * Checks if coordinate is on the board
     */
    public boolean onBoard(int x, int y){
        if(x>=0&&x<board.length&&y>=0&&y<board[0].length)
            return true;
        return false;
    }
    /**
     * Checks if the move legal
     * @param y y coord
     * @param x xcoord
     * @param player current player
     */
    public boolean isLegal(int x, int y, int player){
        //boolean canDo = false;
        int otherPlayer=0;
        if (player == 1){
            otherPlayer = 2;
        }else if (player == 2){
            otherPlayer = 1;
        }
        
        if (!onBoard(x,y)){
            return false;
        }
        //checks if empty space
        if (board[x][y]!=0){
            return false;
        }
        //checks if inside board
        
        boolean adjacent=false; //is true if at least one piece of the opposite color is adjacent
        for(int i=-1;i<=1;i++){
            for(int j=-1;j<=1;j++){
                if(onBoard(x+i,y+j)){
                    if(board[x+i][y+j]==otherPlayer){
                        adjacent=true;
                    }
                }
            }
        }
                        
        if(!adjacent)
            return false;
            
        boolean flag=true; //
        //vertical down
        if(onBoard(x+1,y)&&board[x+1][y]==otherPlayer){
            for(int i=1;x+i<board.length&&flag;i++){
                if(board[x+i][y]==0){
                    flag=false;
                }
                if(board[x+i][y]==player){
                    return true;
                }
            }
        }
        flag=true;
        //horizontal right
        if(onBoard(x,y+1)&&board[x][y+1]==otherPlayer){
            for(int j=1;y+j<board.length&&flag;j++){
                if(board[x][y+j]==0){
                    flag=false;
                }
                if(board[x][y+j]==player){
                    return true;
                }
            }
        }   
        flag=true;
        //vertical up
        if(onBoard(x-1,y)&&board[x-1][y]==otherPlayer){
            for(int i=1;x-i>=0&&flag;i++){
                if(board[x-i][y]==0){
                    flag=false;
                }
                if(board[x-i][y]==player){
                    return true;
                }
            }
        }
        flag=true;
        //horizontal left
        if(onBoard(x,y-1)&&board[x][y-1]==otherPlayer){
            for(int j=1;y-j>=0&&flag;j++){
                if(board[x][y-j]==0){
                    flag=false;
                }
                if(board[x][y-j]==player){
                    return true;
                }
            }
        }
        flag=true;
        //diagonal right-down
        if(onBoard(x+1,y+1)&&board[x+1][y+1]==otherPlayer){
            for(int i=1;x+i<board[0].length&&y+i<board.length&&flag;i++){
                if(board[x+i][y+i]==0){
                    flag=false;
                }
                if(board[x+i][y+i]==player){
                    return true;
                }
            }
        }
        flag=true;
        //diagonal down-left
        if(onBoard(x+1,y-1)&&board[x-1][y-1]==otherPlayer){
            for(int i=1;x+i<board[0].length&&y-i>=0&&flag;i++){
                if(board[x+i][y-i]==0){
                    flag=false;
                }
                if(board[x+i][y-i]==player){
                    return true;
                }
            }
        }
        flag=true;
        //diagonal up-right
        if(onBoard(x-1,y+1)&&board[x-1][y+1]==otherPlayer){
            for(int i=1;x-i>=0&&y+i<board.length&&flag;i++){
                if(board[x-i][y+i]==0){
                    flag=false;
                }
                if(board[x-i][y+i]==player){
                    return true;
                }
            }
        }
        flag=true;
        //diagonal left-up
        if(onBoard(x-1,y-1)&&board[x-1][y-1]==otherPlayer){
            for(int i=1;x-i>=0&&y-i>=0&&flag;i++){
                if(board[x-i][y-i]==0){
                    flag=false;
                }
                if(board[x-i][y-i]==player){
                return true;
                }
            }
        }
        return false;
    }

    
    /**
     * Places a piece on the board (coordinates start at (0,0))
     * @param y y coord
     * @param x x coord
     * @param player current player
     */
    public void place(int y, int x, int player){
            board[y][x]=player;
            capture(y,x,player);
    }
    /**
     * Captures the pieces that are in adjacent to it linear-ly
     * @param y
     * @param x
     * @param player
     */
    public void capture(int y,int x,int player){
        boolean flag=true; //true until first piece or empty space is found
        //vertical down
        for(int i=1;y+i<board.length&&flag;i++){
            if(board[y+i][x]==0)
                flag=false;
            if(board[y+i][x]==player){
                flag=false;
                for(int j=y+i;j>y;j--)
                    board[j][x]=player;
            }
        }
        flag=true;
        //horizontal right
        for(int j=1;x+j<board.length&&flag;j++){
            if(board[y][x+j]==0)
                flag=false;
            if(board[y][x+j]==player){
                flag=false;
                for(int k=x+j;k>x;k--)
                    board[y][k]=player;
            }
        }
        flag=true;
        //vertical up
        for(int i=1;y-i>=0&&flag;i++){
            if(board[y-i][x]==0)
                flag=false;
            if(board[y-i][x]==player){
                flag=false;
                for(int j=y-i;j<y;j++)
                    board[j][x]=player;
            }
        }
        flag=true;
        //horizontal left
        for(int j=1;x-j>=0&&flag;j++){
            if(board[y][x-j]==0)
                flag=false;
            if(board[y][x-j]==player){
                flag=false;
                for(int k=x-j;k<x;k++)
                    board[y][k]=player;
            }
        }
        flag=true;
        //diagonal right-down
        for(int i=1;y+i<board[0].length&&x+i<board.length&&flag;i++){
            if(board[y+i][x+i]==0)
                flag=false;
            if(board[y+i][x+i]==player){
                flag=false;
                for(int j=i;j>0;j--)
                    board[y+j][x+j]=player;
            }
        }
        flag=true;
        //diagonal down-left
        for(int i=1;y+i<board[0].length&&x-i>=0&&flag;i++){
            if(board[y+i][x-i]==0)
                flag=false;
            if(board[y+i][x-i]==player){
                flag=false;
                for(int j=i;j>0;j--)
                    board[y+j][x-j]=player;
            }
        }
        flag=true;
        //diagonal up-right
        for(int i=1;y-i>=0&&x+i<board.length&&flag;i++){
            if(board[y-i][x+i]==0)
                flag=false;
            if(board[y-i][x+i]==player){
                flag=false;
                for(int j=i;j>0;j--)
                    board[y-j][x+j]=player;
            }
        }
        flag=true;
        //diagonal left-up
        for(int i=1;y-i>=0&&x-i>=0&&flag;i++){
            if(board[y-i][x-i]==0)
                flag=false;
            if(board[y-i][x-i]==player){
                flag=false;
                for(int j=i;j>0;j--)
                    board[y-j][x-j]=player;
            }
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
        System.out.print(" ");
        for(int i=0;i<8;i++)
            System.out.print("  "+i);
        System.out.println();
        for(int i=0;i<8;i++){
            System.out.print(i+"  ");
            for(int j=0;j<8;j++){
                if(board[i][j]==1)
                    System.out.print("X  ");
                else if(board[i][j]==2)
                    System.out.print("O  ");
                else
                    System.out.print("*  ");
            }
            System.out.println();
        }
    }
}