package dp.boj;

// [파도반 수열] https://www.acmicpc.net/problem/9461

import java.io.*;

public class BOJ9461 {

  private static final long[] dp = new long[101];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int t = Integer.parseInt(br.readLine());
    init();
    while(t-- > 0){
      int n = Integer.parseInt(br.readLine());
      bw.write(String.valueOf(solve(n)));
      bw.newLine();
    }
    bw.flush();
    bw.close();
    br.close();
  }

  private static void init(){
    dp[0] = 0;
    dp[1] = dp[2] = dp[3] = 1;
    dp[4] = 2;
    for(int i = 5; i < dp.length; i++){
      dp[i] = dp[i-1] + dp[i-5];
    }
  }

  private static long solve(int n) {
    return dp[n];
  }

}
