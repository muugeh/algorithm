package dp.boj;

// [1로 만들기 2] https://www.acmicpc.net/problem/12852

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ12852 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int n = Integer.parseInt(br.readLine());
    List<Integer> shortestPath = new ArrayList<>(n);
    for(int i = 0; i <= n; i++)
      shortestPath.add(0);

    int[] dp = new int[1000001];
    dp[2] = dp[3] = 1;
    for (int i = 2; i <= n; i++) {
      int divideByThree = i / 3;
      int divideByTwo = i / 2;
      int maxIndex = i - 1;
      dp[i] = dp[maxIndex];
      if (i % 3 == 0 && i % 2 == 0) {
        maxIndex = dp[divideByThree] < dp[maxIndex] ? divideByThree : maxIndex;
        maxIndex = dp[divideByTwo] < dp[maxIndex] ? divideByTwo : maxIndex;
      } else if (i % 3 == 0) {
        maxIndex = dp[divideByThree] < dp[maxIndex] ? divideByThree : maxIndex;
      } else if (i % 2 == 0) {
        maxIndex = dp[divideByTwo] < dp[maxIndex] ? divideByTwo : maxIndex;
      }
      dp[i] = Math.min(dp[i], dp[maxIndex]);
      shortestPath.set(i, maxIndex);
      dp[i]++;
    }

    sb.append(dp[n]).append("\n");

    while(n > 0){
      sb.append(n).append(" ");
      n = shortestPath.get(n);
    }

    System.out.println(sb);
  }
}
