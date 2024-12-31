package strategies.chap6;

import java.io.File;
import java.util.Scanner;

public class ClockSync {

  public static void main(String[] args) throws Exception {
    File file = new File("./src/goo/chap6/input/clocksync.txt");
    Scanner sc = new Scanner(file);
    int C = sc.nextInt();

    while (C-- > 0) {
      int[] clocks = new int[16];
      for (int i = 0; i < clocks.length; ++i)
        clocks[i] = sc.nextInt();
      int answer = match(clocks, 0);
      if(answer == INF) answer = -1;
      System.out.println(answer);
    }
  }

  static final int SWITCHES = 10, CLOCKS = 16, INF = 9999;

  static final int[][] linked = {
      {1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
      {0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0},
      {0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1},
      {1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
      {0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 0, 0},
      {1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
      {0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
      {0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1},
      {0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
      {0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0}
  };

  static void push(int[] clocks, int swtch) {
    for (int clock = 0; clock < CLOCKS; ++clock) {
      if (linked[swtch][clock] == 1) {
        clocks[clock] += 3;
        if (clocks[clock] == 15) {
          clocks[clock] = 3;
        }
      }
    }
  }

  static boolean areAligned(int[] clocks) {
    boolean isMatched = true;
    for (int clock : clocks) {
      if (clock != 12) {
        isMatched = false;
        break;
      }
    }
    return isMatched;
  }

  static int match(int[] clocks, int swtch) {
    if (swtch == SWITCHES) {
      return areAligned(clocks) ? 0 : INF;
    }
    int answer = INF;
    for (int count = 0; count < 4; ++count) {
      answer = Math.min(answer, count + match(clocks, swtch + 1));
      push(clocks, swtch);
    }
    return answer;
  }

}
