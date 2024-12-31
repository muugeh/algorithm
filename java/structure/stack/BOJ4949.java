package structure.stack;

// [균형잡힌 세상] https://www.acmicpc.net/problem/4949

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ4949 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Stack<Character> stack = new Stack<>();
    String brackets = "([])";
    String line;
    while (!(line = br.readLine()).equals(".")) {
      stack.clear();
      String[] words = line.split("\\s");
      for (String word : words) {
        char[] ch = word.toCharArray();
        for (char c : ch) {
          if (brackets.indexOf(c) != -1) {
            if (!stack.isEmpty() && matchBracket(stack.peek(), c)) stack.pop();
            else stack.push(c);
          }
        }
      }
      System.out.println(stack.isEmpty() ? "yes" : "no");
    }
  }

  private static boolean matchBracket(char a, char b) {
    return (a == '(' && b == ')') || a == '[' && b == ']';
  }
}
