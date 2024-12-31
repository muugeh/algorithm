package backtracking.boj;

import java.io.*;
import java.util.Arrays;

// [연산자 끼워넣기] https://www.acmicpc.net/problem/14888

public class BOJ14888 {

  private static int[] operator;
  private static int[] sequence;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(br.readLine());
    sequence = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    operator = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    dfs(1,sequence[0]);
    bw.write(max + "\n" + min);
    bw.flush();
    bw.close();
    br.close();
  }

  private static int max = -987654321;
  private static int min = 987654321;

  private static void dfs(int depth, int answer) {
    if(depth == sequence.length){
      max = Math.max(max, answer);
      min = Math.min(min, answer);
    }
      for(int j = 0; j < 4; j++) {
        if(operator[j] > 0) {
          operator[j]--;
          dfs(depth + 1, calculate(answer, sequence[depth], j));
          operator[j]++;
        }
    }
  }

  private static int calculate(int answer, int number, int operator) {
    switch (operator){
      case 0:
        return answer + number;
      case 1:
        return answer - number;
      case 2:
        return answer * number;
      case 3:
        return answer / number;
    }
    return 0;
  }

}
