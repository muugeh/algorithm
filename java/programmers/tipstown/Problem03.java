package programmers.tipstown;

import java.util.*;

public class Problem03 {

  private static final int INF = 20001;

  public static void main(String[] args) {
    String[] strs = {"ba","na","n","a"};
    String t = "banana";
    System.out.println(solution(strs, t)); // 3
  }

  public static int solution(String[] strs, String t) {
    int[] dp = new int[t.length()];
    Arrays.fill(dp, INF);
    Arrays.sort(strs);
    char[][] ch = new char[strs.length][];
    for (int i = 0; i < strs.length; i++) ch[i] = strs[i].toCharArray();
    char[] c = t.toCharArray();
    int n = c.length - 1;

    for (int i = n; i >= 0; i--) {
      for (char[] word : ch) {
        boolean same = true;
        boolean over = false;
        if (i + word.length > c.length) continue;
        for (int k = 0; k < word.length; k++) {
          if (word[k] != c[i + k]) {
            same = false;
            if (word[k] > c[i + k]) {
              over = true;
            }
            break;
          }
        }
        if (over) break;

        if (same && i + word.length - 1 == n) {
          dp[i] = 1;
        } else if (same) {
          dp[i] = Math.min(dp[i], dp[i + word.length] + 1);
        }
      }
    }

    return dp[0] < INF ? dp[0] : -1;
  }
}
