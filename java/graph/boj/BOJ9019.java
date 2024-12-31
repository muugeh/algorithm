package graph.boj;

// [DSLR] https://www.acmicpc.net/problem/9019

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ9019 {

  private static boolean[] visited;
  private static char[] path;
  private static final Queue<Integer> queue = new LinkedList<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());
    while (t-- > 0) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      System.out.println(dslr(a, b));
    }
  }

  private static String dslr(int input, int result) {
    path = new char[10000];
    int[] fromPath = new int[10000];
    visited = new boolean[10000];

    queue.clear();
    queue.offer(input);
    visited[input] = true;
    fromPath[input] = -1;

    while (!queue.isEmpty()) {
      int value = queue.poll();

      if (value == result) {
        StringBuilder sb = new StringBuilder();
        while (value != input) {
          sb.append(path[value]);
          value = fromPath[value];
        }
        return sb.reverse().toString();
      }

      if (!visited[dCommand(value)]) {
        makePath(dCommand(value), 'D');
        fromPath[dCommand(value)] = value;
      }
      if (!visited[sCommand(value)]) {
        makePath(sCommand(value), 'S');
        fromPath[sCommand(value)] = value;
      }
      if (!visited[lCommand(value)]) {
        makePath(lCommand(value), 'L');
        fromPath[lCommand(value)] = value;
      }
      if (!visited[rCommand(value)]) {
        makePath(rCommand(value), 'R');
        fromPath[rCommand(value)] = value;
      }
    }
    return "";
  }

  private static void makePath(int value, char command) {
    visited[value] = true;
    path[value] = command;
    queue.offer(value);
  }

  private static int dCommand(int n) {
    return (n * 2) % 10000;
  }

  private static int sCommand(int n) {
    return ((n + 10000) - 1) % 10000;
  }

  private static int lCommand(int n) {
    return (n % 1000) * 10 + n / 1000;
  }

  private static int rCommand(int n) {
    return (n % 10) * 1000 + n / 10;
  }
}
