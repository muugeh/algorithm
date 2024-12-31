package dp.boj;

// [피보나치 함수] https://www.acmicpc.net/problem/1003

import java.io.*;

public class BOJ1003 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int t = Integer.parseInt(br.readLine());
    while(t-- > 0){
      int n = Integer.parseInt(br.readLine());
      int[][] oneOrZero = new int[41][2];
      fibonacci(n, oneOrZero);
      bw.write(oneOrZero[n][0] + " " + oneOrZero[n][1] + "\n");
    }
    bw.flush();
    bw.close();
    br.close();
  }

  private static void fibonacci(int n, int[][] oneOrZero){
    oneOrZero[0][0] = 1;
    oneOrZero[1][1] = 1;
    for(int i = 2; i <= n; i++){
      oneOrZero[i][0] = oneOrZero[i-1][0] + oneOrZero[i-2][0];
      oneOrZero[i][1] = oneOrZero[i-1][1] + oneOrZero[i-2][1];
    }
  }

}
