package graph.boj;

// [특정한 최단 경로] https://www.acmicpc.net/problem/1504

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1504 {

  private static int n;
  private static int[][] graph;
  private static final int INF = 200000000;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    graph = new int[n + 1][n + 1];
    for (int[] row : graph) Arrays.fill(row, INF);
    int e = Integer.parseInt(st.nextToken());
    for (int i = 0; i < e; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      graph[a][b] = c;
      graph[b][a] = c;
    }
    st = new StringTokenizer(br.readLine());
    int v1 = Integer.parseInt(st.nextToken());
    int v2 = Integer.parseInt(st.nextToken());

    int path1 = dijkstra(1, v1) + dijkstra(v1, v2) + dijkstra(v2, n);
    int path2 = dijkstra(1, v2) + dijkstra(v2, v1) + dijkstra(v1, n);
    int path = Math.min(path1, path2);
    System.out.println(path >= INF ? -1 : path);
    br.close();
  }

  private static int dijkstra(int from, int to) {
    PriorityQueue<Node> queue = new PriorityQueue<>();
    int[] distances = new int[n + 1];
    Arrays.fill(distances, INF);
    distances[from] = 0;
    queue.add(new Node(from, 0));
    while (!queue.isEmpty()) {
      Node node = queue.poll();
      if (distances[node.to] < node.weight) continue;
      for (int i = 1; i <= n; i++) {
        if (distances[i] > node.weight + graph[node.to][i]) {
          distances[i] = node.weight + graph[node.to][i];
          queue.add(new Node(i, distances[i]));
        }
      }
    }
    return distances[to];
  }

  private static class Node implements Comparable<Node> {
    int to, weight;

    public Node(int to, int weight) {
      this.to = to;
      this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
      return weight - o.weight;
    }
  }
}
