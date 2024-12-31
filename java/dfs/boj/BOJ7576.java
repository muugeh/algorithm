package dfs.boj;

// [토마토] https://www.acmicpc.net/problem/7576

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ7576 {

  private static boolean[][] visited;
  private static int[][] map;
  private static int n, m;
  private static final int[] dy = {-1, 0, 1, 0};
  private static final int[] dx = {0, -1, 0, 1};

  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    m = Integer.parseInt(st.nextToken());
    n = Integer.parseInt(st.nextToken());
    map = new int[n][m];
    visited = new boolean[n][m];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    bw.write(String.valueOf(search()));
    bw.flush();
    br.close();
    bw.close();
  }

  private static int search() {
    Queue<Tomato> queue = new ArrayDeque<>();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (map[i][j] == 1) {
          visited[i][j] = true;
          queue.add(new Tomato(i, j, 0));
        }
      }
    }
    int days = bfs(queue);

    boolean allClear = true;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (map[i][j] == 0) {
          allClear = false;
          break;
        }
      }
    }
    if (allClear) return days;
    return -1;
  }

  private static int bfs(Queue<Tomato> queue) {
    int maxDays = 0;
    while (!queue.isEmpty()) {
      Tomato tomato = queue.poll();
      for (int i = 0; i < 4; i++) {
        int ny = dy[i] + tomato.y;
        int nx = dx[i] + tomato.x;
        int days = tomato.days;
        maxDays = Math.max(days, maxDays);
        if (ny >= 0 && ny < n && nx >= 0 && nx < m) {
          if (!visited[ny][nx] && map[ny][nx] == 0) {
            visited[ny][nx] = true;
            map[ny][nx] = 1;
            queue.offer(new Tomato(ny, nx, tomato.days + 1));
          }
        }
      }
    }
    return maxDays;
  }

  private static class Tomato {
    int y, x;
    int days;

    public Tomato(int y, int x, int days) {
      this.y = y;
      this.x = x;
      this.days = days;
    }
  }
}
