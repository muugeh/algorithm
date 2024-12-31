package graph.boj;

// [최소비용 구하기 2] https://www.acmicpc.net/problem/11779

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ11779 {

  private static final List<List<City>> buses = new ArrayList<>();
  private static final PriorityQueue<City> queue = new PriorityQueue<>(Comparator.reverseOrder());
  private static int n;
  private static final int INF = 1000 * 100000 + 1;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    int m = Integer.parseInt(br.readLine());
    for (int i = 0; i <= n; i++) buses.add(new ArrayList<>());
    for (int i = 0; i < m; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int from = Integer.parseInt(st.nextToken());
      int to = Integer.parseInt(st.nextToken());
      int distance = Integer.parseInt(st.nextToken());
      buses.get(from).add(new City(to, distance));
    }
    StringTokenizer st = new StringTokenizer(br.readLine());
    int from = Integer.parseInt(st.nextToken());
    int to = Integer.parseInt(st.nextToken());
    System.out.println(minPath(from, to));
  }

  private static String minPath(int from, int to) {
    int[] distances = new int[n + 1];
    int[] paths = new int[n + 1];

    Arrays.fill(distances, INF);

    queue.clear();
    queue.offer(new City(from, 0));
    paths[from] = -1;
    distances[from] = 0;

    while (!queue.isEmpty()) {
      City city = queue.poll();
      int here = city.city;
      int distance = city.distance;

      if (distances[here] < distance) continue;

      for (int i = 0; i < buses.get(here).size(); i++) {
        City next = buses.get(here).get(i);
        int there = next.city;
        int nextDistance = next.distance + distance;

        if (distances[there] > nextDistance) {
          distances[there] = nextDistance;
          paths[there] = here;
          queue.offer(new City(there, nextDistance));
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    List<Integer> minPath = new LinkedList<>();
    int target = to;
    while (target != -1) {
      minPath.add(0, target);
      target = paths[target];
    }
    sb.append(distances[to]).append("\n").append(minPath.size()).append("\n");
    for (int route : minPath) {
      sb.append(route).append(" ");
    }

    return sb.toString();
  }

  private static class City implements Comparable<City> {
    int city;
    int distance;

    public City(int city, int distance) {
      this.city = city;
      this.distance = distance;
    }

    @Override
    public int compareTo(City o) {
      return distance - o.distance;
    }
  }
}
