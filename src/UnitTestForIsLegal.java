/**
 * Class to test the Othello game program
 */
public class UnitTestForIsLegal{
     public static void main(String args[]){
          OthelloGame og=new OthelloGame();
          //test if space is empty
          og.board.printBoard();
          if(!og.board.isLegal(4,4,1))
               System.out.println("Not Legal.");
          else{
               System.out.println("Legal.");
               og.board.place(4,4,1);
          }
          og.board.printBoard();
          
          //test if piece is placed inside board
          if(!og.board.isLegal(8,8,1))
               System.out.println("Not Legal.");
          else{
               System.out.println("Legal.");
               og.board.place(8,8,1);
          }
          og.board.printBoard();
          
          //test if piece is next to opposite piece but can't capture
          if(!og.board.isLegal(4,2,1))
               System.out.println("Not Legal.");
          else{
               System.out.println("Legal.");
               og.board.place(4,2,1);
          }
          og.board.printBoard();
          //tests if piece is next to opposite piece and can capture
          if(!og.board.isLegal(4,5,1))
               System.out.println("Not Legal.");
          else{
               System.out.println("Legal.");
               og.board.place(4,5,1);
          }
          og.board.printBoard();
          //test if piece has multiple directions to capture
          og.board.place(3,5,2);
          og.board.printBoard();
          if(!og.board.isLegal(2,3,1))
               System.out.println("Not Legal.");
          else{
               System.out.println("Legal.");
               og.board.place(2,3,1);
          }
          og.board.printBoard();
     }
}