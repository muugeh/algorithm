package divideandconquer.boj;

// [히스토그램에서 가장 큰 직사각형] https://www.acmicpc.net/problem/6549

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ6549 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String testCase;
    while (!(testCase = br.readLine()).equals("0")) {
      StringTokenizer st = new StringTokenizer(testCase);
      int n = Integer.parseInt(st.nextToken());
      ArrayList<Long> board = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        board.add(Long.parseLong(st.nextToken()));
      }
      System.out.println(fence(board));
    }
  }

  private static long fence(List<Long> board) {
    if (board.size() == 1) return board.get(0);

    int lo = 0;
    int hi = board.size();

    int mid = (lo + hi) / 2;

    long leftMax = fence(board.subList(lo, mid));
    long rightMax = fence(board.subList(mid, hi));

    long minHeight = Long.MAX_VALUE;
    long totalMax = 0;
    for (int i = 0; i < board.size(); i++) {
      long height = board.get(i);
      minHeight = Math.min(minHeight, height);
      totalMax = Math.max(totalMax, minHeight * (i + 1));
    }
    long answer = Math.max(totalMax, Math.max(leftMax, rightMax));

    int left = mid - 1;
    int right = mid;

    long height = Math.min(board.get(left), board.get(right));
    answer = Math.max(answer, height * (right - left + 1));

    while (left > lo && right < hi) {
      if (right < hi - 1 && (lo == left - 1 || board.get(left - 1) < board.get(right + 1))) {
        ++right;
        height = Math.min(height, board.get(right));
      } else {
        --left;
        height = Math.min(height, board.get(left));
      }
      answer = Math.max(answer, height * (right - left + 1));
    }
    return answer;
  }
}
