package strategies.chap8;

import java.util.Arrays;
import java.util.Scanner;
import util.Input;

public class Dunibal {

  public static void main(String[] args) {
    Scanner sc = Input.sc(new Dunibal());
    int testCase = sc.nextInt();
    while (testCase-- > 0) {
      n = sc.nextInt();
      days = sc.nextInt();
      prison = sc.nextInt();
      map = new int[n][n];
      cache = new double[days+1][n];
      for (int i = 0; i <= days; i++) {
        Arrays.fill(cache[i], -1);
      }

      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          map[i][j] = sc.nextInt();
        }
      }

      t = sc.nextInt();
      villages = new int[t];

      connected = getConnected(map);

      for (int i = 0; i < t; i++) {
        villages[i] = sc.nextInt();
        dunibal(villages[i], days);
      }

      for(int i = 0; i < t; i++){
        double answer = cache[days][villages[i]];
        if(answer == -1) answer = 0;
        System.out.print(answer + " ");
      }
      System.out.println();
    }

  }

  static int n;
  static int days;
  static int prison;
  static int[][] map;
  static int t;
  static int[] villages;
  static double[] connected;
  static double[][] cache;

  private static double dunibal(int loc, int day) {
    if (day == 0) {
      return loc == prison ? 1 : 0;
    }

    if (cache[day][loc] != -1) {
      return cache[day][loc];
    }

    cache[day][loc] = 0;

    for (int i = 0; i < n; i++) {
      if (i == loc) {
        continue;
      }
      if (map[loc][i] == 1) {
        cache[day][loc] += dunibal(i, day - 1) / connected[i];
      }
    }
    return cache[day][loc];
  }

  public static double[] getConnected(int[][] map){
    double[] connected = new double[map.length];
    for(int i = 0; i < map.length; i++)
      for(int j = 0; j < map[i].length; j++)
        if(map[i][j] == 1) connected[i] += 1;

    return connected;
  }


}
