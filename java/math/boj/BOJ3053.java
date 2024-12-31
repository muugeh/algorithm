package math.boj;

// [택시 기하학] https://www.acmicpc.net/problem/3053

import java.io.*;

public class BOJ3053 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(br.readLine());
    double ur = Math.pow(n, 2) * Math.PI;
    double tr = Math.pow(n, 2) * 2;
    bw.write(ur + "\n" + tr);
    bw.flush();
    bw.close();
    br.close();
  }

}
