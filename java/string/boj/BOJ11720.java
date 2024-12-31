package string.boj;

// [숫자의 합] https://www.acmicpc.net/problem/11720

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ11720 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    String line = br.readLine();

    int sum = 0;

    for(int i = 0; i < line.length(); i++)
      sum += Character.digit(line.charAt(i), 10);

    System.out.println(sum);
  }

}
