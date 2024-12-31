package strategies.chap8;

import java.util.Arrays;
import java.util.Scanner;
import util.Input;

public class JLIS {

  static int[] A, B;
  static int[][] cache;
  static int n, m;
  static long MIN = Long.MIN_VALUE;

  public static void main(String[] args) throws Exception {
    Scanner sc = Input.sc(new JLIS());
    int C = sc.nextInt();

    while (C-- > 0) {
      n = sc.nextInt();
      m = sc.nextInt();

      A = new int[n];
      B = new int[m];
      cache = new int[101][101];
      for (int[] ia : cache) {
        Arrays.fill(ia, -1);
      }

      for (int i = 0; i < n; i++) {
        A[i] = sc.nextInt();
      }

      for (int i = 0; i < m; i++) {
        B[i] = sc.nextInt();
      }

      System.out.println(solve(-1, -1));
    }
  }

  private static int solve(int indexA, int indexB) {
    if (cache[indexA + 1][indexB + 1] != -1) {
      return cache[indexA + 1][indexB + 1];
    }

    cache[indexA + 1][indexB + 1] = 0;
    long a = indexA == -1 ? MIN : A[indexA];
    long b = indexB == -1 ? MIN : B[indexB];
    long maxElement = Math.max(a, b);

    for (int nextA = indexA + 1; nextA < n; nextA++) {
      if (maxElement < A[nextA]) {
        cache[indexA + 1][indexB + 1] = Math.max(cache[indexA + 1][indexB +1], solve(nextA, indexB) + 1);
      }
    }

    for (int nextB = indexB + 1; nextB < m; nextB++) {
      if (maxElement < B[nextB]) {
        cache[indexA + 1][indexB + 1] = Math.max(cache[indexA + 1][indexB + 1], solve(indexA, nextB) + 1);
      }
    }

    return cache[indexA + 1][indexB + 1];
  }


}
