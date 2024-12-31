package math.boj;

// [분산처리] https://www.acmicpc.net/problem/1009

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1009 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int t = Integer.parseInt(br.readLine());
    while (t-- > 0) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int total = 1;
      for(int i = 0; i < b; i++){
        total = (total * a) % 10;
      }
      if(total == 0) total = 10;
      System.out.println(total);
    }

    bw.flush();
    bw.close();
    br.close();
  }
}
