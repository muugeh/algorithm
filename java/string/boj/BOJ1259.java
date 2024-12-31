package string.boj;

// [팰린드롬수] https://www.acmicpc.net/problem/1259

import java.io.*;

public class BOJ1259 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String line;
    while (!(line = br.readLine()).equals("0")) {
      char[] word = line.toCharArray();
      int n = word.length;
      int mid = n / 2;
      boolean palindrome = true;
      for (int i = 0; i <= mid; i++) {
        if (word[i] != word[n - (i + 1)]) {
          palindrome = false;
          break;
        }
      }
      bw.write((palindrome ? "yes" : "no") + "\n");
    }
    bw.flush();
    bw.close();
    br.close();
  }
}
