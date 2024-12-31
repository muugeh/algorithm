package sort.boj;

// [좌표 압축] https://www.acmicpc.net/problem/18870

import java.io.*;
import java.util.*;

public class BOJ18870 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    List<Pair> list = new ArrayList<>();
    List<Integer> count = new ArrayList<>();
    for (int order = 0; order < n; order++) {
      list.add(new Pair(Integer.parseInt(st.nextToken()), order));
      count.add(0);
    }
    Collections.sort(list);
    int index = 0;
    int order = -1;
    int before = Integer.MIN_VALUE;
    StringBuilder sb = new StringBuilder();
    while (index < list.size()) {
      Pair now = list.get(index);
      if (now.value > before) {
        order++;
        before = now.value;
      }
      count.set(now.order, order);
      index++;
    }
    for (int o : count) {
      sb.append(o).append(" ");
    }

    bw.write(sb.toString());
    bw.flush();
    bw.close();
    br.close();
  }

  private static class Pair implements Comparable<Pair> {
    int value;
    int order;

    public Pair(int value, int order) {
      this.value = value;
      this.order = order;
    }

    @Override
    public int compareTo(Pair o) {
      return Integer.compare(value, o.value);
    }
  }

}
