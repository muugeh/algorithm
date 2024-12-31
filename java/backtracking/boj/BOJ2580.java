package backtracking.boj;

// [스도쿠] https://www.acmicpc.net/problem/2580

import java.io.*;
import java.util.StringTokenizer;

public class BOJ2580 {

  private static final StringBuilder sb = new StringBuilder();
  private static int[][] board = new int[9][9];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    board = new int[9][9];
    for (int i = 0; i < 9; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < 9; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    sudoku(0, 0);
    br.close();
  }

  private static void sudoku(int r, int c) {
    if (c == 9) {
      sudoku(r + 1, 0);
      return;
    }

    if (r == 9) {
      for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9; j++) {
          sb.append(board[i][j]).append(' ');
        }
        if (i != 8)
          sb.append('\n');
      }
      System.out.println(sb);
      System.exit(0);
    }

    if (board[r][c] == 0) {
      for (int k = 1; k <= 9; k++) {
        if (possible(r, c, k)) {
          board[r][c] = k;
          sudoku(r, c + 1);
        }
        board[r][c] = 0;
      }
      return;
    }
    sudoku(r, c + 1);
  }

  private static boolean possible(int r, int c, int value) {
    if (!rowPossible(r, c, value))
      return false;

    if (!colPossible(r, c, value))
      return false;

    return partPossible(r, c, value);
  }

  private static boolean rowPossible(int r, int c, int value) {
    for (int i = 0; i < 9; i++) {
      if (i == r) continue;
      if (value == board[i][c])
        return false;
    }
    return true;
  }

  private static boolean colPossible(int r, int c, int value) {
    for (int j = 0; j < 9; j++) {
      if (j == c) continue;
      if (value == board[r][j])
        return false;
    }
    return true;
  }

  private static boolean partPossible(int r, int c, int value) {
    int dy = (r / 3) * 3;
    int dx = (c / 3) * 3;
    for (int i = dy; i < dy + 3; i++) {
      for (int j = dx; j < dx + 3; j++) {
        if (i == r && j == c) continue;
        if (value == board[i][j])
          return false;
      }
    }
    return true;
  }

}
