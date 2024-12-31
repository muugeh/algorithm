package samsung.boj;

// [시험 감독] https://www.acmicpc.net/problem/13458

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ13458 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] a = Arrays.stream(br.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
    StringTokenizer st = new StringTokenizer(br.readLine());
    int b = Integer.parseInt(st.nextToken());
    int c = Integer.parseInt(st.nextToken());
    long count = n;
    for (int i = 0; i < n; i++) {
      a[i] = Math.max(a[i] - b, 0);
      count += a[i] / c + Math.min(a[i] % c, 1);
    }

    System.out.println(count);
  }
}
