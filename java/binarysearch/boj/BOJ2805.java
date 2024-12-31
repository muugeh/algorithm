package binarysearch.boj;

// [나무 자르기] https://www.acmicpc.net/problem/2805

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2805 {

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
    int n = Integer.parseInt(stringTokenizer.nextToken());
    int m = Integer.parseInt(stringTokenizer.nextToken());
    int[] trees =
        Arrays.stream(bufferedReader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
    Arrays.sort(trees);
    System.out.println(getMaxLength(trees, m));
  }

  private static long getMaxLength(int[] trees, int n) {
    long length = 0;
    long lo = 0;
    long hi = trees[trees.length - 1];
    while (lo <= hi) {
      long mid = (lo + hi) / 2;
      if (getSum(trees, mid) >= n) {
        length = Math.max(length, mid);
        lo = mid + 1;
      } else {
        hi = mid - 1;
      }
    }
    return length;
  }

  private static long getSum(int[] trees, long length) {
    return Arrays.stream(trees).mapToLong(tree -> Math.max(tree - length, 0)).sum();
  }
}
