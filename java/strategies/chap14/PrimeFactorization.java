package strategies.chap14;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactorization {

  public static void main(String[] args){
    PrimeFactorization primeFactorization = new PrimeFactorization();
    System.out.println(primeFactorization.factorSimple(20));
  }

  List<Integer> factorSimple(int n){
    List<Integer> answer = new ArrayList<>();
    int sqrtn = (int)Math.sqrt(n);
    for(int div = 2; div <= sqrtn; ++div)
      while(n % div == 0){
        n /= div;
        answer.add(div);
      }
    if(n > 1) answer.add(n);
    return answer;
  }
}