package dp.boj;

// [계단 수] https://www.acmicpc.net/problem/1562

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1562 {

  private static final int MOD = 1000 * 1000 * 1000;
  private static final int ALL_USED = (1 << 10) - 1;
  private static final int[][][] cache = new int[1 << 10][101][10];
  private static int n;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    System.out.println(count());
  }

  private static int count() {
    int count = 0;

    for (int i = 1; i <= 9; i++) {
      count += floor((1 << i), 0, i);
      count %= MOD;
    }

    return count;
  }

  private static int floor(int used, int start, int now) {
    int answer = cache[used][start][now];
    if (answer != 0) {
      return answer;
    }

    if (start == n - 1) {
      return (used & ALL_USED) == ALL_USED ? 1 : 0;
    }

    if (now < 9) {
      answer += floor(used | (1 << now + 1), start + 1, now + 1) % MOD;
    }

    if (now > 0) {
      answer += floor(used | (1 << now - 1), start + 1, now - 1) % MOD;
    }

    answer %= MOD;

    return cache[used][start][now] = answer;
  }

}
