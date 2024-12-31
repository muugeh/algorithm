package sort.boj;

// [수 정렬하기 3] https://www.acmicpc.net/problem/10989

import java.io.*;

public class BOJ10989 {

  private static int[] count = new int[10001];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();
    int n = Integer.parseInt(br.readLine());
    for (int i = 0; i < n; i++) {
      count[Integer.parseInt(br.readLine())]++;
    }
    for (int i = 1; i <= 10000; i++) {
      for (int j = 0; j < count[i]; j++)
        sb.append(i).append("\n");
    }
    bw.write(sb.toString());
    bw.flush();
    bw.close();
    br.close();
  }

}
