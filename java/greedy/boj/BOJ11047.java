package greedy.boj;

// [동전 0] https://www.acmicpc.net/problem/11047

import java.io.*;
import java.util.StringTokenizer;

public class BOJ11047 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    int[] coins = new int[n];
    for (int i = 0; i < n; i++) {
      coins[i] = Integer.parseInt(br.readLine());
    }
    int totalCount = 0;
    for (int i = n - 1; i >= 0; i--) {
      int count = k / coins[i];
      if (count != 0) {
        totalCount += count;
        k %= coins[i];
      }
      if (k == 0)
        break;
    }
    bw.write(String.valueOf(totalCount));
    bw.flush();
    bw.close();
    br.close();
  }

}
