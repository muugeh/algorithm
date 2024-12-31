package sort.boj;

// [좌표 정렬하기] https://www.acmicpc.net/problem/11650

import java.io.*;
import java.util.*;

public class BOJ11650 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(br.readLine());
    List<Point> points = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      points.add(new Point(x, y));
    }
    Collections.sort(points);
    for (Point point : points) {
      bw.write(point + "\n");
    }
    bw.flush();
    bw.close();
    br.close();
  }

  private static class Point implements Comparable<Point> {
    int x, y;

    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public int compareTo(Point o) {
      if (x > o.x)
        return 1;
      else if (x < o.x)
        return -1;
      else {
        return Integer.compare(y, o.y);
      }
    }

    @Override
    public String toString() {
      return x + " " + y;
    }
  }
}