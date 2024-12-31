package strategies.chap6;

import java.util.LinkedList;
import java.util.Scanner;
import util.Input;

public class SalesMan {

  public static void main(String[] args) {
    Scanner sc = Input.sc(new SalesMan());
    int C = sc.nextInt();


    while(C-- > 0){
      n = sc.nextInt();
      dist = new double[n][n];
      for(int i = 0; i < n; i++)
        for(int j = 0; j < n; j++)
          dist[i][j] = sc.nextDouble();


      System.out.println(shortestPath(new LinkedList<>(), new boolean[n], 0));

    }
  }
  static int MAX = 8;
  // 도시의 수
  static int n;
  // 두 도시간이 거리를 저장하는 배열
  static double[][] dist;

  static double shortestPath(LinkedList<Integer> path, boolean[] visited, double currentLength) {
    if (path.size() == n) {
      return currentLength + dist[path.get(0)][path.getLast()];
    }

    double answer = Double.MAX_VALUE;

    for (int next = 0; next < n; ++next) {
      if (visited[next]) {
        continue;
      }
      int here = 0;
      if(!path.isEmpty())
        here = path.getLast();
      path.push(next);
      visited[next] = true;
      double cand = shortestPath(path, visited,
                                 currentLength + dist[here][next]);
      answer = Math.min(answer, cand);
      visited[next] = false;
      path.pop();
    }
    return answer;
  }

  static double INF = 987654321;
  static double[][] cache = new double[MAX][MAX];

  static double shortestPath2(int here, int visited) {
    if (visited == (1 << n) - 1) {
      return dist[here][0];
    }

    double answer = cache[here][visited];
    if(answer >= 0) return answer;

    answer = INF;

    for (int next = 0; next < n; ++next) {
      if((visited & (1 << next)) > 0) continue;
      double cand = dist[here][next] +
          shortestPath2(next, visited + (1<<next));
      answer = Math.min(answer, cand);
    }
    return answer;
  }
}
