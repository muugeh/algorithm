package dfs.boj;

// [DFS와 BFS] https://www.acmicpc.net/problem/1260

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1260 {

  static class Pair {
    int start;
    int end;

    public Pair(int start, int end) {
      this.start = start;
      this.end = end;
    }
  }

  public static List<Pair> adjacent = new ArrayList<>();
  public static List<List<Boolean>> graph = new ArrayList<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int v = Integer.parseInt(st.nextToken());

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      adjacent.add(new Pair(a, b));
    }

    init(n);
    dfs(n, v);
    System.out.println();
    bfs(n, v);
  }

  private static List<Boolean> visited;

  private static void init(int n) {
    visited = new ArrayList<>(n + 1);
    for (int i = 0; i < n + 1; i++)
      visited.add(false);
    makeGraph(n);
  }

  private static void dfs(int n, int here) {
    visited.set(here, true);
    System.out.print(here + " ");

    for (int there = 1; there <= n; there++) {
      if (graph.get(here).get(there) && !visited.get(there)) {
        graph.get(here).set(there, false);
        graph.get(there).set(here, false);
        dfs(n, there);
      }
    }
  }

  private static void bfs(int n, int here) {
    init(n);
    Queue<Integer> queue = new ArrayDeque<>();
    queue.offer(here);
    visited.set(here, true);

    while (!queue.isEmpty()) {
      int tmp = queue.poll();
      System.out.print(tmp + " ");
      for (int there = 1; there <= n; there++) {
        if (!visited.get(there) && graph.get(tmp).get(there)) {
          visited.set(there, true);
          graph.get(here).set(there, false);
          graph.get(there).set(here, false);
          queue.offer(there);
        }
      }
    }
  }

  private static void makeGraph(int n) {
    graph.clear();
    for (int i = 0; i < n + 1; i++) {
      graph.add(new ArrayList<>());
      for (int j = 0; j < n + 1; j++)
        graph.get(i).add(false);
    }
    for (Pair pair : adjacent) {
      graph.get(pair.start).set(pair.end, true);
      graph.get(pair.end).set(pair.start, true);
    }
  }
}
