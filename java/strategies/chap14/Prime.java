package strategies.chap14;

public class Prime{

  public static void main(String[] args){
    Prime prime = new Prime();

    System.out.println(prime.isPrime(101));
    System.out.println(prime.isPrime(303));
  }

  boolean isPrime(int n){
    if(n <= 1) return false;
    if(n == 2) return true;

    if(n % 2 == 0) return false;

    int sqrtn = (int)Math.sqrt(n);

    for(int div = 3; div <= sqrtn; div+=2)
      if(n % div == 0)
        return false;

    return true;
  }



}