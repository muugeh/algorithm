package structure.queue;

// [카드2] https://www.acmicpc.net/problem/2164

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class BOJ2164 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    Queue<Integer> queue = new ArrayDeque<>();
    for(int i = 1; i <= n; i++)
      queue.add(i);
    while(queue.size() > 1){
      queue.poll();
      queue.add(queue.poll());
    }
    System.out.println(queue.peek());
  }
}
