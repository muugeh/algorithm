package structure.stack;

// [제로] https://www.acmicpc.net/problem/10773

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ10773 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Stack<Integer> stack = new Stack<>();
    int k = Integer.parseInt(br.readLine());
    while(k-- > 0){
      int num = Integer.parseInt(br.readLine());
      if(num == 0) stack.pop();
      else stack.push(num);
    }
    System.out.println(stack.stream().mapToInt(i -> i).sum());
  }

}
