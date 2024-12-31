package math.boj;

// [링] https://www.acmicpc.net/problem/3036

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ3036 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] rings = Arrays.stream(br.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
    int firstRing = rings[0];
    rings[0] = -1;

    StringBuilder sb = new StringBuilder();
    for(int ring: rings){
      if(ring == -1) continue;
      sb.append(getReducedFraction(firstRing, ring)).append("\n");
    }
    System.out.println(sb);
  }

  private static String getReducedFraction(int a, int b){
    return (a / gcd(a, b)) + "/" + (b / gcd(a, b));
  }

  private static int gcd(int a, int b){
    if(b == 0) return a;
    return gcd(b, a % b);
  }
}
