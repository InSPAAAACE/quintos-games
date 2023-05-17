package java.TicTacToe;

import static java.QuintOS.*;

public class TicTacToe {

  String title = """
      TTTTT IIIII   CCC
        T     I    C
        T     I    C
        T     I    C
        T   IIIII   CCC

      TTTTT  AAA    CCC
        T   A   A  C
        T   AAAAA  C
        T   A   A  C
        T   A   A   CCC

      TTTTT  OOO   EEEE
        T   O   O  E
        T   O   O  EEE
        T   O   O  E
        T    OOO   EEEE""";

  String bigO = " OOOOOO \n" +
      "OO    OO\n" +
      "OO    OO\n" +
      "OO    OO\n" +
      "OO    OO\n" +
      "OO    OO\n" +
      " OOOOOO ";

  String bigX = "XX    XX\n" +
      " XX  XX \n" +
      "  XXXX  \n" +
      "   XX   \n" +
      "  XXXX  \n" +
      " XX  XX \n" +
      "XX    XX";

  String bigSpace = "        \n".repeat(7);

  int gridRow = 3;
  int gridCol = 26;
  int turn = 0;

  char[][] board = new char[][] {
      new char[] { ' ', ' ', ' ' },
      new char[] { ' ', ' ', ' ' },
      new char[] { ' ', ' ', ' ' }
  };

  public boolean checkWinner(char mark) {
    for (int rw = 0; rw < 3; rw++) {
      if (board[rw][0] == mark && board[rw][1] == mark && board[rw][2] == mark) {
        return true;
      }
    }
    for (int cl = 0; cl < 3; cl++) {
      if (board[0][cl] == mark && board[1][cl] == mark && board[2][cl] == mark) {
        return true;
      }
    }
    if (board[0][0] == mark && board[1][1] == mark && board[2][2] == mark) {
      return true;
    }
    if (board[0][2] == mark && board[1][1] == mark && board[2][0] == mark) {
      return true;
    }

    return false;
  }

  public boolean checkDraw() {

    for (int r = 0; r < 3; r++) {
      for (int c = 0; c < 3; c++) {
        if (board[r][c] == ' ') {
          return false;
        }
      }
    }
    return true;
  }

  public void takeTurn(int r, int c) {
    if (board[r][c] == ' ') {

      char m = ' ';
      if (turn % 2 == 0) {
        txt(bigX, gridRow + r * 8, gridCol + c * 9);
        board[r][c] = 'x';
        m = 'x';
      } else {
        txt(bigO, gridRow + r * 8, gridCol + c * 9);
        board[r][c] = 'o';
        m = 'o';
      }

      if (checkWinner(m)) {
        alert("Player " + m + " won!", 12, 58, 19);
        return;
      }
      if (checkDraw()) {

      }

      turn++;
    }
  }

  public void startGame() {
    txt(title, 5, 3);
    /* Part A: finish the grid of 9x8 spaces */
    txt("─".repeat(26), gridRow + 7, gridCol);
    txt("─".repeat(26), gridRow + 15, gridCol); // draw another horizontal line

    txt("│\n".repeat(23), gridRow, gridCol + 8);
    txt("│\n".repeat(23), gridRow, gridCol + 17); // draw another vertical line

    for (int r = 0; r < 3; r++) {
      for (int c = 0; c < 3; c++) {
        final int row = r;
        final int col = c;
        button(bigSpace, gridRow + r * 8, gridCol + c * 9, () -> {
          takeTurn(row, col);
        });
      }
    }
  }

  public TicTacToe() {
    startGame();
  }

  public static void main(String[] args) {
    new TicTacToe();
  }

}
