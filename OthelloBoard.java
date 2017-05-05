public class extends Board{
    public OthelloBoard(){
        super(8,8);//0- blank, 1- player 1, 2- player 2
        board[3][3]=board[4][4]=1;
        board[3][4]=board[4][3]=2;
    }
    public void place(int x, int y, int player){
        //places a player piece
        capture();
    }
    /**
     * Captures the pieces that are in adjacent to it linear-ly
     */
    public void capture(){
        
    }
}