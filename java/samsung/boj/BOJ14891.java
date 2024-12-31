package samsung.boj;

// [톱니바퀴] https://www.acmicpc.net/problem/14891

import java.io.*;
import java.util.StringTokenizer;

public class BOJ14891 {

  private static char[][] gears = new char[5][8];
  private static boolean[] visited = new boolean[5];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    for (int i = 1; i <= 4; i++) {
      gears[i] = br.readLine().toCharArray();
    }
    int k = Integer.parseInt(br.readLine());
    for (int i = 0; i < k; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int direction = Integer.parseInt(st.nextToken());
      visited = new boolean[5];
      rotate(n, direction);
    }
    int sum = 0;
    for (int i = 1; i <= 4; i++) {
      sum += Character.digit(gears[i][0], 10) << (i - 1);
    }
    bw.write(String.valueOf(sum));
    bw.flush();
    bw.close();
    br.close();
  }

  private static void rotate(int n, int direction) {
    visited[n] = true;

    if (n < 4) {
      if (gears[n][2] != gears[n + 1][6] && !visited[n + 1]) {
        rotate(n + 1, direction * -1);
      }
    }
    if (n > 1) {
      if (gears[n - 1][2] != gears[n][6] && !visited[n - 1]) {
        rotate(n - 1, direction * -1);
      }
    }

    if (direction == 1) moveRight(n);
    else moveLeft(n);
  }

  private static void moveRight(int n) {
    char[] nextGear = new char[8];
    System.arraycopy(gears[n], 0, nextGear, 1, 7);
    nextGear[0] = gears[n][7];
    gears[n] = nextGear;
  }

  private static void moveLeft(int n) {
    char[] nextGear = new char[8];
    System.arraycopy(gears[n], 1, nextGear, 0, 8 - 1);
    nextGear[7] = gears[n][0];
    gears[n] = nextGear;
  }
}
