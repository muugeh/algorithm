package structure.queue;

// [이중 우선순위 큐] https://www.acmicpc.net/problem/7662

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class BOJ7662 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int t = Integer.parseInt(br.readLine());
    while (t-- > 0) {
      int q = Integer.parseInt(br.readLine());
      TreeMap<Integer, Integer> map = new TreeMap<>();
      while (q-- > 0) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        char command = st.nextToken().charAt(0);
        int number = Integer.parseInt(st.nextToken());
        if (command == 'I') {
          map.put(number, map.getOrDefault(number, 0) + 1);
        } else {
          if (map.isEmpty()) continue;
          if (number == 1) {
            int maxKey = map.lastKey();
            if (map.get(maxKey) == 1) {
              map.remove(maxKey);
            } else {
              map.put(maxKey, map.get(maxKey) - 1);
            }
          } else {
            int minKey = map.firstKey();
            if (map.get(minKey) == 1) {
              map.remove(minKey);
            } else {
              map.put(minKey, map.get(minKey) - 1);
            }
          }
        }
      }
      if (map.isEmpty()) sb.append("EMPTY");
      else {
        sb.append(map.lastKey()).append(" ").append(map.firstKey());
      }
      sb.append("\n");
    }

    System.out.println(sb);
    br.close();
  }
}
