package math.boj;

// [직사각형에서 탈출] https://www.acmicpc.net/problem/1085

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1085 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int x = Integer.parseInt(st.nextToken());
    int y = Integer.parseInt(st.nextToken());
    int w = Integer.parseInt(st.nextToken());
    int h = Integer.parseInt(st.nextToken());

    int min = Math.min(Math.min(Math.abs(x - w), Math.abs(y - h)), Math.min(x, y));

    bw.write(String.valueOf(min));
    bw.flush();
    bw.close();
    br.close();
  }

}
