package string.boj;

// [상수] https://www.acmicpc.net/problem/2908

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2908 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int a = Integer.parseInt(new StringBuilder(st.nextToken()).reverse().toString());
    int b = Integer.parseInt(new StringBuilder(st.nextToken()).reverse().toString());
    System.out.println(Math.max(a, b));
  }

}
