package string.boj;

// [단어 공부] https://www.acmicpc.net/problem/1157

import java.io.*;

public class BOJ1157 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String word = br.readLine().toUpperCase();
    int[] alphabet = new int[26];
    int max = 0;
    for(int i = 0; i < word.length(); i++){
      int index = word.charAt(i) - 'A';
      max = Math.max(++alphabet[index], max);
    }

    boolean duplicate = false;
    char c = '?';
    for (int i = 0; i < alphabet.length; i++) {
      if (alphabet[i] == max) {
        if (duplicate) {
          c = '?';
          break;
        } else {
          duplicate = true;
          c = (char) (i + 'A');
        }
      }
    }
    bw.write(String.valueOf(c));
    bw.flush();
    bw.close();
    br.close();
  }

}
