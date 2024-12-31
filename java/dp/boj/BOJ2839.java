package dp.boj;

// [설탕 배달] https://www.acmicpc.net/problem/2839

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2839 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    System.out.println(solve(n));
  }

  private static int INF = 987654321;

  private static int solve(int weight){
    int answer = count(weight);
    if(answer >= INF) answer = -1;
    return answer;
  }

  private static int count(int weight) {
    int[] bags = init();
    for(int i = 6; i <= weight; i++){
      bags[i] = Math.min(bags[i - 3], bags[i - 5]) + 1;
    }
    return bags[weight];
  }

  private static int[] init(){
    int[] bags = new int[5001];
    Arrays.fill(bags, INF);
    bags[3] = bags[5] = 1;
    return bags;
  }

}
