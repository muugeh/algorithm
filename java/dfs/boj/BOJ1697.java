package dfs.boj;

// [숨바꼭질] https://www.acmicpc.net/problem/1697

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1697 {

  private static int n, k;

  private static final int MAX = 100000;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    bw.write(String.valueOf(bfs(n)));
    bw.flush();
    bw.close();
    br.close();
  }

  private static int bfs(int start) {
    Queue<Location> queue = new ArrayDeque<>();
    boolean[] visited = new boolean[MAX + 1];
    queue.add(new Location(start, 0));
    while (!queue.isEmpty()) {
      Location x = queue.poll();
      if (x.location == k) return x.time;

      int before = x.location - 1;
      if (before >= 0 && !visited[before]) {
        visited[before] = true;
        queue.offer(new Location(before, x.time + 1));
      }
      int next = x.location + 1;
      if (next <= MAX && !visited[next]) {
        visited[next] = true;
        queue.offer(new Location(next, x.time + 1));
      }
      int teleport = x.location * 2;
      if (teleport <= MAX && !visited[teleport]) {
        visited[teleport] = true;
        queue.offer(new Location(teleport, x.time + 1));
      }
    }

    return -1;
  }

  public static class Location {
    int time;
    int location;

    public Location(int location, int time) {
      this.location = location;
      this.time = time;
    }
  }
}
