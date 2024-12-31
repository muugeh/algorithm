package string.boj;

// [그룹 단어 체커] https://www.acmicpc.net/problem/1316

import java.io.*;

public class BOJ1316 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(br.readLine());
    int count = n;
    while (n-- > 0) {
      String word = br.readLine();
      boolean[] checked = new boolean[26];
      char before = word.charAt(0);
      checked[before - 'a'] = true;
      for (int i = 1; i < word.length(); i++) {
        char c = word.charAt(i);
        if (word.charAt(i) != before) {
          if (checked[c - 'a']) {
            count--;
            break;
          } else {
            checked[c - 'a'] = true;
          }
        }
        before = c;
      }
    }
    bw.write(String.valueOf(count));
    bw.flush();
    bw.close();
    br.close();
  }

}
