package structure.queue;

// [덱] https://www.acmicpc.net/problem/10866

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ10866 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    Deque deque = new Deque();

    StringBuilder sb = new StringBuilder();
    while (n-- > 0) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      String command = st.nextToken();
      switch (command) {
        case "push_front":
          deque.push_front(Integer.parseInt(st.nextToken()));
          break;
        case "push_back":
          deque.push_back(Integer.parseInt(st.nextToken()));
          break;
        case "pop_front":
          sb.append(deque.pop_front()).append("\n");
          break;
        case "pop_back":
          sb.append(deque.pop_back()).append("\n");
          break;
        case "size":
          sb.append(deque.size()).append("\n");
          break;
        case "empty":
          sb.append(deque.empty()).append("\n");
          break;
        case "front":
          sb.append(deque.front()).append("\n");
          break;
        case "back":
          sb.append(deque.back()).append("\n");
          break;
      }
    }
    System.out.println(sb);
  }

  public static class Deque {
    List<Integer> deque;

    public Deque() {
      deque = new LinkedList<>();
    }

    public void push_front(int x) {
      deque.add(0, x);
    }

    public void push_back(int x) {
      deque.add(deque.size(), x);
    }

    public int pop_front() {
      if (deque.isEmpty()) return -1;
      return deque.remove(0);
    }

    public int pop_back() {
      if (deque.isEmpty()) return -1;
      return deque.remove(deque.size() - 1);
    }

    public int size() {
      return deque.size();
    }

    public int empty() {
      return deque.isEmpty() ? 1 : 0;
    }

    public int front() {
      return get(0);
    }

    public int back() {
      return get(deque.size() - 1);
    }

    private int get(int x) {
      if (deque.isEmpty()) return -1;
      return deque.get(x);
    }
  }
}
