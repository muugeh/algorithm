package strategies.chap9;

import java.util.Scanner;
import util.Input;

public class DragonCurve {

  public static void main(String[] args) {
    Scanner sc = Input.sc(new DragonCurve());
    int c = sc.nextInt();

    while (c-- > 0) {
      n = sc.nextInt();
      p = sc.nextInt();
      l = sc.nextInt();

      precalc();
      for(int i = p-1; i < p+l-1; i++) {
        System.out.print(expand("FX", n, i));
      }
      System.out.println();
    }

  }

  static int n;
  static int p;
  static int l;

  final static int MAX = 1000000000 + 1;
  static int[] length = new int[51];

  static void precalc() {
    length[0] = 1;
    for (int i = 1; i <= 50; i++) {
      length[i] = Math.min(MAX, length[i - 1] * 2 + 2);
    }
  }

  final static String EXPAND_X = "X+YF";
  final static String EXPAND_Y = "FX-Y";

  static char expand(String dragonCurve, int generations, int skip) {
    if (generations == 0) {
      return dragonCurve.charAt(skip);
    }
    for (int i = 0; i < dragonCurve.length(); ++i) {
      if (dragonCurve.charAt(i) == 'X' || dragonCurve.charAt(i) == 'Y') {
        if (skip >= length[generations]) {
          skip -= length[generations];
        } else if (dragonCurve.charAt(i) == 'X') {
          return expand(EXPAND_X, generations - 1, skip);
        } else {
          return expand(EXPAND_Y, generations - 1, skip);
        }
      } else if (skip > 0) {
        --skip;
      } else {
        return dragonCurve.charAt(i);
      }
    }
    return '#';
  }
}
