package math.boj;

// [패션왕 신해빈] https://www.acmicpc.net/problem/9375

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ9375 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());
    Map<String, Integer> coordination = new HashMap<>();
    while (t-- > 0) {
      coordination.clear();
      int n = Integer.parseInt(br.readLine());
      for (int i = 0; i < n; i++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        st.nextToken();
        String type = st.nextToken();
        coordination.put(type, coordination.getOrDefault(type, 0) + 1);
      }
      int sum = 1;
      for (int names : coordination.values()) {
        sum *= (names + 1);
      }
      sum -= 1;
      System.out.println(sum);
    }
  }
}
