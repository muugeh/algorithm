package bruteforce.boj;

// [마인크래프트] https://www.acmicpc.net/problem/18111

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ18111 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());
    int[][] grounds = new int[n][m];
    int maxHeight = Integer.MIN_VALUE;
    int minHeight = Integer.MAX_VALUE;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        grounds[i][j] = Integer.parseInt(st.nextToken());
        minHeight = Math.min(minHeight, grounds[i][j]);
        maxHeight = Math.max(maxHeight, grounds[i][j]);
      }
    }
    int minTime = Integer.MAX_VALUE;
    int height = minHeight;
    for (int h = minHeight; h <= height; h++) {
      int time = 0;
      int sum = b;
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          if (grounds[i][j] > h) {
            time += 2 * (grounds[i][j] - h);
            sum += grounds[i][j] - h;
          } else if (grounds[i][j] < h) {
            time += (h - grounds[i][j]);
            sum -= h - grounds[i][j];
          }
        }
      }
      if (sum < 0) break;
      if (time <= minTime) {
        minTime = time;
        height = h;
      }
    }

    System.out.println(minTime + " " + height);
    br.close();
  }
}
