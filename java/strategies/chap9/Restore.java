package strategies.chap9;

import java.util.Arrays;
import java.util.Scanner;
import util.Input;

public class Restore {

  public static void main(String[] args) {
    Scanner sc = Input.sc(new Restore());
    int C = sc.nextInt();
    while (C-- > 0) {
      k = sc.nextInt();
      part = new String[k];
      for (int i = 0; i < k; i++) {
        part[i] = sc.next();
      }

      cache = new int[15][1 << 15];

      for (int[] ints : cache) {
        Arrays.fill(ints, -1);
      }

      overlap();

      //System.out.println(restore(0, 0));
      System.out.println(reconstruct(0, 0));
    }
  }

  static int k;
  static String[] part;
  static int[][] cache;
  static int[][] overlap = new int[15][15];

  private static void overlap() {
    for (int i = 0; i < part.length; i++) {
      for (int j = 0; j < part.length; j++) {
        if (i == j) {
          continue;
        }
        int count = 0;

        if (part[i].contains(part[j])) {
          overlap[i][j] = part[j].length();
          break;
        }
        if(part[j].contains(part[i])){
          overlap[i][j] = part[i].length();
          break;
        }

        int length = Math.min(part[i].length(), part[j].length());
        for (int u = 1; u <= length; u++) {
          if (part[i].substring(part[i].length() - u)
                     .equals(part[j].substring(0, u))) {
            count = u;
          }
        }
        overlap[i][j] = count;
      }
    }
  }


  private static int restore(int last, int used) {
    if (used == (1 << k) - 1) {
      return 0;
    }

    if (cache[last][used] != -1) {
      return cache[last][used];
    }

    cache[last][used] = 0;
    for (int next = 0; next < k; ++next) {
      if ((used & (1 << next)) == 0) {
        //System.out.println(last + " " + next + " " + used);
        int cand = 0;
        if(used == 0) cand = restore(next, used + (1<<next));
        else cand = overlap[last][next] + restore(next, used + (1 << next));
        cache[last][used] = Math.max(cache[last][used], cand);
        //System.out.println("CACHE : " + " " + last + " " + used + " " + cache[last][used]);
      }
    }

    return cache[last][used];
  }

  static String reconstruct(int last, int used) {
    if (used == (1 << k) - 1) {
      return "";
    }

    for (int next = 0; next < k; ++next) {
      if ((used & (1 << next)) > 0) {
        continue;
      }

      int ifUsed = restore(next, used + (1 << next)) + overlap[last][next];
      if (restore(last, used) == ifUsed) {
        System.out.println(ifUsed + " " + last + " " + next + " " + overlap[last][next] + " "+ part[next].substring(0, overlap[last][next]));
        return (part[next].substring(overlap[last][next]) + reconstruct(next, used + (1 << next)));
      }
    }

    return "#";
  }

}