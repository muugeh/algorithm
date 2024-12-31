package strategies.chap8;

import java.util.Arrays;
import java.util.Scanner;
import util.Input;

public class TrianglePath {

  static int n;
  static int[][] triangle;
  static int[][] cache;

  public static void main(String[] args) throws Exception {
    Scanner sc = Input.sc(new TrianglePath());
    int C = sc.nextInt();
    while (C-- > 0) {
      n = sc.nextInt();
      triangle = new int[n][];
      cache = new int[n][];
      for (int i = 0; i < n; i++) {
        triangle[i] = new int[i + 1];
        cache[i] = new int[i + 1];
        Arrays.fill(cache[i], -1);
        for (int j = 0; j <= i; j++) {
          triangle[i][j] = sc.nextInt();
        }
      }
      System.out.println(path(0, 0));
    }
  }

  private static int path(int y, int x) {
    if (y == n - 1) {
      return triangle[y][x];
    }

    if (cache[y][x] != -1) {
      return cache[y][x];
    }

    int max = Math.max(path(y + 1, x), path(y + 1, x + 1));
    return cache[y][x] = max + triangle[y][x];
  }

}
