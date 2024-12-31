package strategies.chap9;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import util.Input;

public class Packing {

  public static void main(String[] args) {
    Scanner sc = Input.sc(new Packing());

    int testCase = sc.nextInt();

    while (testCase-- > 0) {
      N = sc.nextInt();
      W = sc.nextInt();

      names = new String[N];
      weights = new int[N];
      necessaries = new int[N];
      cache = new int[1001][];
      for(int i = 0; i < 1001; i++){
        cache[i] = new int[N];
        Arrays.fill(cache[i], -1);
      }

      for (int i = 0; i < N; i++) {
        names[i] = sc.next();
        weights[i] = sc.nextInt();
        necessaries[i] = sc.nextInt();
      }

      picked = new LinkedList<>();
      int necessary = pick(0, W);
      reconstruct(W, 0);
      int count = picked.size();
      System.out.println(necessary + " " + count);
      for (String pick : picked) {
        System.out.println(pick);
      }
    }
  }



  static int N;
  static int W;
  static String[] names;
  static int[] weights;
  static int[] necessaries;
  static int[][] cache;
  static Queue<String> picked;

  private static int pick(int item, int capacity) {
    if (item == N) {
      return 0;
    }

    if (cache[capacity][item] != -1) {
      return cache[capacity][item];
    }

    cache[capacity][item] = pick(item + 1, capacity);

    if (capacity >= weights[item]) {
      int pickCurrent = pick(item + 1, capacity - weights[item]) + necessaries[item];
      if (pickCurrent >= cache[capacity][item]) {
        cache[capacity][item] = pickCurrent;
      }
    }

    return cache[capacity][item];
  }

  private static void reconstruct(int capacity, int item) {
    if(item == N) return;
    if(pick(item, capacity) == pick(item + 1, capacity)){
      reconstruct(capacity, item + 1);
    }
    else{
      picked.add(names[item]);
      reconstruct(capacity - weights[item], item + 1);
    }
  }


}
