package strategies.chap14;

import java.util.Arrays;
import java.util.Scanner;

public class Pass486 {

  static int n, lo, hi;
  // 가장 작은 소인수
  static int minFactor[];
  // 소인수 분해에 포함되어 있는 minFactor[i]의 승
  static int minFactorPower[];
  // 약수의 수
  static int factors[];
  static boolean isPrime[];
  final static int TM = 1000 * 1000 * 10;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int C = sc.nextInt();

    while (C-- > 0) {
      n = sc.nextInt();
      lo = sc.nextInt();
      hi = sc.nextInt();

      isPrime = new boolean[TM + 1];
      minFactor = new int[TM + 1];
      factors = new int[TM + 1];
      minFactorPower = new int[TM + 1];

      eratosthenes();
      getFactorsSmart();
      System.out.println(count());
    }
  }

  static int count() {
    int count = 0;
    for (int i = lo; i <= hi; i++) {
      if (factors[i] == n) {
        count++;
      }
    }
    return count;
  }

  static void getFactorsBrute() {
    Arrays.fill(factors, 0);
    for (int div = 1; div <= TM; ++div) {
      for (int multiple = div; multiple <= TM; multiple += div) {
        factors[multiple] += 1;
      }
    }
  }

  private static void getFactorsSmart() {
    factors[1] = 1;
    for (int n = 2; n <= TM; ++n) {
      // 소수인 경우 약수는 2개
      if (minFactor[n] == n) {
        minFactorPower[n] = 1;
        factors[n] = 2;
      }
      // 소수가 아닌 경우, 가장 작은 소인수로 나누 수 m
      // 약수의 수를 응용해 n의 약수를 찾는다.
      else {
        int p = minFactor[n];
        int m = n / p;
        if (p != minFactor[m]) {
          minFactorPower[n] = 1;
        } else {
          minFactorPower[n] = minFactorPower[m] + 1;
        }

        int a = minFactorPower[n];
        factors[n] = (factors[m] / a) * (a + 1);
      }
    }
  }

  public static void eratosthenes(){
    minFactor[0] = minFactor[1] = -1;

    for(int i = 2; i <= TM; i++)
      minFactor[i] = i;

    int sqrtn = (int)(Math.sqrt(TM));
    for(int i = 2; i <= sqrtn; ++i){
      if(minFactor[i] == i){
        for(int j = i*i; j <= TM; j += i)
          if(minFactor[j] == j)
            minFactor[j] = i;
      }
    }
  }

}