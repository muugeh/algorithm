package bruteforce.boj;

// [덩치] https://www.acmicpc.net/problem/7568

import java.io.*;
import java.util.*;

public class BOJ7568 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(br.readLine());
    int[] rank = new int[n];
    Arrays.fill(rank, 1);
    int[] weight = new int[n];
    int[] height = new int[n];
    for(int i = 0; i < n; i++){
      StringTokenizer st = new StringTokenizer(br.readLine());
      weight[i] = Integer.parseInt(st.nextToken());
      height[i] = Integer.parseInt(st.nextToken());
    }
    for(int i = 0; i < n; i++){
      int h = height[i];
      int w = weight[i];
      for(int j = 0; j < n; j++){
        if(h < height[j] && w < weight[j]){
          rank[i]++;
        }
      }
      bw.write(rank[i] + " ");
    }
    bw.flush();
    bw.close();
    br.close();
  }
}
