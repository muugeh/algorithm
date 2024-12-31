package math.boj;

// [조합 0의 개수] https://www.acmicpc.net/problem/2004

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2004 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int multipleOfTwo = squareCount(n, 2) - squareCount(m, 2) - squareCount(n - m, 2);
    int multipleOfFive = squareCount(n, 5) - squareCount(m, 5) - squareCount(n - m, 5);
    System.out.println(Math.min(multipleOfTwo, multipleOfFive));
  }

  private static int squareCount(int n, int divide) {
    int count = 0;
    while (n > 0) {
      count += n / divide;
      n /= divide;
    }
    return count;
  }
}
