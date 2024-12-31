package binarysearch.boj;

// [랜선 자르기] https://www.acmicpc.net/problem/1654

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1654 {

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
    int k = Integer.parseInt(stringTokenizer.nextToken());
    int n = Integer.parseInt(stringTokenizer.nextToken());
    long[] wires = new long[k];
    for (int i = 0; i < k; i++) {
      wires[i] = Long.parseLong(bufferedReader.readLine());
    }
    Arrays.sort(wires);
    System.out.println(getMaxLength(wires, n));
  }

  private static long getMaxLength(long[] wires, int n) {
    long length = 1;
    long lo = 1;
    long hi = wires[wires.length - 1];
    while (lo <= hi) {
      long mid = (lo + hi) / 2;
      if (getCount(wires, mid) >= n) {
        length = Math.max(length, mid);
        lo = mid + 1;
      } else {
        hi = mid - 1;
      }
    }
    return length;
  }

  private static long getCount(long[] wires, long length) {
    return Arrays.stream(wires).map(wire -> wire / length).sum();
  }
}
