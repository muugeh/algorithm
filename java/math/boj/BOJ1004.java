package math.boj;

// [어린 왕자] https://www.acmicpc.net/problem/1004

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1004 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int t = Integer.parseInt(br.readLine());
    while (t-- > 0) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int x1 = Integer.parseInt(st.nextToken());
      int y1 = Integer.parseInt(st.nextToken());
      int x2 = Integer.parseInt(st.nextToken());
      int y2 = Integer.parseInt(st.nextToken());
      int n = Integer.parseInt(br.readLine());
      int count = 0;

      for (int i = 0; i < n; i++) {
        st = new StringTokenizer(br.readLine());
        int cx = Integer.parseInt(st.nextToken());
        int cy = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        double start = Math.pow(x1 - cx, 2) + Math.pow(y1 - cy, 2);
        double end = Math.pow(x2 - cx, 2) + Math.pow(y2 - cy, 2);
        double area = r * r;
        if (!(start <= area && end <= area) && (start <= area || end <= area))
          count += 1;
      }
      bw.write(count + "\n");
    }
    bw.flush();
    bw.close();
    br.close();
  }

}
