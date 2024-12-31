package strategies.chap9;

import java.util.Arrays;
import java.util.Scanner;
import util.Input;

public class NumberGame {

  public static void main(String[] args) {
    Scanner sc = Input.sc(new NumberGame());

    int C = sc.nextInt();
    while (C-- > 0) {
      n = sc.nextInt();
      board = new int[n];

      for (int i = 0; i < n; i++) {
        board[i] = sc.nextInt();
      }

      cache = new int[50][50];
      for (int[] ints : cache) {
        Arrays.fill(ints, EMPTY);
      }

      System.out.println(play(0, n - 1));

    }
  }

  static final int EMPTY = -987654321;
  static int n;
  static int[] board;
  static int[][] cache;

  private static int play(int left, int right) {
    if (left > right) {
      return 0;
    }

    if (cache[left][right] != EMPTY) {
      return cache[left][right];
    }

    int ol = board[left] - play(left + 1, right);
    int or = board[right] - play(left, right - 1);
    cache[left][right] = Math.max(ol, or);

    if (right - left + 1 >= 2) {
      cache[left][right] = Math.max(cache[left][right], -play(left + 2, right));
      cache[left][right] = Math.max(cache[left][right], -play(left, right - 2));
    }

    return cache[left][right];
  }

}
