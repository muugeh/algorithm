package strategies.chap8;

import java.util.Arrays;
import java.util.Scanner;
import util.Input;

public class Wildcard {

  public static void main(String[] args) throws Exception {
    Wildcard card = new Wildcard();
    Scanner sc = Input.sc(card);
    int C = sc.nextInt();

    while (C-- > 0) {
      W = sc.next();
      int n = sc.nextInt();
      while (n-- > 0) {
        Arrays.stream(cache)
              .forEach(e -> Arrays.fill(e, -1));
        S = sc.next();
        a = 0;
        if (matchMemorized(0, 0) == 1) {
          System.out.println(S);
        }
        System.out.println(a);

      }
    }
  }

  public static boolean match(String w, String s) {
    int pos = 0;
    // 기저 사례
    while (pos < s.length() && pos < w.length()) {
      if (w.charAt(pos) == '?' || w.charAt(pos) == s.charAt(pos)) {
        ++pos;
      } else {
        break;
      }
    }

    if (pos == w.length()) {
      return pos == s.length();
    }

    if (w.charAt(pos) == '*') {
      for (int skip = 0; pos + skip <= s.length(); ++skip) {
        if (match(w.substring(pos + 1), s.substring(pos + skip))) {
          return true;
        }
      }
    }

    return false;
  }

  static int[][] cache = new int[101][101];
  static String W, S;

  static int a;

  public static int matchMemorized(int w, int s) {
    a++;

    if (cache[w][s] != -1) {
      return cache[w][s];
    }

    if (s < S.length() && w < W.length()
        && (W.charAt(w) == '?' || W.charAt(w) == S.charAt(s))) {
      return cache[w][s] = matchMemorized(w + 1, s + 1);
    }

    if (w == W.length()) {
      return cache[w][s] = (s == S.length() ? 1 : 0);
    }

    if (W.charAt(w) == '*') {
      if (matchMemorized(w + 1, s) == 1 ||
          (s < S.length() && matchMemorized(w, s + 1) == 1)) {
        return cache[w][s] = 1;
      }
    }

    return cache[w][s] = 0;
  }
}
