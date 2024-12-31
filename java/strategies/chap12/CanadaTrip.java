package strategies.chap12;

import java.util.Scanner;
import util.Input;

public class CanadaTrip {

  static int N;
  static int K;
  static int[] L;
  static int[] M;
  static int[] G;

  public static void main(String[] args){
    Scanner sc = Input.sc(new CanadaTrip());

    int T = sc.nextInt();

    while(T-- > 0){
      N = sc.nextInt();
      K = sc.nextInt();
      L = new int[N];
      M = new int[N];
      G = new int[N];

      for(int i = 0; i < N; i++){
        L[i] = sc.nextInt();
        M[i] = sc.nextInt();
        G[i] = sc.nextInt();
      }

      System.out.println(optimize());
    }

  }

  private static boolean decision(int dist) {
    int answer = 0;
    for(int i = 0; i < N; i++)
      if(dist >= L[i] - M[i])
        answer += (Math.min(dist, L[i]) - (L[i] - M[i]))/ G[i] + 1;
      return answer >= K;
  }

  private static int optimize() {
    int lo = -1, hi = 8030001;
    while(lo + 1 < hi){
      int mid = (lo + hi) / 2;
      if(decision(mid))
        hi = mid;
      else
        lo = mid;
    }
    return hi;
  }

}
