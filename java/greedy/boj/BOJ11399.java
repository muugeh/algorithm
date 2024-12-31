package greedy.boj;

// [ATM] https://www.acmicpc.net/problem/11399

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11399 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    int[] withdrawal = new int[n];
    for (int i = 0; i < n; i++)
      withdrawal[i] = Integer.parseInt(st.nextToken());
    Arrays.sort(withdrawal);
    int sum = 0;
    int totalSum = 0;
    for (int time : withdrawal) {
      sum += time;
      totalSum += sum;
    }
    bw.write(String.valueOf(totalSum));
    bw.flush();
    bw.close();
    br.close();
  }

}
