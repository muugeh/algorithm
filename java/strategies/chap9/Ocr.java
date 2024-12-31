package strategies.chap9;

import java.util.Arrays;
import java.util.Scanner;
import util.Input;

public class Ocr {

  public static void main(String[] args) {
    Scanner sc = Input.sc(new Ocr());
    int C = sc.nextInt();
    while (C-- > 0) {
      m = sc.nextInt();
      q = sc.nextInt();
      words = new String[m];
      T = new double[m+1][m];
      for (int i = 0; i < m+1; i++) {
        for(int j = 0; j < m; j++) {
          T[i][j] = sc.nextDouble();
        }
      }

      for (int i = 0; i < m; i++) {
        for (int j = 0; j < m; j++) {
          T[i][j] = sc.nextInt();
        }
      }

      for (int i = 0; i < m; i++) {
        for (int j = 0; j < m; j++) {
          M[i][j] = sc.nextInt();
        }
      }

      n = sc.nextInt();
      cache = new double[n][m];
      for(int i = 0; i < n; i++){
        Arrays.fill(cache[i], -1);
      }
      for (int i = 0; i < q; i++) {
        sentence[i] = sc.next();
      }
      int start = -1;
      for(int i = 0; i < n; i++){
        if(words[i].equals(sentence[i])){
          start = i;
          break;
        }
      }
      System.out.println(recognize(0, start));
    }
  }



  static int m;
  static int q;
  static String[] words;
  static double[][] T;
  static double[][] M;
  static String[] sentence;
  static double[][] cache;
  static int n;

  private static double recognize(int order, int before) {
    if(order == n) return 1;

    if(cache[order][before] != -1) return cache[order][before];

    cache[order][before] = -1e200;


    return 0;

  }
}
