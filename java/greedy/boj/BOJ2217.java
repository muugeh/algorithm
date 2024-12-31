package greedy.boj;

// [로프] https://www.acmicpc.net/problem/2217

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2217 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] ropes = new int[n];
    for (int i = 0; i < n; i++) {
      ropes[i] = Integer.parseInt(br.readLine());
    }
    Arrays.sort(ropes);
    int max = ropes[n - 1];
    for (int i = 0; i < n; i++) {
      max = Math.max(max, ropes[i] * (n - i));
    }
    System.out.println(max);
    br.close();
  }
}
