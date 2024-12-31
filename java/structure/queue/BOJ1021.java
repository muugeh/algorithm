package structure.queue;

// [회전하는 큐] https://www.acmicpc.net/problem/1021

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1021 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int[] picks = Arrays.stream(br.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
    List<Integer> deque = new LinkedList<>();
    for (int i = 1; i <= n; i++) {
      deque.add(i);
    }
    int count = 0;
    for (int pick : picks) {
      int size = deque.size();
      int index = deque.indexOf(pick);
      int reverse = size - index;
      if (index < reverse) {
        while (index-- > 0) {
          deque.add(deque.remove(0));
          count++;
        }
      } else {
        while (reverse-- > 0) {
          deque.add(0, deque.remove(size - 1));
          count++;
        }
      }
      deque.remove(0);
    }

    System.out.println(count);
  }
}
