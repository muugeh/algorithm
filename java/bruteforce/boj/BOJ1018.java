package bruteforce.boj;

// [체스판 다시 칠하기] https://www.acmicpc.net/problem/1018

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1018 {

  private static char[][] board;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    board = new char[n][m];
    for (int i = 0; i < n; i++) {
      String line = br.readLine();
      for (int j = 0; j < m; j++) {
        board[i][j] = line.charAt(j);
      }
    }

    int min = 32;

    for (int i = 0; i <= n - 8; i++) {
      for (int j = 0; j <= m - 8; j++) {
        min = Math.min(min, Math.min(cover(i, j, 'B'), cover(i, j, 'W')));
      }
    }
    bw.write(String.valueOf(min));
    bw.flush();
    bw.close();
    br.close();
  }

  private static int cover(int r, int c, char startBlock) {
    int count = 0;
    for (int i = r; i < r + 8; i++)
      for (int j = c; j < c + 8; j++) {
        if (i % 2 == j % 2) {
          if (board[i][j] != startBlock) count++;
        } else {
          if (board[i][j] == startBlock) count++;
        }
      }
    return count;
  }
}
