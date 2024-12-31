package samsung.boj;

// [연구소] https://www.acmicpc.net/problem/14502

import java.io.*;
import java.util.StringTokenizer;

public class BOJ14502 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int[][] map = new int[n][m];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    int maxSafeArea = 0;
    int full = n * m;

    for (int i = 0; i < full; i++) {
      for (int j = i + 1; j < full; j++) {
        for (int k = j + 1; k < full; k++) {
          if (isPossible(map, i, j, k)) {
            set(map, i, j, k, 1);
            int[][] copy = copy(map);
            diffuse(copy);
            maxSafeArea = Math.max(maxSafeArea, getSafeArea(copy));
            set(map, i, j, k, -1);
          }
        }
      }
    }

    bw.write(String.valueOf(maxSafeArea));
    bw.flush();
    bw.close();
    br.close();
  }

  private static final int[] dy = {-1, 0, 1, 0};
  private static final int[] dx = {0, -1, 0, 1};

  private static int[][] copy(int[][] map) {
    int[][] copy = new int[map.length][map[0].length];
    for (int i = 0; i < map.length; i++)
      System.arraycopy(map[i], 0, copy[i], 0, map[i].length);
    return copy;
  }

  private static void set(int[][] map, int a, int b, int c, int delta) {
    int n = map[0].length;
    map[a / n][a % n] += delta;
    map[b / n][b % n] += delta;
    map[c / n][c % n] += delta;
  }

  private static boolean isPossible(int[][] map, int a, int b, int c) {
    int n = map[0].length;
    return (map[a / n][a % n] == 0) && (map[b / n][b % n] == 0) && (map[c / n][c % n] == 0);
  }

  private static void diffuse(int[][] map) {
    for (int i = 0; i < map.length; i++)
      for (int j = 0; j < map[i].length; j++) {
        if (map[i][j] == 2) {
          infect(map, i, j);
        }
      }
  }

  private static void infect(int[][] map, int y, int x) {
    int row = map.length;
    int col = map[0].length;
    for (int i = 0; i < 4; i++) {
      int ny = y + dy[i];
      int nx = x + dx[i];
      if (ny >= 0 && ny < row && nx >= 0 && nx < col) {
        if (map[ny][nx] == 0) {
          map[ny][nx] = 2;
          infect(map, ny, nx);
        }
      }
    }
  }

  private static int getSafeArea(int[][] map) {
    int area = 0;
    for (int[] line : map)
      for (int block : line)
        if (block == 0)
          area++;
    return area;
  }
}
