package programmers.maester;

// 게임 맵 최단 거리 https://programmers.co.kr/learn/courses/30/lessons/1844

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Problem02 {

  private static final int[] dy = {-1, 0, 1, 0};
  private static final int[] dx = {0, -1, 0, 1};
  private static final int MAX = 10001;

  public static void main(String[] args) {
    int[][] maps = {
      {1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}
    };
    System.out.println(solution(maps));
  }

  public static int solution(int[][] maps) {
    int[][] dp = new int[maps.length][maps[0].length];
    for (int[] row : dp) {
      Arrays.fill(row, MAX);
    }
    dp[0][0] = 1;
    Queue<Node> queue = new ArrayDeque<>();
    queue.add(new Node(0, 0));
    while (!queue.isEmpty()) {
      Node node = queue.poll();
      for (int i = 0; i < 4; i++) {
        int ny = node.y + dy[i];
        int nx = node.x + dx[i];
        if (ny >= 0 && ny < maps.length && nx >= 0 && nx < maps[0].length) {
          if (maps[ny][nx] != 0 && dp[ny][nx] == MAX) {
            dp[ny][nx] = dp[node.y][node.x] + 1;
            queue.add(new Node(ny, nx));
          }
        }
      }
    }

    int answer = -1;
    if (dp[maps.length - 1][maps[0].length - 1] != MAX)
      answer = dp[maps.length - 1][maps[0].length - 1];
    return answer;
  }

  static class Node {
    int y, x;

    public Node(int y, int x) {
      this.y = y;
      this.x = x;
    }
  }
}
