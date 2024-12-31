package sort.boj;

// [수 정렬하기] https://www.acmicpc.net/problem/2750

import java.io.*;
import java.util.Arrays;

public class BOJ2750 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(br.readLine());
    int[] array = new int[n];
    for (int i = 0; i < n; i++)
      array[i] = Integer.parseInt(br.readLine());
    Arrays.sort(array);
    for (int i = 0; i < n; i++) {
      bw.write(array[i] + "\n");
    }

    bw.flush();
    bw.close();
    br.close();
  }

}
