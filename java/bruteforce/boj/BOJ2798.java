package bruteforce.boj;

// [블랙잭] https://www.acmicpc.net/problem/2798

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2798 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int[] cards = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    bw.write(String.valueOf(maxValue(n, m, cards)));
    bw.flush();
    bw.close();
    br.close();
  }

  private static int maxValue(int n, int m, int[] cards) {
    int max = 0;
    for(int i = 0; i < n; i++){
      int sum = cards[i];
      for(int j = i + 1; j < n; j++) {
        sum += cards[j];
        for (int k = j + 1; k < n; k++) {
          sum += cards[k];
          if(sum <= m && sum > max){
            max = sum;
          }
          sum -= cards[k];
        }
        sum -= cards[j];
      }
    }
    return max;
  }

}
