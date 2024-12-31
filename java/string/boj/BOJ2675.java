package string.boj;

// [문자열 반복] https://www.acmicpc.net/problem/2675

import java.io.*;
import java.util.StringTokenizer;

public class BOJ2675 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int t = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    while(t-- > 0){
      StringTokenizer st = new StringTokenizer(br.readLine());
      int r = Integer.parseInt(st.nextToken());
      String s = st.nextToken();
      for(int i = 0; i < s.length(); i++){
        for(int j = 0; j < r; j ++) {
          sb.append(s.charAt(i));
        }
      }
      sb.append("\n");
    }
    bw.write(sb.toString());
    bw.flush();
    bw.close();
    br.close();
  }

}
