package structure.queue;

// [AC] https://www.acmicpc.net/problem/5430

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ5430 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int t = Integer.parseInt(br.readLine());
    List<Integer> list = new ArrayList<>();
    while (t-- > 0) {
      list.clear();
      char[] p = br.readLine().toCharArray();
      int n = Integer.parseInt(br.readLine());
      String line = br.readLine().replaceAll("[\\[\\]]", "");
      StringTokenizer st = new StringTokenizer(line, ",");
      for (int i = 0; i < n; i++) {
        list.add(Integer.valueOf(st.nextToken()));
      }

      boolean error = false;
      boolean reverse = false;
      for (char command : p) {
        if (command == 'R') reverse = !reverse;
        else if (command == 'D') {
          if (list.isEmpty()) {
            error = true;
            break;
          }
          int index = reverse ? list.size() - 1 : 0;
          list.remove(index);
        }
      }
      if (error) sb.append("error");
      else {
        sb.append("[");
        int size = list.size();
        int start = reverse ? size - 1 : 0;
        int end = reverse ? -1 : size;
        int order = reverse ? -1 : 1;
        for (int i = start; i != end; i += order) {
          sb.append(list.get(i));
          if (i != end - order) sb.append(",");
        }
        sb.append("]");
      }
      sb.append("\n");
    }
    System.out.println(sb);
  }
}
