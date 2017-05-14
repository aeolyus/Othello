public class OthelloBoard extends Board{
    public OthelloBoard(){
        super(8);//0- blank, 1- player 1, 2- player 2
        board[3][3]=board[4][4]=2;
        board[3][4]=board[4][3]=1;
    }
    
    public boolean isLegal(int x, int y, int player){
        //boolean canDo = false;
        int otherPlayer=0;
        if (player == 1){
            otherPlayer = 2;
        }else if (player == 2){
            otherPlayer = 1;
        }
        //checks if empty space
        if (board[x][y]!=0){
            return false;
        }
        //checks  if inside board
        if (!(x<board.length&&y<board[0].length&&x>=0&&y>=0)){
            return false;
        }
        
        boolean adjacent=false; //is true if at least one piece of the opposite color is adjacent
        for(int i=-1;i<=1;i++){
            for(int j=-1;j<=1;j++){
                if((x+i)>=0&&(x+i)<board.length&&(y+j)>=0&&(y+j)<board[0].length){
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
        for(int i=1;x+i<board.length&&flag;i++){
            if(board[x+i][y]==0){
                flag=false;
            }
            if(board[x+i][y]==player){
                return true;
            }
        }
        flag=true;
        //horizontal right
        for(int j=1;y+j<board.length&&flag;j++){
            if(board[x][y+j]==0){
                flag=false;
            }
            if(board[x][y+j]==player){
                return true;
            }
        }
        flag=true;
        //vertical up
        for(int i=1;x-i>=0&&flag;i++){
            if(board[x-i][y]==0){
                flag=false;
            }
            if(board[x-i][y]==player){
                return true;
            }
        }
        flag=true;
        //horizontal left
        for(int j=1;y-j>=0&&flag;j++){
            if(board[x][y-j]==0){
                flag=false;
            }
            if(board[x][y-j]==player){
                return true;
            }
        }
        flag=true;
        //diagonal right-down
        for(int i=1;x+i<board[0].length&&y+i<board.length&&flag;i++){
            if(board[x+i][y+i]==0){
                flag=false;
            }
            if(board[x+i][y+i]==player){
                return true;
            }
        }
        flag=true;
        //diagonal down-left
        for(int i=1;x+i<board[0].length&&y-i>=0&&flag;i++){
            if(board[x+i][y-i]==0){
                flag=false;
            }
            if(board[x+i][y-i]==player){
                return true;
            }
        }
        flag=true;
        //diagonal up-right
        for(int i=1;x-i>=0&&y+i<board.length&&flag;i++){
            if(board[x-i][y+i]==0){
                flag=false;
            }
            if(board[x-i][y+i]==player){
                return true;
            }
        }
        flag=true;
        //diagonal left-up
        for(int i=1;x-i>=0&&y-i>=0&&flag;i++){
            if(board[x-i][y-i]==0){
                flag=false;
            }
            if(board[x-i][y-i]==player){
                return true;
            }
        }
        return false;
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
        boolean flag=true; //true until first piece or empty space is found
        //vertical down
        for(int i=1;x+i<board.length&&flag;i++){
            if(board[x+i][y]==0)
                flag=false;
            if(board[x+i][y]==player){
                flag=false;
                for(int j=x+i;j>x;j--)
                    board[j][y]=player;
            }
        }
        flag=true;
        //horizontal right
        for(int j=1;y+j<board.length&&flag;j++){
            if(board[x][y+j]==0)
                flag=false;
            if(board[x][y+j]==player){
                flag=false;
                for(int k=y+j;k>y;k--)
                    board[x][k]=player;
            }
        }
        flag=true;
        //vertical up
        for(int i=1;x-i>=0&&flag;i++){
            if(board[x-i][y]==0)
                flag=false;
            if(board[x-i][y]==player){
                flag=false;
                for(int j=x-i;j<x;j++)
                    board[j][y]=player;
            }
        }
        flag=true;
        //horizontal left
        for(int j=1;y-j>=0&&flag;j++){
            if(board[x][y-j]==0)
                flag=false;
            if(board[x][y-j]==player){
                flag=false;
                for(int k=y-j;k<y;k++)
                    board[x][k]=player;
            }
        }
        flag=true;
        //diagonal right-down
        for(int i=1;x+i<board[0].length&&y+i<board.length&&flag;i++){
            if(board[x+i][y+i]==0)
                flag=false;
            if(board[x+i][y+i]==player){
                flag=false;
                for(int j=i;j>0;j--)
                    board[x+j][y+j]=player;
            }
        }
        flag=true;
        //diagonal down-left
        for(int i=1;x+i<board[0].length&&y-i>=0&&flag;i++){
            if(board[x+i][y-i]==0)
                flag=false;
            if(board[x+i][y-i]==player){
                flag=false;
                for(int j=i;j>0;j--)
                    board[x+j][y-j]=player;
            }
        }
        flag=true;
        //diagonal up-right
        for(int i=1;x-i>=0&&y+i<board.length&&flag;i++){
            if(board[x-i][y+i]==0)
                flag=false;
            if(board[x-i][y+i]==player){
                flag=false;
                for(int j=i;j>0;j--)
                    board[x-j][y+j]=player;
            }
        }
        flag=true;
        //diagonal left-up
        for(int i=1;x-i>=0&&y-i>=0&&flag;i++){
            if(board[x-i][y-i]==0)
                flag=false;
            if(board[x-i][y-i]==player){
                flag=false;
                for(int j=i;j>0;j--)
                    board[x-j][y-j]=player;
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