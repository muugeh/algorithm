package divideandconquer.boj;

// [색종이 만들기] https://www.acmicpc.net/problem/2630

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2630 {

  private static int[][] paper;
  static int blue = 0;
  static int white = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    paper = new int[n][n];
    for (int i = 0; i < n; i++) {
      paper[i] = Arrays.stream(br.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
    }
    count(0, 0, n);
    System.out.println(white + "\n" + blue);
  }

  private static void count(int y, int x, int size) {
    if (!allSameColor(y, x, size)) {
      count(y, x, size / 2);
      count(y + size / 2, x, size / 2);
      count(y, x + size / 2, size / 2);
      count(y + size / 2, x + size / 2, size / 2);
    }
  }

  private static boolean allSameColor(int y, int x, int size) {
    int color = paper[y][x];
    for (int i = y; i < y + size; i++)
      for (int j = x; j < x + size; j++) if (paper[i][j] != color) return false;

    if (color == 1) blue++;
    else white++;
    return true;
  }
}
