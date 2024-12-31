package dp.boj;

// [2xn 타일링] https://www.acmicpc.net/problem/11726

import java.io.*;

 public class BOJ11726 {

   public static void main(String[] args) throws IOException {
     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
     int n = Integer.parseInt(br.readLine());
     final int MOD = 10007;
     int[] blocks = new int[1001];
     blocks[1] = 1;
     blocks[2] = 2;
     for(int i = 3; i <= n; i++){
       blocks[i] = (blocks[i-1] + blocks[i-2]) % MOD;
     }
     bw.write(String.valueOf(blocks[n]));
     bw.flush();
     bw.close();
     br.close();
   }
 }