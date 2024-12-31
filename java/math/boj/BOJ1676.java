package math.boj;

// [팩토리얼 0의 개수] https://www.acmicpc.net/problem/1676

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1676 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int count = n / 5 + n / 25 + n / 125;
    System.out.println(count);
  }
}
