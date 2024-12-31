package strategies.chap14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Potion {

  static int n;
  static int[] r;
  static int[] p;

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    int C = Integer.parseInt(bufferedReader.readLine());
    while (C-- > 0) {
      n = Integer.parseInt(bufferedReader.readLine()
                                         .trim());
      r = new int[n];
      p = new int[n];

      StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
      for (int i = 0; i < n; i++) {
        r[i] = Integer.parseInt(stringTokenizer.nextToken());
      }

      stringTokenizer = new StringTokenizer(bufferedReader.readLine());
      for (int i = 0; i < n; i++) {
        p[i] = Integer.parseInt(stringTokenizer.nextToken());
      }

      System.out.println(solveEuclid(r, p));
    }
  }

  private static List<Integer> solve(int[] recipe, int[] put) {
    int[] answer = new int[n];

    for (int i = 0; i < n; i++) {
      answer[i] = Math.max(recipe[i] - put[i], 0);
      put[i] += answer[i];
    }

    while (true) {
      boolean ok = true;
      for (int i = 0; i < n; ++i) {
        for (int j = 0; j < n; ++j) {
          int required = (put[i] * recipe[j] + recipe[i] - 1) / recipe[i];
          if (required > put[j]) {
            answer[j] += required - put[j];
            put[j] = required;
            ok = false;
          }
        }
      }
      if (ok) {
        break;
      }
    }

    return Arrays.stream(answer)
                 .boxed()
                 .collect(Collectors.toList());
  }

  static int gcd(int a, int b) {
    return b == 0 ? a : gcd(b, a % b);
  }

  static int ceil(int a, int b){
    return (a + b - 1) / b;
  }

  static List<Integer> solveEuclid(int[] recipe, int[] put){
    int b = recipe[0];
    for(int i = 1; i < n; i++) b = gcd(b, recipe[i]);

    int a = b;
    for(int i = 0; i < n; i++)
      a = Math.max(a, ceil(put[i] * b, recipe[i]));

    int[] answer = new int[n];
    for(int i = 0; i <n; i++)
      answer[i] = recipe[i] * a / b - put[i];

    return Arrays.stream(answer)
                 .boxed()
                 .collect(Collectors.toList());
  }


}