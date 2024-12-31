package backtracking.boj;

// [N-Queen] https://www.acmicpc.net/problem/9663

import java.io.*;

public class BOJ9663 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(br.readLine());
    bw.write(String.valueOf(nQueen(0, new int[n])));
    bw.flush();
    bw.close();
    br.close();
  }

  private static int nQueen(int col, int[] cols) {
    int n = cols.length;
    if (col == n)
      return 1;

    int count = 0;
    for (int i = 0; i < cols.length; i++) {
      cols[col] = i;
      if (possible(col, cols)) {
        count += nQueen(col + 1, cols);
      }
    }
    return count;
  }

  private static boolean possible(int col, int[] cols) {
    for (int i = 0; i < col; i++) {
      if (cols[col] == cols[i]) {
        return false;
      } else if (Math.abs(col - i) == Math.abs(cols[col] - cols[i])) {
        return false;
      }
    }
    return true;
  }

}
