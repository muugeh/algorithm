package programmers.level3;

// 2 x n 타일링 https://programmers.co.kr/learn/courses/30/lessons/12900

public class Practice01 {

  public static void main(String[] args) {
    int n = 4;
    System.out.println(solution(n)); // 5
  }

  public static int solution(int n) {
    int MOD = 1000000007;
    int[] dp = new int[n + 1];
    dp[1] = 1;
    if (n > 1) dp[2] = 2;
    for (int i = 3; i <= n; i++) {
      dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
    }
    return dp[n];
  }
}
