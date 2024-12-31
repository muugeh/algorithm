package strategies.chap19;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Brackets2 {

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
    int C = Integer.parseInt(bufferedReader.readLine());
    while (C-- > 0) {
      String bracket = bufferedReader.readLine();

      bufferedWriter.write(match(bracket));
      bufferedWriter.newLine();
      bufferedWriter.flush();
    }
  }

  private static String match(String bracket) {
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < bracket.length(); i++) {
      char now = bracket.charAt(i);
      if (stack.isEmpty()) {
        stack.push(now);
      } else {
        char top = stack.peek();
        if ((top == '(' && now == ')') ||
            (top == '{' && now == '}') ||
            (top == '[' && now == ']')) {
          stack.pop();
        } else{
          stack.push(now);
        }
      }
    }
    return stack.isEmpty() ? "YES" : "NO";
  }
}