package dp.boj;

// [연속합] https://www.acmicpc.net/problem/1912

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1912 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(br.readLine());
    int[] sequence = new int[n + 1];
    sequence[0] = -1001;
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= n; i++) {
      sequence[i] = Integer.parseInt(st.nextToken());
      sequence[i] = Math.max(sequence[i - 1] + sequence[i], sequence[i]);
    }
    int max = Arrays.stream(sequence).max().orElse(-1001);
    bw.write(String.valueOf(max));
    bw.flush();
    bw.close();
    br.close();
  }
}
