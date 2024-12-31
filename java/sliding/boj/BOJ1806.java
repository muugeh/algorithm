package sliding.boj;

// [부분합] https://www.acmicpc.net/problem/1806

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1806 {

  private static final int MAX_N = 100001;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    int[] arr = new int[n+1];
    st = new StringTokenizer(br.readLine());
    for (int i = 1; i < n+1; i++) {
      arr[i] = arr[i-1] + Integer.parseInt(st.nextToken());
    }
    int start = 0;
    int end = 0;
    int min = MAX_N;
    while (start <= n) {
      int partialSum = arr[end] - arr[start];
      if (partialSum >= k) {
        min = Math.min(min, end - start);
        start++;
      } else {
        end++;
        if(end > n)
          break;
      }
    }
    if(min == MAX_N)
      min = 0;
    bw.write(String.valueOf(min));
    bw.flush();
    bw.close();
    br.close();
  }

}
