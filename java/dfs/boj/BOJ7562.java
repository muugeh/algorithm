package dfs.boj;

// [나이트의 이동] https://www.acmicpc.net/problem/7562

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ7562 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();
    int t = Integer.parseInt(br.readLine());
    while (t-- > 0) {
      int i = Integer.parseInt(br.readLine());
      StringTokenizer st = new StringTokenizer(br.readLine());
      int y = Integer.parseInt(st.nextToken());
      int x = Integer.parseInt(st.nextToken());

      st = new StringTokenizer(br.readLine());
      int ey = Integer.parseInt(st.nextToken());
      int ex = Integer.parseInt(st.nextToken());

      sb.append(bfs(i, y, x, ey, ex)).append("\n");
    }
    bw.write(sb.toString());
    bw.flush();
    bw.close();
    br.close();
  }

  private static final int[] dy = {-2, -2, -1, -1, 1, 1, 2, 2};
  private static final int[] dx = {-1, 1, -2, 2, -2, 2, -1, 1};

  private static int bfs(int n, int startY, int startX, int endY, int endX) {
    Queue<Point> moves = new ArrayDeque<>();
    boolean[][] visited = new boolean[n][n];
    moves.add(new Point(startY, startX, 0));
    visited[startY][startX] = true;
    while (!moves.isEmpty()) {
      Point point = moves.poll();
      int y = point.y;
      int x = point.x;
      int count = point.count;
      if (y == endY && x == endX) return count;
      for (int i = 0; i < 8; i++) {
        int ny = y + dy[i];
        int nx = x + dx[i];
        if (ny >= 0 && ny < n && nx >= 0 && nx < n) {
          if (!visited[ny][nx]) {
            visited[ny][nx] = true;
            moves.offer(new Point(ny, nx, count + 1));
          }
        }
      }
    }
    return -1;
  }

  private static class Point {
    int y, x, count;

    public Point(int y, int x, int count) {
      this.y = y;
      this.x = x;
      this.count = count;
    }
  }
}
