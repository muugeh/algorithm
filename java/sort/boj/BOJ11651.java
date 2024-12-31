package sort.boj;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ11651 {

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
    for(Point point : points){
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
      if (y > o.y)
        return 1;
      else if (y < o.y)
        return -1;
      else {
        return Integer.compare(x, o.x);
      }
    }

    @Override
    public String toString() {
      return x + " " + y;
    }
  }

}


