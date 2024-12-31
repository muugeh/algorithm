package strategies.chap8;

import java.util.Arrays;
import java.util.Scanner;
import util.Input;

public class Pi {

  static String number;
  static int n;
  static int[] cache;
  static int INF = 987654321;

  public static void main(String[] args) throws Exception {
    Scanner sc = Input.sc(new Pi());
    int C = sc.nextInt();
    while (C-- > 0) {
      number = sc.next();
      n = number.length();
      cache = new int[10002];
      Arrays.fill(cache, -1);

      System.out.println(sum(0));
    }
  }

  private static int sum(int start) {
    if (start == n) {
      return 0;
    }

    if (cache[start] != -1) {
      return cache[start];
    }

    cache[start] = INF;

    for (int i = 3; i <= 5; i++) {
      if (i + start <= n) {
        cache[start] = Math.min(cache[start], sum(start + i) + level(start, i));
      }
    }

    return cache[start];
  }

  private static int level(int start, int size) {

    String p = number.substring(start, start + size);

    char one = p.charAt(0);
    boolean same = true;
    for (int i = 1; i < p.length(); i++) {
      if (one != p.charAt(i)) {
        same = false;
        break;
      }
    }

    if (same) {
      return 1;
    }

    boolean progressive = true;
    for (int i = 0; i < p.length() - 1; i++) {
      if (p.charAt(i + 1) - p.charAt(i) != p.charAt(1) - p.charAt(0)) {
        progressive = false;
        break;
      }
    }

    if (progressive) {
      return 2;
    }

    boolean two = true;
    for (int i = 2; i < p.length(); i++) {
      if (p.charAt(i) != p.charAt(i % 2)) {
        two = false;
        break;
      }
    }

    if (two) {
      return 4;
    }

    boolean increase = false, decrease = false;
    int before = Integer.parseInt(p.substring(0, 1));
    int now = Integer.parseInt(p.substring(1, 2));
    int range;

    if (before - now >= 0) {
      range = before - now;
      decrease = true;
    } else {
      range = now - before;
      increase = true;
    }

    for (int i = 1; i < p.length(); i++) {
      before = Integer.parseInt(p.substring(i - 1, i));
      now = Integer.parseInt(p.substring(i, i + 1));

      if (increase && before - now != range) {
        increase = false;
      }
      if (decrease && now - before != range) {
        decrease = false;
      }
    }
    if (increase || decrease) {
      return 5;
    }

    return 10;
  }


}
