package dp.boj;

// [가장 긴 증가하는 부분 수열] https://www.acmicpc.net/problem/11053

import java.io.*;
import java.util.Arrays;

public class BOJ11053 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(br.readLine());
    int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    int[] lis = new int[n];
    for (int i = 0; i < lis.length; i++) {
      lis[i] = 1;
      for (int j = 0; j < i; j++) {
        if (array[j] < array[i]) {
          lis[i] = Math.max(lis[i], lis[j] + 1);
        }
      }
    }
    bw.write(String.valueOf(Arrays.stream(lis).max().orElse(-1)));
    bw.flush();
    bw.close();
    br.close();
  }
}
