package sliding.boj;

// [두 용액] https://www.acmicpc.net/problem/2470

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2470 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    int[] flasks = new int[n];
    for(int i = 0; i < n; i++){
      flasks[i] = Integer.parseInt(st.nextToken());
    }
    int start = 0;
    int end = n - 1;
    int left = start;
    int right = end;
    int min = Integer.MAX_VALUE;
    Arrays.sort(flasks);
    while(left < right){
      int sum = flasks[left] + flasks[right];
      if(Math.abs(sum) < min){
        min = Math.abs(sum);
        start = left;
        end = right;
      }
      if(sum == 0){
        break;
      }
      if(sum > 0){
        right--;
      }
      if(sum < 0){
        left++;
      }
    }
    bw.write(flasks[start] + " " + flasks[end]);
    bw.flush();
    bw.close();
    br.close();
  }

}