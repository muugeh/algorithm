package string.boj;

// [Hashing] https://www.acmicpc.net/problem/15829

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ15829 {

  private static final int M = 1234567891;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int l = Integer.parseInt(br.readLine());
    String line = br.readLine();
    long hash = 0;
    for (int i = 0; i < l; i++) {
      long point = line.charAt(i) - 'a' + 1;
      int start = 0;
      while (start++ < i) {
        point = (point * 31) % M;
      }
      hash += point % M;
      hash %= M;
    }
    System.out.println(hash);
    br.close();
  }
}
