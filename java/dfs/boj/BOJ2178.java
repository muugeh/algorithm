package dfs.boj;

// [미로 탐색] https://www.acmicpc.net/problem/2178

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2178 {

  private static boolean[][] visited;
  private static char[][] map;
  private static int n, m;
  private static final int[] dy = {-1, 0, 1, 0};
  private static final int[] dx = {0, -1, 0, 1};

  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    map = new char[n][];
    visited = new boolean[n][m];
    for (int i = 0; i < n; i++) {
      map[i] = br.readLine().toCharArray();
    }
    bw.write(String.valueOf(bfs(0, 0)));
    bw.flush();
    br.close();
    bw.close();
  }

  private static int bfs(int y, int x) {
    visited[y][x] = true;
    int[][] distance = new int[n][m];
    distance[0][0] = 1;
    Queue<Point> queue = new ArrayDeque<>();
    queue.add(new Point(y, x));
    while (!queue.isEmpty()) {
      Point point = queue.poll();
      for (int i = 0; i < 4; i++) {
        int ny = dy[i] + point.y;
        int nx = dx[i] + point.x;
        if (ny >= 0 && ny < n && nx >= 0 && nx < m) {
          if (!visited[ny][nx] && map[ny][nx] == '1') {
            visited[ny][nx] = true;
            distance[ny][nx] = distance[point.y][point.x] + 1;
            queue.offer(new Point(ny, nx));
          }
        }
      }
    }
    return distance[n - 1][m - 1];
  }

  private static class Point {
    int y, x;

    public Point(int y, int x) {
      this.y = y;
      this.x = x;
    }
  }
}
