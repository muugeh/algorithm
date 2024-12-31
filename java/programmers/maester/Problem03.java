package programmers.maester;

// [사칙 연산] https://programmers.co.kr/learn/courses/30/lessons/1843

import java.util.Arrays;

public class Problem03 {
  public static void main(String[] args) {
    String[] arr = {"5", "-", "3", "+", "1", "+", "2", "-", "4"};
    System.out.println(solution(arr));
  }
  private static final int MIN = -2000000000;
  private static final int MAX = 2000000000;

  public static int solution(String[] arr) {
    int n = arr.length;
    int[] numbers = new int[(n + 1) / 2];
    String[] op = new String[n / 2];
    int[][][] dp = new int[2][(n + 1) / 2][(n + 1) / 2];

    for(int[] a : dp[0])
      Arrays.fill(a, MAX);
    for(int[] a : dp[1])
      Arrays.fill(a, MIN);

    for(int i = 0; i < n; i+=2){
      numbers[i / 2] = Integer.parseInt(arr[i]);
      dp[0][i / 2][i / 2] = numbers[i / 2];
      dp[1][i / 2][i / 2] = numbers[i / 2];
    }

    for(int i = 1; i < n; i+=2){
      op[i / 2] = arr[i];
    }

    for(int k = 1; k < dp[0].length; k++){
      for(int i = 0; i < dp[0].length - k; i++){
        for(int j = i; j < i + k; j++){
          if(op[j].equals("+")){
            dp[0][i][i+k] = Math.min(dp[0][i][i+k], dp[0][i][j] + dp[0][j+1][i+k]);
            dp[1][i][i+k] = Math.max(dp[1][i][i+k], dp[1][i][j] + dp[1][j+1][i+k]);
          }
          else{
            dp[0][i][i+k] = Math.min(Math.min(dp[0][i][j], dp[1][i][j]) - Math.max(dp[0][j+1][i+k], dp[1][j+1][i+k]), dp[0][i][i+k]);
            dp[1][i][i+k] = Math.max(Math.max(dp[0][i][j], dp[1][i][j]) - Math.min(dp[0][j+1][i+k], dp[1][j+1][i+k]), dp[1][i][i+k]);
          }
        }
      }
    }
    return dp[1][0][dp[0].length - 1];
  }

}
