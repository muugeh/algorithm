package structure.tree;

// [트리의 지름] https://www.acmicpc.net/problem/1167

import java.io.*;
import java.util.*;

public class BOJ1167 {

  private static int maxNode = 0;
  private static int max = 0;
  private static List<List<Node>> tree;
  private static boolean[] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int v = Integer.parseInt(br.readLine());
    tree = new ArrayList<>(v + 1);
    for (int i = 0; i <= v; i++)
      tree.add(new ArrayList<>());
    for (int i = 1; i <= v; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int now = Integer.parseInt(st.nextToken());
      String word;
      while (!(word = st.nextToken()).equals("-1")) {
        int vertex = Integer.parseInt(word);
        int distance = Integer.parseInt(st.nextToken());
        tree.get(now).add(new Node(vertex, distance));
      }
    }
    visited = new boolean[v + 1];
    dfs(1, 0);
    visited = new boolean[v + 1];
    dfs(maxNode, 0);
    bw.write(String.valueOf(max));
    bw.flush();
    bw.close();
    br.close();
  }

  private static void dfs(int vertex, int value) {
    visited[vertex] = true;

    if (max < value) {
      max = value;
      maxNode = vertex;
    }

    for (Node node : tree.get(vertex)) {
      if (!visited[node.vertex]) {
        dfs(node.vertex, node.value + value);
      }
    }
  }

  static class Node {
    int vertex;
    int value;

    public Node(int vertex, int value) {
      this.vertex = vertex;
      this.value = value;
    }
  }

}
