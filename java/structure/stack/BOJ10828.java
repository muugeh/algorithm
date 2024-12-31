package structure.stack;

// [스택] https://www.acmicpc.net/problem/10828

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ10828 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    Stack stack = new Stack();
    while (n-- > 0) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      String command = st.nextToken();
      switch (command) {
        case "push":
          int value = Integer.parseInt(st.nextToken());
          stack.push(value);
          break;
        case "pop":
          System.out.println(stack.pop());
          break;
        case "size":
          System.out.println(stack.size());
          break;
        case "empty":
          System.out.println(stack.empty());
          break;
        case "top":
          System.out.println(stack.top());
          break;
      }
    }
  }

  private static class Stack {
    List<Integer> stack;

    public Stack() {
      stack = new ArrayList<>();
    }

    public void push(int x) {
      stack.add(x);
    }

    public int pop() {
      if (stack.isEmpty()) return -1;
      return stack.remove(stack.size() - 1);
    }

    public int size() {
      return stack.size();
    }

    public int empty() {
      return stack.isEmpty() ? 1 : 0;
    }

    public int top() {
      if (stack.isEmpty()) return -1;
      return stack.get(stack.size() - 1);
    }
  }
}
