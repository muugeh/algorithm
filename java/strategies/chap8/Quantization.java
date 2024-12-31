package strategies.chap8;

import java.util.Arrays;
import java.util.Scanner;
import util.Input;

public class Quantization {

  public static void main(String[] args){
    Scanner sc = Input.sc(new Quantization());
    int C = sc.nextInt();

    while(C-- > 0){
      n = sc.nextInt();
      s = sc.nextInt();
      num = new int[n];
      cache = new int[1001];
      Arrays.fill(cache, INF);
      for(int i = 0; i < n; i++){
        num[i] = sc.nextInt();
      }

      quantization(0, 0);
    }
  }

  final static int INF = 987654321;
  static int n;
  static int s;
  static int[] num;
  static int[] cache;

  private static void quantization(int start, int part) {
    if(part == s - 1) return;

    for(int i = start; i < num.length; i++){

    }
  }

  private static void minError(int start, int end){

  }




}
