package backtracking.boj;

// [N과 M (4)] https://www.acmicpc.net/problem/15652

import java.io.*;
import java.util.StringTokenizer;

public class BOJ15652 {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  private static StringBuilder sb = new StringBuilder();
  private static int n;
  private static int m;
  private static int[] numbers;

  public static void main(String[] args) throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    numbers = new int[m];
    permutation(0);
    bw.write(sb.toString());
    bw.flush();
    bw.close();
    br.close();
  }

  private static void permutation(int depth) {
    if (depth == m) {
      for (int i = 0; i < m; i++) {
        sb.append(numbers[i]).append(' ');
      }
      sb.append('\n');
      return;
    }

    for (int i = 1; i <= n; i++) {
      numbers[depth] = i;
      if (possible(depth, numbers)) {
        permutation(depth + 1);
      }
      numbers[depth] = 0;
    }
  }

  private static boolean possible(int depth, int[] numbers) {
    for (int i = 0; i < depth; i++) {
      if (numbers[depth] < numbers[i])
        return false;
    }
    return true;
  }

}
