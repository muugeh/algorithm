package structure.queue;

// [프린터 큐] https://www.acmicpc.net/problem/1966

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1966 {

  private static int[] priority;
  private static Queue<Integer> queue = new ArrayDeque<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());
    while (t-- > 0) {
      queue.clear();
      StringTokenizer st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());
      priority = new int[n];
      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < n; i++) {
        priority[i] = Integer.parseInt(st.nextToken());
        queue.add(i);
      }

      int order = 0;
      while (!queue.isEmpty()) {
        int now = queue.poll();
        if (isBiggest(now)) {
          order++;
          if (now == m) {
            System.out.println(order);
            break;
          }
        }
      }
    }
  }

  private static boolean isBiggest(int now) {
    boolean biggest = true;
    for (int next : queue) {
      if (priority[next] > priority[now]) {
        biggest = false;
        queue.add(now);
        break;
      }
    }
    return biggest;
  }
}
