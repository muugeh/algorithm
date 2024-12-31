package math.boj;

// [배수와 약수] https://www.acmicpc.net/problem/5086

import java.io.*;
import java.util.StringTokenizer;

public class BOJ5086 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String line;
    StringBuilder sb = new StringBuilder();
    while (!(line = br.readLine()).equals("0 0")) {
      StringTokenizer st = new StringTokenizer(line);
      int first = Integer.parseInt(st.nextToken());
      int second = Integer.parseInt(st.nextToken());
      if (second % first == 0) sb.append("factor").append("\n");
      else if (first % second == 0) {
        sb.append("multiple").append("\n");
      } else sb.append("neither").append("\n");
    }
    bw.write(sb.toString());
    bw.flush();
    bw.close();
    br.close();
  }
}
