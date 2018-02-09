import java.awt.*;

/*
* Filler class, it fills he board with the given piece
*
*/

public class Filler{
  private int[][] board;
  private int[][] piece = new int[][]{{1,1},{1,1},{1,1}};

  public Filler(int row, int col){
    //set the size
    board = new int[row][col];

    for(int i = 0; i<board.length; i++){
      for(int j = 0; j<board[0].length; j++){
        //empty the board
        board[i][j] = 0;
      }
    }
  }


  public void solve(int row, int col){
    //count blank spaces
    int blank =0;
    int nextCol=col, nextRow=row;

    for(int i = 0; i<board.length; i++){
      for(int j = 0; j<board[0].length; j++){
        //empty the board
        if(board[i][j] == 0)blank++;
      }
    }
    //if filled then return true means it has been solved
    if(blank == 0)return;

    System.out.println(blank + " ");

    if(placePiece(row , col)){
      //calculate next free space

      while (board[nextRow][nextCol] != 0) {

          nextCol++;
          if (nextCol == board[0].length) {
              nextCol = 0;
              nextRow++;
              if (nextRow == board.length) {
                System.out.println("COMPLETED");
                  return;
              }
          }
      }

      solve(nextRow, nextCol);
    }
  }

  public boolean placePiece(int row, int col){

    //verify
    int collapse = 0;
    for(int i = row; i<piece.length ; i++){
      for(int j = col; j<piece[0].length; j++){
        //put the piece inside and verify
        try {
          if(board[i][j] !=0)collapse++;
        }catch (IllegalStateException e) {
          //the pice cannot be placed
          return false;
        }
      }
    }

    if(collapse == 0){
      //put the piece inside
      System.out.println(row + " " + col );

      for(int i = row; i<piece.length + row; i++){
        for(int j = col; j<piece[0].length + col; j++){
          board[i][j] = piece[0][0];
        }
      }

      //print the board each time a piece is put inside
      for(int i = 0; i<board.length; i++){
        for(int j = 0; j<board[0].length; j++){
          System.out.print(board[i][j] + " ");
        }
        System.out.println("");
      }

      return true;
    }else{
      return false;
    }
  }
}
