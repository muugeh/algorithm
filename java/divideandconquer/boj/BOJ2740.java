package divideandconquer.boj;

// [행렬 곱셈] https://www.acmicpc.net/problem/2740

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2740 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    int[][] a = new int[n][];
    for (int i = 0; i < n; i++) {
      a[i] = Arrays.stream(br.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
    }

    st = new StringTokenizer(br.readLine());
    st.nextToken();
    int k = Integer.parseInt(st.nextToken());

    int[][] b = new int[m][];
    for (int i = 0; i < m; i++) {
      b[i] = Arrays.stream(br.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
    }

    StringBuilder sb = new StringBuilder();
    int[][] multiply = getMultiply(a, b);
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < k; j++) {
        sb.append(multiply[i][j]).append(" ");
      }
      sb.append("\n");
    }
    System.out.println(sb);
  }

  private static int[][] getMultiply(int[][] a, int[][] b) {
    int[][] result = new int[a.length][b[0].length];
    for (int i = 0; i < a.length; i++) {
      for (int j = 0; j < b[0].length; j++) {
        for (int k = 0; k < b.length; k++) {
          result[i][j] += a[i][k] * b[k][j];
        }
      }
    }
    return result;
  }
}
