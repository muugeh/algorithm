package dp.boj;

// [내리막 길] https://www.acmicpc.net/problem/1520

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1520 {
  static int M, N;
  static int[][] map, path;
  static int[] rangeX = { -1, 0, 1, 0 };
  static int[] rangeY = { 0, 1, 0, -1 };

  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());

    M = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());

    map = new int[M + 1][N + 1];
    for (int i = 1; i <= M; i++) {
      st = new StringTokenizer(br.readLine());

      for (int j = 1; j <= N; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    path = new int[M + 1][N + 1];
    for (int i = 1; i <= M; i++) {
      for (int j = 1; j <= N; j++) {
        path[i][j] = -1;
      }
    }

    bw.write(findPath(1, 1) + "\n");
    bw.flush();
    bw.close();
    br.close();
  }

  public static int findPath(int x, int y) {
    if (x == M && y == N) {
      return 1;
    }

    if (path[x][y] != -1) {
      return path[x][y];
    }

    path[x][y] = 0;
    for (int i = 0; i < 4; i++) {
      int dx = x + rangeX[i];
      int dy = y + rangeY[i];

      if (dx < 1 || dy < 1 || dx > M || dy > N) {
        continue;
      }

      if (map[x][y] > map[dx][dy]) {
        path[x][y] += findPath(dx, dy);
      }
    }

    return path[x][y];
  }

}
