package math.boj;

// [터렛] https://www.acmicpc.net/problem/1002

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1002 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int t = Integer.parseInt(br.readLine());
    while (t-- > 0) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int x1 = Integer.parseInt(st.nextToken());
      int y1 = Integer.parseInt(st.nextToken());
      int r1 = Integer.parseInt(st.nextToken());
      int x2 = Integer.parseInt(st.nextToken());
      int y2 = Integer.parseInt(st.nextToken());
      int r2 = Integer.parseInt(st.nextToken());

      int count;
      if (x1 == x2 && y1 == y2 && r1 == r2) {
        count = -1;
      } else {
        double distance = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
        int sum = r1 + r2;
        int sub = Math.abs(r1 - r2);
        if (distance == sum || distance == sub) {
          count = 1;
        } else if (distance > sum || distance < sub) {
          count = 0;
        } else {
          count = 2;
        }
      }
      bw.write(String.valueOf(count));
      bw.newLine();
    }
    bw.flush();
    bw.close();
    br.close();
  }

}
