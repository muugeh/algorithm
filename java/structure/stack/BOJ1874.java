package structure.stack;

// [스택 수열] https://www.acmicpc.net/problem/1874

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Objects;
import java.util.Queue;
import java.util.Stack;

public class BOJ1874 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    Queue<Integer> queue = new ArrayDeque<>();
    Stack<Integer> stack = new Stack<>();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; i++) {
      queue.offer(Integer.parseInt(br.readLine()));
    }
    for (int i = 1; i <= n; i++) {
      sb.append("+").append("\n");
      stack.push(i);
      while (!stack.isEmpty() && Objects.equals(stack.peek(), queue.peek())) {
        stack.pop();
        queue.poll();
        sb.append("-").append("\n");
      }
    }
    if (queue.isEmpty()) System.out.println(sb);
    else System.out.println("NO");
  }
}
