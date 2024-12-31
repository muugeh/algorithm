package math.boj;

// [네 번째 점] https://www.acmicpc.net/problem/3009

import java.io.*;
import java.util.StringTokenizer;

public class BOJ3009 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int x1 = 0, x2 = 0, y1 = 0, y2 = 0;
    for (int i = 0; i < 3; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      if (x2 == 0) {
        x2 = x;
      } else if (x2 != x && x1 == 0) {
        x1 = x;
      } else if (x2 != x) {
        int tmp = x2;
        x2 = x1;
        x1 = tmp;
      }

      if (y2 == 0) {
        y2 = y;
      } else if (y2 != y && y1 == 0) {
        y1 = y;
      } else if (y2 != y) {
        int tmp = y2;
        y2 = y1;
        y1 = tmp;
      }
    }
    bw.write(x1 + " " + y1);
    bw.flush();
    bw.close();
    br.close();
  }

}
