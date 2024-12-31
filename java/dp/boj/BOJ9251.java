package dp.boj;

// [LCS] https://www.acmicpc.net/problem/9251

import java.io.*;

public class BOJ9251 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    char[] first = br.readLine().toCharArray();
    char[] second = br.readLine().toCharArray();

    int fl = first.length;
    int sl = second.length;
    int[][] dp = new int[fl + 1][sl + 1];

    for(int i = 1; i <= fl; i++) {
      for(int j = 1; j <= sl; j++) {
        if(first[i - 1] == second[j - 1]) {
          dp[i][j] = dp[i - 1][j - 1] + 1;
        }
        else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }
    bw.write(String.valueOf(dp[fl][sl]));
    bw.flush();
    bw.close();
    br.close();
  }

}
