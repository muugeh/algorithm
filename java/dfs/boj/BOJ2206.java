package dfs.boj;

// [벽 부수고 이동하기] https://www.acmicpc.net/problem/2206

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2206 {

  private static int n, m;
  private static boolean[][] map;

  private static final int[] dy = {-1, 0, 1, 0};
  private static final int[] dx = {0, -1, 0, 1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    map = new boolean[n + 1][m + 1];
    for (int i = 1; i <= n; i++) {
      String line = br.readLine();
      for (int j = 1; j <= m; j++) {
        map[i][j] = line.charAt(j - 1) == '0';
      }
    }
    bw.write(String.valueOf(bfs()));
    bw.flush();
    bw.close();
    br.close();
  }

  private static int bfs() {
    Queue<State> queue = new ArrayDeque<>();
    boolean[][][] visited = new boolean[n + 1][m + 1][2];
    queue.add(new State(1, 1, 1, false));
    visited[1][1][0] = true;
    while (!queue.isEmpty()) {
      State state = queue.poll();
      int y = state.y;
      int x = state.x;
      int distance = state.distance;
      boolean broken = state.broken;
      if (y == n && x == m) return state.distance;
      for (int i = 0; i < 4; i++) {
        int ny = y + dy[i];
        int nx = x + dx[i];
        if (ny > 0 && ny <= n && nx > 0 && nx <= m) {
          int wall = broken ? 1 : 0;
          if (!visited[ny][nx][wall]) {
            if (map[ny][nx]) {
              queue.add(new State(ny, nx, distance + 1, broken));
            } else if (!broken) {
              queue.add(new State(ny, nx, distance + 1, true));
            }
            visited[ny][nx][wall] = true;
          }
        }
      }
    }
    return -1;
  }

  public static class State {
    int y, x, distance;
    boolean broken;

    public State(int y, int x, int distance, boolean broken) {
      this.y = y;
      this.x = x;
      this.distance = distance;
      this.broken = broken;
    }
  }
}
