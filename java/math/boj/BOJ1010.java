package math.boj;

// [다리 놓기] https://www.acmicpc.net/problem/1010

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1010 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[][] binomial = getBinomial();
    int t = Integer.parseInt(br.readLine());
    while (t-- > 0) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      System.out.println(binomial[b][a]);
    }
  }

  private static int[][] getBinomial() {
    int[][] binomial = new int[31][31];
    for (int i = 0; i <= 30; i++) {
      for (int j = 0; j <= i; j++) {
        if (i == 0  || j == 0 || j == i) binomial[i][j] = 1;
        else binomial[i][j] = binomial[i - 1][j] + binomial[i - 1][j - 1];
      }
    }
    return binomial;
  }
}
