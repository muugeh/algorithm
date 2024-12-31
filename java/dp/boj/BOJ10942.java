package dp.boj;

// [팰린드롬?] https://www.acmicpc.net/problem/10942

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ10942 {

  private static int[] numbers;
  private static int[][] palindrome;
  private static int n;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    n = Integer.parseInt(br.readLine());
    palindrome = new int[n + 1][n + 1];
    for (int[] a : palindrome) Arrays.fill(a, 1);
    numbers = new int[n + 1];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= n; i++) {
      numbers[i] = Integer.parseInt(st.nextToken());
    }
    checkPalindrome();
    int m = Integer.parseInt(br.readLine());
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int s = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());
      sb.append(palindrome[s][e]).append("\n");
    }
    System.out.println(sb);
    br.close();
  }

  private static void checkPalindrome() {
    for (int i = 1; i <= n; i++) {
      for (int from = 1; from + i <= n; from++) {
        int to = from + i;
        if (palindrome[from + 1][to - 1] == 0 || numbers[from] != numbers[to]) {
          palindrome[from][to] = 0;
        }
      }
    }
  }
}
