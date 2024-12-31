package graph.boj;

// [타임머신] https://www.acmicpc.net/problem/11657

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11657 {

  private static final int INF = 100000 * 500 + 1;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    long[] dist = new long[n + 1];
    Arrays.fill(dist, INF);
    Edge[] e = new Edge[m];

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      e[i] = new Edge(a, b, c);
    }

    dist[1] = 0;
    for (int i = 0; i < n - 1; i++) {
      for (int j = 0; j < m; j++) {
        if (dist[e[j].u] == INF) continue;
        if (dist[e[j].v] > (dist[e[j].u] + e[j].val)) {
          dist[e[j].v] = dist[e[j].u] + e[j].val;
        }
      }
    }

    boolean isCycle = false;
    for (int i = 0; i < m; i++) {
      if (dist[e[i].u] != INF && dist[e[i].v] > dist[e[i].u] + e[i].val) {
        isCycle = true;
        break;
      }
    }

    if (isCycle) System.out.println(-1);
    else {
      for (int i = 2; i <= n; i++) {
        System.out.println(dist[i] == INF ? -1 : dist[i]);
      }
    }
  }

  public static class Edge {
    int u;
    int v;
    int val;

    public Edge(int u, int v, int val) {
      this.u = u;
      this.v = v;
      this.val = val;
    }
  }
}
