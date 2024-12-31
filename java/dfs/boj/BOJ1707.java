package dfs.boj;

// [이분 그래프] https://www.acmicpc.net/problem/1707

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1707 {

  private static List<List<Integer>> graph;
  private static boolean[] visited;
  private static int[] colors;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());
    while (t-- > 0) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int v = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());

      graph = new ArrayList<>(v);
      for (int i = 0; i <= v; i++) {
        graph.add(new ArrayList<>());
      }

      for (int i = 0; i < e; i++) {
        st = new StringTokenizer(br.readLine());
        int from = Integer.parseInt(st.nextToken());
        int to = Integer.parseInt(st.nextToken());
        graph.get(from).add(to);
        graph.get(to).add(from);
      }

      visited = new boolean[v + 1];
      colors = new int[v+1];
      boolean bipartite = true;
      for (int i = 1; i <= v; i++) {
        if (!visited[i]) {
          if (!bfs(i, 1)) bipartite = false;
        }
      }
      System.out.println(bipartite ? "YES" : "NO");
    }
  }

  private static boolean bfs(int start, int color) {
    Queue<Integer> vertexes = new ArrayDeque<>();
    if (!visited[start]) vertexes.add(start);
    visited[start] = true;
    colors[start] = color;
    while (!vertexes.isEmpty()) {
      int vertex = vertexes.poll();
      for (int connected : graph.get(vertex)) {
        if (!visited[connected]) {
          visited[connected] = true;
          graph.get(connected).remove((Integer) vertex);
          vertexes.offer(connected);
          colors[connected] = colors[vertex] * -1;
        } else if (colors[vertex] + colors[connected] != 0){
          return false;
        }
      }
    }
    return true;
  }
}
