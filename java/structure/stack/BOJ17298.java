package structure.stack;

// [오큰수] https://www.acmicpc.net/problem/17298

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ17298 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    List<Integer> result = new ArrayList<>(n);
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
      result.add(-1);
    }

    Stack<Integer> stack = new Stack<>();
    for (int i = n - 1; i >= 0; i--) {
      while (!stack.isEmpty()) {
        if (stack.peek() <= arr[i]) stack.pop();
        else {
          result.set(i, stack.peek());
          break;
        }
      }
      stack.push(arr[i]);
    }
    StringBuilder sb = new StringBuilder();
    result.forEach(v -> sb.append(v).append(" "));
    System.out.println(sb);
  }
}
