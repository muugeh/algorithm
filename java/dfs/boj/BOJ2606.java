package dfs.boj;

// [바이러스] https://www.acmicpc.net/problem/2606

import java.io.*;
import java.util.StringTokenizer;

public class BOJ2606 {

  private static boolean[] visited;
  private static boolean[][] connected;
  private static int computers;

  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    computers = Integer.parseInt(br.readLine());
    connected = new boolean[computers + 1][computers + 1];
    visited = new boolean[computers + 1];
    int n = Integer.parseInt(br.readLine());
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int from = Integer.parseInt(st.nextToken());
      int to = Integer.parseInt(st.nextToken());
      connected[from][to] = true;
      connected[to][from] = true;
    }
    bw.write(String.valueOf(dfs(1)));
    bw.flush();
    br.close();
    bw.close();
  }

  private static int dfs(int start) {
    visited[start] = true;
    int count = 0;
    for (int i = 1; i <= computers; i++)
      if (!visited[i] && connected[start][i]) count += dfs(i) + 1;
    return count;
  }
}
