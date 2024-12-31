package strategies.chap14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Eratosthenes {

  int n;
  boolean[] isPrime;
  int[] minFactor;

  public Eratosthenes(int n) {
    this.n = n;
    isPrime = new boolean[n + 1];
    minFactor = new int[n + 1];
    Arrays.fill(isPrime, true);
  }

  public static void main(String[] args) {
    Eratosthenes eratosthenes = new Eratosthenes(100);
    eratosthenes.eratosthenes();

    for (int i = 1; i < 100; i++) {
      System.out.print(eratosthenes.isPrime[i] ? i  + " " : "  ");
      if(i % 10 == 0) System.out.println();
    }
  }

  public void eratosthenes() {
    isPrime[0] = isPrime[1] = false;
    int sqrtn = (int) Math.sqrt(n);
    for (int i = 2; i <= sqrtn; i++) {
      if (isPrime[i]) {
        for (int j = i * i; j <= n; j += i) {
          isPrime[j] = false;
        }
      }
    }
  }

  public void eratosthenes2(){
    minFactor[0] = minFactor[1] = -1;

    for(int i = 2; i <= n; i++)
      minFactor[i] = i;

    int sqrtn = (int)(Math.sqrt(n));
    for(int i = 2; i <= sqrtn; ++i){
      if(minFactor[i] == i){
        for(int j = i*i; j <= i; j += i)
          if(minFactor[j] == j)
            minFactor[j] = i;
      }
    }

  }

  public List<Integer> factor(int n){
    List<Integer> answer = new ArrayList<>();
    while(n > 1){
      answer.add(minFactor[n]);
      n /= minFactor[n];
    }
    return answer;
  }

}