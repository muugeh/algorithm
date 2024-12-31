package strategies.chap9;

import java.util.Arrays;
import java.util.Scanner;
import util.Input;

public class Morse {

  public static void main(String[] args){
    Scanner sc = Input.sc(new Morse());
    n = sc.nextInt();
    m = sc.nextInt();
    k = sc.nextInt();
    cache = new int[n+m];
    Arrays.fill(cache, -1);
    System.out.println(morse(0, n));
  }

  static int n, m, k;
  static int[] cache;

  public static String morse(int start, int nCount){
    if(start == n + m) return "";

    if(nCount == 0){
      int remain = n + m - start;
      char[] str = new char[remain];
      Arrays.fill(str, 'o');
      return new String(str);
    }

    int total = combination(n+m-start, nCount);

    int half = total/2;

    int sum = 0;
    for(int i = 0; i < start; i++){
      sum += cache[i];
    }

    if(k > half + sum){
      cache[start] = half;
      return "o" + morse(start + 1, nCount);
    }
    else{
      cache[start] = 0;
      return "-" + morse(start + 1, nCount - 1);
    }
  }

  private static int combination(int n, int r) {
    int a=1, b=1;
    for(int i = n; i > n-r; i--)
      a *= i;
    for(int i = 1; i <= r; i++)
      b *= i;
    return a/b;
  }


}
