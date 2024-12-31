package binarysearch.boj;

// [가장 긴 증가하는 부분 수열 2] https://www.acmicpc.net/problem/12015

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ12015 {

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(bufferedReader.readLine());
    List<Integer> list = new ArrayList<>();
    list.add(0);
    StringTokenizer st = new StringTokenizer(bufferedReader.readLine());

    for (int i = 0; i < n; i++) {
      int now = Integer.parseInt(st.nextToken());
      if (list.get(list.size() - 1) < now) {
        list.add(now);
      } else {
        int left = 1;
        int right = list.size() - 1;
        while (left < right) {
          int mid = (left + right) / 2;
          if (list.get(mid) < now) {
            left = mid + 1;
          } else {
            right = mid;
          }
        }
        list.set(right, now);
      }
    }
    System.out.println(list.size() - 1);
  }
}
