package string.boj;

// [숫자의 개수] https://www.acmicpc.net/problem/2577

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2577 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int[] count = new int[10];

    int a = Integer.parseInt(br.readLine());
    int b = Integer.parseInt(br.readLine());
    int c = Integer.parseInt(br.readLine());

    int multiply = a * b * c;

    String numbers = String.valueOf(multiply);

    for (int i = 0; i < numbers.length(); i++) {
      count[numbers.charAt(i) - '0']++;
    }

    for (int i : count) {
      System.out.println(i);
    }

  }

}
