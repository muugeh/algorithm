package divideandconquer.boj;

// [쿼드트리] https://www.acmicpc.net/problem/1992

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ1992 {

  private static int[][] picture;
  private static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    picture = new int[n][n];
    for (int i = 0; i < n; i++) {
      picture[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
    }
    quadTree(0, 0, n);
    System.out.println(sb);
  }

  private static void quadTree(int y, int x, int size) {
    if (allSameColor(y, x, size)) {
      sb.append(picture[y][x]);
    } else {
      sb.append("(");
      quadTree(y, x, size / 2);
      quadTree(y, x + size / 2, size / 2);
      quadTree(y + size / 2, x, size / 2);
      quadTree(y + size / 2, x + size / 2, size / 2);
      sb.append(")");
    }
  }

  private static boolean allSameColor(int y, int x, int size) {
    int color = picture[y][x];
    for (int i = y; i < y + size; i++)
      for (int j = x; j < x + size; j++) if (picture[i][j] != color) return false;
    return true;
  }
}
