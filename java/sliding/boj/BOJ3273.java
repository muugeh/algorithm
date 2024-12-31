package sliding.boj;

// [두 수의 합] https://www.acmicpc.net/problem/3273

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ3273 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    int[] sequence = new int[n];
    for(int i = 0; i < sequence.length; i++)
      sequence[i] = Integer.parseInt(st.nextToken());
    int x = Integer.parseInt(br.readLine());
    Arrays.sort(sequence);
    int count = 0;
    int start = 0;
    int end = n - 1;
    while(start < end){
      int sum = sequence[start] + sequence[end];
      if(sum == x){
        count++;
        start++;
        end--;
      }
      if(sum < x) start++;
      if(sum > x) end--;
    }
    bw.write(String.valueOf(count));
    bw.close();
    br.close();
  }

}
