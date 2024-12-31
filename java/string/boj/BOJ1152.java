package string.boj;

// [단어의 개수] https://www.acmicpc.net/problem/1152

import java.io.*;

public class BOJ1152 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String line = br.readLine();
    int count = line.equals(" ") ? 0 : line.trim().split(" ").length;
    bw.write(String.valueOf(count));
    bw.flush();
    bw.close();
    br.close();
  }

}
