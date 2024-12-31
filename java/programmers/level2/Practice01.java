package programmers.level2;

// [다음 큰 숫자] https://programmers.co.kr/learn/courses/30/lessons/12911

import java.io.IOException;

public class Practice01 {
  public static void main(String[] args) throws IOException {
    int n = 78;
    System.out.println(solution(n)); // 83
    n = 15;
    System.out.println(solution(n)); // 23
  }

  private static int solution(int n) {
    int answer = n + 1;
    int count = Integer.bitCount(n);
    while(count != Integer.bitCount(answer)){
      answer++;
    }
    return answer;
  }

}
