package strategies.chap9;

import java.util.Arrays;
import java.util.Scanner;
import util.Input;

public class Zimbabwe {

  public static void main(String[] args) {
    Scanner sc = Input.sc(new Zimbabwe());
    int C = sc.nextInt();

    while (C-- > 0) {
      e = sc.next();
      m = sc.nextInt();
      boolean[] visited = new boolean[15];

      char[] ch = e.toCharArray();
      Arrays.sort(ch);
      digits = new String(ch);

      for (int[][] ints : cache) {
        for (int[] anInt : ints)
          Arrays.fill(anInt, -1);
      }

      //generate("", visited);

      System.out.println(price(0,0, m,1));
    }

  }

  final static int MOD = 1000000007;
  static String e, digits;
  static int m;

  private static void generate(String price, boolean[] visited) {
    if (price.length() == e.length()) {
      if (price.compareTo(e) < 0) {
        System.out.println(price);
      }
      return;
    }
    for (int i = 0; i < e.length(); i++) {
      if (!visited[i]) {
        if (i == 0 || visited[i - 1] || digits.charAt(i) != digits.charAt(i - 1)) {
          visited[i] = true;
          generate(price + digits.charAt(i), visited);
          visited[i] = false;
        }
      }
    }
  }

  static int[][][] cache = new int[1 << 14][20][2];

  static int price(int index, int taken, int mod, int less) {
    if (index == e.length()) {
      return (less > 0 && mod == 0) ? 1 : 0;
    }

    int answer = cache[taken][mod][less];
    if (answer != -1) {
      return answer;
    }

    answer = 0;
    for (int next = 0; next < e.length(); ++next) {
      if (((taken & (1 << next)) == 0)) {
        if (less != 0 && e.charAt(index) < digits.charAt(next)) {
          continue;
        }

        if ((next > 0 && digits.charAt(next - 1) == digits.charAt(next))
            && (taken & (1 << (next - 1))) == 0) {
          continue;
        }

        int nextTaken = taken | (1 << next);
        int nextMod = (mod * 10 + digits.charAt(next) - '0') % m;
        int nextLess = ((less == 1) || (e.charAt(index) > digits.charAt(next))) ? 1 : 0;
        answer += price(index + 1, nextTaken, nextMod, nextLess);
        answer %= MOD;
      }
    }
    return cache[taken][mod][less] = answer;
  }

}
