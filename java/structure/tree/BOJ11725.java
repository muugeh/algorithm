package structure.tree;

// [트리의 부모 찾기] https://www.acmicpc.net/problem/11725

import java.io.*;
import java.util.*;

public class BOJ11725 {

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();
    int n = Integer.parseInt(bufferedReader.readLine());
    int[] parent = new int[n + 1];
    Arrays.fill(parent, -1);
    parent[1] = 1;
    List<List<Integer>> children = new ArrayList<>();
    for (int i = 0; i <= n; i++)
      children.add(new ArrayList<>());
    for (int i = 0; i < n - 1; i++) {
      StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
      int node1 = Integer.parseInt(stringTokenizer.nextToken());
      int node2 = Integer.parseInt(stringTokenizer.nextToken());
      children.get(node1).add(node2);
      children.get(node2).add(node1);
    }
    Queue<Integer> queue = new ArrayDeque<>();
    queue.offer(1);
    while (!queue.isEmpty()) {
      int node = queue.poll();
      for (int child : children.get(node)) {
        if (parent[child] == -1) {
          parent[child] = node;
          queue.offer(child);
        }
      }
    }
    for (int i = 2; i <= n; i++) {
      sb.append(parent[i]).append("\n");
    }
    bufferedWriter.write(sb.toString());
    bufferedWriter.flush();
    bufferedWriter.close();
    bufferedReader.close();
  }

}