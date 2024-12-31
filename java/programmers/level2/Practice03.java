package programmers.level2;

// [올바른 괄호] https://programmers.co.kr/learn/courses/30/lessons/12909

import java.io.IOException;
import java.util.Stack;

public class Practice03 {
  public static void main(String[] args) throws IOException {
    String s = "()()";
    System.out.println(solution(s)); // true
    s = ")()(";
    System.out.println(solution(s)); // false
  }

  private static boolean solution(String s) {
    char[] c = s.toCharArray();
    Stack<Character> stack = new Stack<>();
    for (char value : c) {
      if (stack.isEmpty()) {
        stack.push(value);
        continue;
      }
      if (stack.peek() == '(' && value == ')') stack.pop();
      else stack.push(value);
    }
    return stack.isEmpty();
  }

}
