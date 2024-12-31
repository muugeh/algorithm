package programmers.level2;

// [행렬의 곱셈] https://programmers.co.kr/learn/courses/30/lessons/12949

import java.io.IOException;

public class Practice04 {
  public static void main(String[] args) throws IOException {
    int[][] a = {{1, 2}, {2, 3}};
    int[][] b = {{3, 4}, {5, 6}};
    System.out.println(solution(a, b));
  }

  private static int[][] solution(int[][] arr1, int[][] arr2) {
    return multiply(arr1, arr2);
  }

  private static int[][] multiply(int[][] arr1, int[][] arr2) {
    int[][] arr3 = new int[arr1.length][arr2[0].length];
    for (int i = 0; i < arr1.length; i++) {
      for (int j = 0; j < arr2[0].length; j++) {
        for (int k = 0; k < arr2.length; k++) {
          arr3[i][j] += arr1[i][k] * arr2[k][j];
        }
      }
    }
    return arr3;
  }
}
