package strategies.chap8;

import java.util.Arrays;

public class Bino {

  public static void main(String[] args){
    Arrays.stream(cache).forEach(e -> Arrays.fill(e, -1));

    int[] a = new int[10];

    Integer b = a[2];

    b = 1;

    System.out.println(a[2]);

    System.out.println(bino2(4, 2));
  }

  static int[][] cache = new int[30][30];

  static int bino2(int n, int r){
    if(r == 0 || n == r) return 1;
    if(cache[n][r] != -1)
      return cache[n][r];
    return cache[n][r] = bino2(n - 1, r - 1) + bino2(n - 1, r);
  }
}
