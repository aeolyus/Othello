/**
 * Class to test the Othello game program
 */
public class UnitTest{
     public static void main(String args[]){
          OthelloGame og=new OthelloGame();
          //test horizontal right
          og.board.place(4,5,1);
          og.board.printBoard();
          
          //test horizontal left
          og.board.place(3,2,1);
          og.board.printBoard();
          
          //test vertical up
          og.board.place(5,3,2);
          og.board.printBoard();
          og.board.place(2,3,2);
          og.board.printBoard();
          
          //test vertical down
          og.board.place(2,4,2);
          og.board.printBoard();
          og.board.place(5,4,2);
          og.board.printBoard();
          
          //test diagonal left up
          og.board.place(1,0,1);
          og.board.printBoard();
          
          //test diagonal left down
          og.board.place(5,0,1);
          og.board.printBoard();
          
          //test diagonal right up
          og.board.place(7,0,2);
          og.board.printBoard();
          
          //test diagonal right down
          og.board.place(7,7,2);
          og.board.printBoard();
     }
}