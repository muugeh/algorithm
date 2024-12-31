package dfs.boj;

// [토마토] https://www.acmicpc.net/problem/7569

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ7569 {

  private static boolean[][][] visited;
  private static int[][][] map;
  private static int n, m, h;
  private static final int[] dz = {0, 0, 0, 0, -1, 1};
  private static final int[] dy = {-1, 0, 1, 0, 0, 0};
  private static final int[] dx = {0, -1, 0, 1, 0, 0};

  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    m = Integer.parseInt(st.nextToken());
    n = Integer.parseInt(st.nextToken());
    h = Integer.parseInt(st.nextToken());
    map = new int[h][n][m];
    visited = new boolean[h][n][m];
    for (int i = 0; i < h; i++) {
      for (int j = 0; j < n; j++) {
        st = new StringTokenizer(br.readLine());
        for (int k = 0; k < m; k++) {
          map[i][j][k] = Integer.parseInt(st.nextToken());
        }
      }
    }
    bw.write(String.valueOf(search()));
    bw.flush();
    br.close();
    bw.close();
  }

  private static int search() {
    Queue<Tomato> queue = new ArrayDeque<>();
    for (int i = 0; i < h; i++) {
      for (int j = 0; j < n; j++) {
        for (int k = 0; k < m; k++) {
          if (map[i][j][k] == 1) {
            visited[i][j][k] = true;
            queue.add(new Tomato(i, j, k, 0));
          }
        }
      }
    }
    int days = bfs(queue);

    boolean allClear = true;
    for (int i = 0; i < h; i++) {
      for (int j = 0; j < n; j++) {
        for (int k = 0; k < m; k++) {
          if (map[i][j][k] == 0) {
            allClear = false;
            break;
          }
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
      for (int i = 0; i < 6; i++) {
        int nz = dz[i] + tomato.z;
        int ny = dy[i] + tomato.y;
        int nx = dx[i] + tomato.x;
        int days = tomato.days;
        maxDays = Math.max(days, maxDays);
        if (nz >= 0 && nz < h && ny >= 0 && ny < n && nx >= 0 && nx < m) {
          if (!visited[nz][ny][nx] && map[nz][ny][nx] == 0) {
            visited[nz][ny][nx] = true;
            map[nz][ny][nx] = 1;
            queue.offer(new Tomato(nz, ny, nx, tomato.days + 1));
          }
        }
      }
    }
    return maxDays;
  }

  private static class Tomato {
    int y, x, z;
    int days;

    public Tomato(int z, int y, int x, int days) {
      this.z = z;
      this.y = y;
      this.x = x;
      this.days = days;
    }
  }
}
