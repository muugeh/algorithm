package strategies.chap17;

import java.util.Arrays;
import java.util.Scanner;

public class Christmas {

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int C = sc.nextInt();
    while(C-- > 0){
     int N = sc.nextInt();
     int K = sc.nextInt();
     int[] D = new int[N+1];

     for(int i = 1; i < N+1; i++){
       D[i] = sc.nextInt();
     }

     int[] partialSum = new int[N+1];
     partialSum[1] = D[1] % K;
     for(int i = 2; i < N + 1; i++){
       partialSum[i] = (partialSum[i-1] + D[i]) % K;
     }

     System.out.println(waysToBuy(partialSum, K));
     System.out.println(maxBuys(partialSum, K));
    }
  }

  private static int count(int[] partialSum, int k) {
    int n = partialSum.length;
    int count = 0;
    for(int i = 0; i < n; i++)
      for(int j = i; j < n; j++) {
        if(i == 0){
          if(partialSum[j] % k == 0) count++;
        }
        else if ((partialSum[j] - partialSum[i - 1]) % k == 0)
          count++;
      }
    return count;
  }

  private static int waysToBuy(int[] psum, int k){
    int MOD = 20091101;
    int ret = 0;
    int[] count = new int[k];

    for (int j : psum)
      count[j]++;

    for(int i = 0; i < k; i++)
      if(count[i] >= 2)
        ret = (ret + (count[i] * (count[i] - 1)) / 2) % MOD;

    return ret;
  }

  static int maxBuys(int[] psum, int k){
    int[] ret = new int[psum.length];
    int[] prev = new int[k];
    Arrays.fill(prev, -1);

    for(int i = 0; i < psum.length; i++){
      if(i > 0)
        ret[i] = ret[i-1];
      else
        ret[i] = 0;

      int loc = prev[psum[i]];
      if(loc != -1) ret[i] = Math.max(ret[i], ret[loc] + 1);
      prev[psum[i]] = i;
    }
    return ret[psum.length - 1];
  }

}