package math.boj;

// [소인수분해] https://www.acmicpc.net/problem/11653

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ11653 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int n = Integer.parseInt(br.readLine());
    int k = 2;
    while (n != 1) {
      if (n % k == 0) {
        sb.append(k).append("\n");
        n /= k;
      }
      else {
        k++;
      }
    }
    System.out.println(sb);
  }

}
