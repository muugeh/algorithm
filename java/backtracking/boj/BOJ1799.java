package backtracking.boj;

// [비숍] https://www.acmicpc.net/problem/1799

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1799 {

  private static int[][] board;
  private static final boolean[] l = new boolean[20];
  private static final boolean[] r = new boolean[20];
  private static int n;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    board = new int[n][n];
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    System.out.println(solve(0, 0) + solve(0, 1));
    br.close();
  }

  private static int solve(int row, int col) {
    if (col >= n) {
      row++;
      if (col % 2 == 0) col = 1;
      else col = 0;
    }
    if (row >= n) return 0;

    int answer = 0;
    if (board[row][col] == 1 && !l[col - row + n - 1] && !r[row + col]) {
      l[col - row + n - 1] = r[row + col] = true;
      answer = solve(row, col + 2) + 1;
      l[col - row + n - 1] = r[row + col] = false;
    }
    answer = Math.max(answer, solve(row, col + 2));

    return answer;
  }
}
