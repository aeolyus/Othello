public class extends Board{
    public OthelloBoard(){
        super(8,8);//0- blank, 1- player 1, 2- player 2
        board[3][3]=board[4][4]=1;
        board[3][4]=board[4][3]=2;
    }
    public void place(int x, int y, int player){
        //TODO: places a player piece
            capture(x,y,player);
    }
    /**
     * Captures the pieces that are in adjacent to it linear-ly
     */
    public void capture(int x,int y,int player){
        flag=true; //true until first piece is found
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
    public int calculateScore1(){
        score1=0;
        for(int i=0;i<8;i++)
            for(int j=0;j<8;j++)
                if(board[i][j]==1)
                    score1++;
    }
    /**
     * Calculates the score for player 2
     */
    public int calculateScore2(){
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
                    System.out.print("X");
                else if(board[i][j]==2)
                    System.out.print("O");
                else
                    System.out.print("~");
            }
            System.out.println();
        }
     }
}