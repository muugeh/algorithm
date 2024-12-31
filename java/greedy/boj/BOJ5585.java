package greedy.boj;

// [거스름돈] https://www.acmicpc.net/problem/5585

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ5585 {

  private static final int PAY = 1000;
  private static final int[] coins = {500, 100, 50, 10, 5, 1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    System.out.println(count(n));
  }

  private static int count(int n) {
    int count = 0;
    int size = 0;
    int remains = PAY - n;
    while(remains > 0){
      count += remains / coins[size];
      remains %= coins[size];
      size++;
    }
    return count;
  }

}
