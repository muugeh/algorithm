package dp.boj;

// [두부장수 장홍준] https://www.acmicpc.net/problem/1657

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1657 {

  private static int n;
  private static int m;
  private static int[][] dp;
  private static char[][] tofu;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    tofu = new char[n][m];
    for (int i = 0; i < n; i++) {
      String line = br.readLine();
      for (int j = 0; j < m; j++) {
        tofu[i][j] = line.charAt(j);
      }
    }
    dp = new int[n * m][1 << m];
    for (int i = 0; i < n * m; i++) {
      Arrays.fill(dp[i], -1);
    }
    bw.write(String.valueOf(getTotalPrice(0, 0)));
    bw.flush();
    bw.close();
    br.close();
  }

  private static int getTotalPrice(int index, int state) {
    if (index == n * m) return 0;

    if (dp[index][state] != -1) return dp[index][state];

    int answer;
    int x = index / m;
    int y = index % m;
    if ((state & 1) == 1)
      answer = getTotalPrice(index + 1, state >> 1);
    else {
      answer = getTotalPrice(index + 1, state >> 1);
      if (y + 1 < m && (state & 2) != 2)
        answer = Math.max(answer, getTotalPrice(index + 2, (state >> 2)) + getPrice(tofu[x][y], tofu[x][y + 1]));
      if (x + 1 < n)
        answer = Math.max(answer, getTotalPrice(index + 1, (state >> 1) | (1 << m - 1)) + getPrice(tofu[x][y], tofu[x + 1][y]));
    }
    return dp[index][state] = answer;
  }

  private static final int[][] price = {{10, 8, 7, 5, 1},
      {8, 6, 4, 3, 1},
      {7, 4, 3, 2, 1},
      {5, 3, 2, 2, 1},
      {1, 1, 1, 1, 0}};

  private static int getPrice(char a, char b) {
    return price[getRank(a)][getRank(b)];
  }

  private static int getRank(char a) {
    switch (a) {
      case 'A':
        return 0;
      case 'B':
        return 1;
      case 'C':
        return 2;
      case 'D':
        return 3;
      case 'F':
        return 4;
    }
    return -1;
  }

}
