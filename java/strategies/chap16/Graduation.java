package strategies.chap16;

import java.util.Arrays;
import java.util.Scanner;
import util.Input;

public class Graduation {

  static int N; // 전공 과목의 수
  static int K; // 들어야할 과목의 수
  static int M; // 학기의 수
  static int L; // 한 학기에 최대로 들을 수 있는 과목의 수

  static int[] prerequisites;
  static int[] classes;
  static final int INF = 987654321;

  public static void main(String[] args) {
    Scanner sc = Input.sc(new Graduation());
    int T = sc.nextInt();

    while (T-- > 0) {
      N = sc.nextInt();
      K = sc.nextInt();
      M = sc.nextInt();
      L = sc.nextInt();

      prerequisites = new int[12];

      for (int i = 0; i < N; i++) {
        int R = sc.nextInt();
        for (int j = 0; j < R; j++) {
          prerequisites[i] |= 1 << sc.nextInt();
        }
      }

      classes = new int[10];
      cache = new int[10][1 << 12];
      for (int[] i : cache) {
        Arrays.fill(i, -1);
      }

      for (int i = 0; i < M; i++) {
        int C = sc.nextInt();
        for (int j = 0; j < C; j++) {
          classes[i] |= 1 << sc.nextInt();
        }
      }

      System.out.println(graduate(0, 0));
    }


  }

  static int[][] cache;

  private static int graduate(int semester, int taken) {
    if (Integer.bitCount(taken) >= K) {
      return 0;
    }

    if (semester == M) {
      return INF;
    }

    int answer = cache[semester][taken];
    if (answer != -1) {
      return answer;
    }

    answer = INF;

    int canTake = (classes[semester] & ~taken);
    for (int i = 0; i < N; i++) {
      if (((canTake & (1 << i)) == (1 << i)) && (taken & prerequisites[i]) != prerequisites[i]) {
        canTake &= ~(1 << i);
      }
    }

    for (int take = canTake; take > 0; take = ((take - 1) & canTake)) {
      if (Integer.bitCount(take) > L) {
        continue;
      }
      answer = Math.min(answer, graduate(semester + 1, taken | take) + 1);
    }

    answer = Math.min(answer, graduate(semester + 1, taken));

    return cache[semester][taken] = answer;

  }

}
