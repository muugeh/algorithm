package strategies.chap12;

import java.util.LinkedList;
import java.util.Scanner;
import util.Input;

public class Arctic {

  static int n;
  static double[] x;
  static double[] y;
  static double[][] distance;

  public static void main(String[] args) {
    Scanner sc = Input.sc(new Arctic());
    int C = sc.nextInt();

    while (C-- > 0) {
      n = sc.nextInt();

      x = new double[n];
      y = new double[n];
      distance =  new double[n][n];

      for (int i = 0; i < n; i++) {
        x[i] = sc.nextDouble();
        y[i] = sc.nextDouble();
      }

      calculateDistance();
      System.out.println(optimize());

    }
  }

  private static boolean decision(double d){
    boolean[] visited = new boolean[n];
    visited[0] = true;
    LinkedList<Integer> q = new LinkedList<>();
    q.push(0);

    int seen  = 0;
    while(!q.isEmpty()){
      int here = q.getFirst();
      q.pop();
      ++seen;
      for(int there = 0; there < n; ++there)
        if(!visited[there] && distance[here][there] <= d){
          visited[there] = true;
          q.push(there);
        }
    }
    return seen == n;
  }

  static double optimize(){
    double lo = 0, hi = 1416.00;
    for(int it = 0; it < 100; ++it){
      double mid = (lo + hi) /2;
      if(decision(mid))
        hi = mid;
      else
        lo = mid;
    }
    return hi;
  }

  private static void calculateDistance() {
    for(int i = 0; i < n; i++)
      for(int j = 0; j < n; j++)
        distance[i][j] = Math.sqrt(Math.pow(x[i] - x[j], 2) + Math.pow(y[i] - y[j], 2));
  }


}
