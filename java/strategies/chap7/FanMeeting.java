package strategies.chap7;

import java.io.File;
import java.util.Scanner;

public class FanMeeting {

  public static void main(String[] args) throws Exception {
    File file = new File("./src/goo/chap7/input/fanmeeting.txt");
    Scanner sc = new Scanner(file);

    int C = sc.nextInt();
    while (C-- > 0) {
      String members = sc.next();
      String fans = sc.next();

      System.out.println(fanMeeting(members, fans));
    }
  }

  private static int fanMeeting(String members, String fans) {
    int N = members.length();
    int M = fans.length();
    int[] A = new int[N];
    int[] B = new int[M];

    for (int i = 0; i < N; i++) {
      A[i] = members.charAt(i) == 'M' ? 1 : 0;
    }
    for (int i = 0; i < M; i++) {
      B[M - i - 1] = fans.charAt(i) == 'N' ? 1 : 0;
    }

//    ArrayList<Integer> C = karatsuba(A, B);
//    int allHugs = 0;
//    for (int i = N - 1; i < M; ++i) {
//      if (C.get(i) == 0)
//        ++allHugs;
//    }

//    return allHugs;
    return 12;
  }


}
