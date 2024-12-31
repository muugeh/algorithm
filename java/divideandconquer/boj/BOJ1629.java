package divideandconquer.boj;

// [곱셈] https://www.acmicpc.net/problem/1629

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1629 {

  private static long a, b, c;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    a = Integer.parseInt(st.nextToken());
    b = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());
    System.out.println(pow(b));
  }

  private static long pow(long b) {
    if (b == 1) return a % c;
    long sqrt = pow(b / 2) % c;
    if (b % 2 == 1) return (sqrt * sqrt % c) * a % c;
    return sqrt * sqrt % c;
  }
}
