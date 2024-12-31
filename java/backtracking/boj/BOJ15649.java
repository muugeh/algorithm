package backtracking.boj;

// [N과 M (1)] https://www.acmicpc.net/problem/15649

import java.io.*;
import java.util.StringTokenizer;

public class BOJ15649 {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

  public static void main(String[] args) throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    permutation(n, m, 0, new int[m]);
    bw.flush();
    bw.close();
    br.close();
  }

  private static void permutation(int n, int m, int depth, int[] numbers) throws IOException {
    if(depth == m){
      for(int i = 0; i < m; i++){
        bw.write(numbers[i] + " ");
      }
      bw.newLine();
      return;
    }

    for(int i = 1; i <= n; i++){
      numbers[depth] = i;
      if(possible(depth, numbers)) {
        permutation(n, m, depth + 1, numbers);
      }
      numbers[depth] = 0;
    }
  }

  private static boolean possible(int depth, int[] numbers) {
    for(int i = 0; i < depth; i++){
      if(numbers[depth] == numbers[i])
        return false;
    }
    return true;
  }

}
