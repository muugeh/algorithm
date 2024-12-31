package structure.queue;

// [큐 2] https://www.acmicpc.net/problem/18258

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ18258 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    Queue queue = new Queue();
    StringBuilder sb = new StringBuilder();
    while (n-- > 0) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      String command = st.nextToken();
      switch (command) {
        case "push":
          queue.push(Integer.parseInt(st.nextToken()));
          break;
        case "pop":
          sb.append(queue.pop()).append("\n");
          break;
        case "size":
          sb.append(queue.size()).append("\n");
          break;
        case "empty":
          sb.append(queue.empty()).append("\n");
          break;
        case "front":
          sb.append(queue.front()).append("\n");
          break;
        case "back":
          sb.append(queue.back()).append("\n");
          break;
      }
    }
    System.out.println(sb);
  }

  private static class Queue {

    List<Integer> queue;

    public Queue() {
      queue = new LinkedList<>();
    }

    public void push(int x) {
      queue.add(x);
    }

    public int pop() {
      if (queue.isEmpty()) return -1;
      return queue.remove(0);
    }

    public int size() {
      return queue.size();
    }

    public int empty() {
      return queue.isEmpty() ? 1 : 0;
    }

    public int front() {
      return get(0);
    }

    public int back() {
      return get(queue.size() - 1);
    }

    private int get(int x) {
      if (queue.isEmpty()) return -1;
      return queue.get(x);
    }
  }
}
