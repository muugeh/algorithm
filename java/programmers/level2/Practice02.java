package programmers.level2;

// [최댓값과 최솟값] https://programmers.co.kr/learn/courses/30/lessons/12939

import java.io.IOException;
import java.util.Arrays;

public class Practice02 {
  public static void main(String[] args) throws IOException {
    String s = "1 2 3 4";
    System.out.println(solution(s)); // 1 4
    s = "-1 -2 -3 -4";
    System.out.println(solution(s)); // -4 -1
  }

  private static String solution(String s) {
    int max = Arrays.stream(s.split("\\s")).mapToInt(Integer::parseInt).max().orElse(-1);
    int min = Arrays.stream(s.split("\\s")).mapToInt(Integer::parseInt).min().orElse(-1);
    return min + " " + max;
  }
}
