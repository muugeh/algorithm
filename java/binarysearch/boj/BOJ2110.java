package binarysearch.boj;

// [공유기 설치] https://www.acmicpc.net/problem/2110

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2110 {

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
    int n = Integer.parseInt(stringTokenizer.nextToken());
    int c = Integer.parseInt(stringTokenizer.nextToken());
    int[] wifis = new int[n];
    for (int i = 0; i < n; i++) {
      wifis[i] = Integer.parseInt(bufferedReader.readLine());
    }
    Arrays.sort(wifis);
    System.out.println(getMaxDistance(wifis, c));
  }

  private static long getMaxDistance(int[] wifis, int c) {
    long distance = 0;
    int lo = 0;
    int hi = wifis[wifis.length - 1];
    while (lo <= hi) {
      int mid = (lo + hi) / 2;
      if (isPossible(wifis, mid, c)) {
        distance = Math.max(distance, mid);
        lo = mid + 1;
      } else {
        hi = mid - 1;
      }
    }
    return distance;
  }

  private static boolean isPossible(int[] wifis, int length, int c) {
    int count = 1;
    int lowerBound = wifis[0] + length;
    for (int i = 1; i < wifis.length; i++) {
      if (wifis[i] >= lowerBound) {
        count++;
        lowerBound = wifis[i] + length;
      }
    }
    return count >= c;
  }
}
