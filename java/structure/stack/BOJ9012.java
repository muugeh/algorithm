package structure.stack;

// [괄호] https://www.acmicpc.net/problem/9012

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ9012 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Stack<Character> stack = new Stack<>();
    int t = Integer.parseInt(br.readLine());
    while (t-- > 0) {
      stack.clear();
      char[] brackets = br.readLine().toCharArray();
      for (char bracket : brackets) {
        if (!stack.isEmpty() && (stack.peek() == '(' && bracket == ')')) stack.pop();
        else stack.push(bracket);
      }
      System.out.println(stack.isEmpty() ? "YES" : "NO");
    }
  }
}
