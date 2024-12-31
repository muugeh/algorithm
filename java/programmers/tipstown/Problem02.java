package programmers.tipstown;

// [예상 대진표] https://programmers.co.kr/learn/courses/30/lessons/12985

public class Problem02 {
  public static void main(String[] args) {
    System.out.println(solution(8, 4, 7)); // 3
  }

  public static int solution(int n, int a, int b)
  {
    int answer = 1;
    int hi = Math.max(a, b);
    int lo = Math.min(a, b);

    while((lo + 1) / 2 != (hi + 1) / 2 ){
      lo = (lo + 1) / 2;
      hi = (hi + 1) / 2;
      answer++;
    }

    return answer;
  }

}
