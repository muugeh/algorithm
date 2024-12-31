package strategies.chap13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import util.Input;

class Point {

  public double y, x;

  public Point(double y, double x) {
    this.y = y;
    this.x = x;
  }
}

class Line {

  public Point first, second;

  public Line(Point first, Point second) {
    this.first = first;
    this.second = second;
  }
}

public class Fossil {

  static int n, m;
  static List<Point> hull1 = new ArrayList<>();
  static List<Point> hull2 = new ArrayList<>();

  static List<Line> upper = new ArrayList<>();
  static List<Line> lower = new ArrayList<>();


  public static void main(String[] args) {
    Scanner sc = Input.sc(new Fossil());

    int C = sc.nextInt();
    while (C-- > 0) {
      n = sc.nextInt();
      m = sc.nextInt();

      hull1.clear();
      hull2.clear();
      upper.clear();
      lower.clear();

      for (int i = 0; i < n; i++) {
        double y = sc.nextDouble();
        double x = sc.nextDouble();
        hull1.add(new Point(y, x));
      }

      for (int i = 0; i < m; i++) {
        double y = sc.nextDouble();
        double x = sc.nextDouble();
        hull2.add(new Point(y, x));
      }

      decompose(hull1);
      decompose(hull2);
      System.out.println(solve());
    }
  }

  private static void decompose(List<Point> hull) {
    int n = hull.size();
    for (int i = 0; i < n; i++) {
      if (hull.get(i).x < hull.get((i + 1) % n).x) {
        lower.add(new Line(hull.get(i), hull.get((i + 1) % n)));
      } else if (hull.get(i).x > hull.get((i + 1) % n).x) {
        upper.add(new Line(hull.get(i), hull.get((i + 1) % n)));
      }
    }
  }

  private static boolean between(Point a, Point b, double x) {
    return (a.x <= x && x <= b.x) || (b.x <= x && x <= a.x);
  }

  static double at(Point a, Point b, double x) {
    double dy = b.y - a.y, dx = b.x - a.x;
    return a.y + dy * (x - a.x) / dx;
  }

  static double vertical(double x) {
    double minUp = 1e20, maxLow = -1e20;
    for (Line line : upper) {
      if (between(line.first, line.second, x)) {
        minUp = Math.min(minUp, at(line.first, line.second, x));
      }
    }

    for (Line line : lower) {
      if (between(line.first, line.second, x)) {
        maxLow = Math.max(maxLow, at(line.first, line.second, x));
      }
    }

    return minUp - maxLow;
  }

  static double solve() {
    Point lox1 = Collections.min(hull1, (p1, p2) -> (int) (p1.x - p2.x));
    Point lox2 = Collections.min(hull2, (p1, p2) -> (int) (p1.x - p2.x));
    Point hix1 = Collections.max(hull1, (p1, p2) -> (int) (p1.x - p2.x));
    Point hix2 = Collections.max(hull2, (p1, p2) -> (int) (p1.x - p2.x));

    double lo = Math.max(lox1.x, lox2.x);
    double hi = Math.min(hix1.x, hix2.x);

    if (hi < lo) {
      return 0;
    }

    for (int iter = 0; iter < 100; ++iter) {
      double aab = (lo * 2 + hi) / 3.0;
      double abb = (lo + hi * 2) / 3.0;
      if (vertical(aab) < vertical(abb)) {
        lo = aab;
      } else {
        hi = abb;
      }
    }
    return Math.max(0.0, vertical(hi));
  }


}