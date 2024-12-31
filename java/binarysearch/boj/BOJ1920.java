package binarysearch.boj;

// [수 찾기] https://www.acmicpc.net/problem/1920

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ1920 {

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(bufferedReader.readLine());
    int[] a =
        Arrays.stream(bufferedReader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
    int m = Integer.parseInt(bufferedReader.readLine());
    int[] numbers =
        Arrays.stream(bufferedReader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
    Arrays.sort(a);
    StringBuilder stringBuilder = new StringBuilder();
    for (int number : numbers) {
      stringBuilder.append(contains(a, number) ? 1 : 0).append("\n");
    }
    System.out.println(stringBuilder);
  }

  private static boolean contains(int[] a, int n) {
    int lo = 0;
    int hi = a.length - 1;
    while (lo <= hi) {
      int mid = (lo + hi) / 2;
      if (a[mid] == n) return true;
      else if (a[mid] > n) {
        hi = mid - 1;
      } else {
        lo = mid + 1;
      }
    }
    return false;
  }
}
