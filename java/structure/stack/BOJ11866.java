package structure.stack;

// [요세푸스 문제 0] https://www.acmicpc.net/problem/11866

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ11866 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    Queue<Integer> queue = new ArrayDeque<>();
    for (int i = 1; i <= n; i++) queue.offer(i);
    int count = 0;
    sb.append("<");
    while (!queue.isEmpty()) {
      int now = queue.poll();
      count++;
      if (count % k != 0) queue.offer(now);
      else {
        if (!queue.isEmpty()) sb.append(now).append(", ");
        else sb.append(now);
      }
    }
    sb.append(">");
    bw.write(sb.toString());
    bw.flush();
    bw.close();
    br.close();
  }
}
