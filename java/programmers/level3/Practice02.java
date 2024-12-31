package programmers.level3;

// [섬 연결하기] https://programmers.co.kr/learn/courses/30/lessons/42861

import java.util.*;

public class Practice02 {

  private static int[][] graph;

  public static void main(String[] args) {
    int n = 4;
    int[][] costs = {{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}};
    System.out.println(solution(n, costs)); // 4
  }

  public static int solution(int n, int[][] costs) {
    graph = new int[n][n];
    for (int[] row : graph) Arrays.fill(row, Integer.MAX_VALUE);

    for (int[] cost : costs) {
      int from = cost[0];
      int to = cost[1];
      int distance = cost[2];
      graph[from][to] = distance;
      graph[to][from] = distance;
    }

    return prim(n);
  }

  private static int prim(int n) {
    int ret = 0;
    boolean[] added = new boolean[n];
    int[] minWeight = new int[n];
    Arrays.fill(minWeight, Integer.MAX_VALUE);
    minWeight[0] = 0;
    for (int iter = 0; iter < n; iter++) {
      int u = -1;
      for (int v = 0; v < n; ++v) {
        if (!added[v] && (u == -1 || minWeight[u] > minWeight[v])) u = v;
      }
      ret += minWeight[u];
      added[u] = true;
      for (int i = 0; i < graph[u].length; i++) {
        if (graph[u][i] != Integer.MAX_VALUE) {
          if (!added[i] && minWeight[i] > graph[u][i]) {
            minWeight[i] = graph[u][i];
          }
        }
      }
    }
    return ret;
  }
}
