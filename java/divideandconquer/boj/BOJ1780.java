package divideandconquer.boj;

// [종이의 개수] https://www.acmicpc.net/problem/1780

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ1780 {

  private static int[][] paper;
  private static int plus = 0;
  private static int zero = 0;
  private static int minus = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    paper = new int[n][n];
    for (int i = 0; i < n; i++) {
      paper[i] = Arrays.stream(br.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
    }
    tripleTree(0, 0, n);
    System.out.println(minus + "\n" + zero + "\n" + plus);
  }

  private static void tripleTree(int y, int x, int size) {
    if (!allSameColor(y, x, size)) {
      tripleTree(y, x, size / 3);
      tripleTree(y, x + size / 3, size / 3);
      tripleTree(y, x + size * 2 / 3, size / 3);

      tripleTree(y + size / 3, x, size / 3);
      tripleTree(y + size / 3, x + size / 3, size / 3);
      tripleTree(y + size / 3, x + size * 2 / 3, size / 3);

      tripleTree(y + size * 2 / 3, x, size / 3);
      tripleTree(y + size * 2 / 3, x + size / 3, size / 3);
      tripleTree(y + size * 2 / 3, x + size * 2 / 3, size / 3);
    }
  }

  private static boolean allSameColor(int y, int x, int size) {
    int color = paper[y][x];
    for (int i = y; i < y + size; i++)
      for (int j = x; j < x + size; j++) if (paper[i][j] != color) return false;
    if (color == -1) minus++;
    else if (color == 1) plus++;
    else zero++;
    return true;
  }
}
