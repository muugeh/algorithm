package programmers.kakao;

import java.util.Arrays;

public class Problem01 {
  public static void main(String[] args) {
    String[][] places = {
      {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
      {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
      {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
      {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
      {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
    };
    System.out.println(Arrays.toString(solution(places)));
  }

  private static final int[] dx = {1, 0, 1, 2, 0, -1};
  private static final int[] dy = {0, 1, 1, 0, 2, 1};
  private static final int PLACE = 5;
  private static final int ROW = 5;
  private static final int COL = 5;

  public static int[] solution(String[][] places) {
    int[] answer = {1, 1, 1, 1, 1};

    for (int k = 0; k < PLACE; k++) {
      for (int i = 0; i < ROW; i++) {
        for (int j = 0; j < COL; j++) {
          if (places[k][i].charAt(j) == 'P') {
            if (checkInfection(places[k], i, j)) {
              answer[k] = 0;
              break;
            }
          }
        }
      }
    }
    return answer;
  }

  private static boolean checkInfection(String[] place, int x, int y) {
    for (int i = 0; i < 6; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];
      if (nx >= 0 && ny >= 0 && nx < ROW && ny < COL && place[nx].charAt(ny) == 'P') {
        if (i < 2) return true;
        if (i == 2 && !(place[nx - 1].charAt(ny) == 'X' && place[nx].charAt(ny - 1) == 'X')) {
          return true;
        }
        if (i == 3 && place[nx - 1].charAt(ny) != 'X') {
          return true;
        }
        if (i == 4 && place[nx].charAt(ny - 1) != 'X') {
          return true;
        }
        if (i == 5 && !(place[nx + 1].charAt(ny) == 'X' && place[nx].charAt(ny - 1) == 'X')) {
          return true;
        }
      }
    }
    return false;
  }
}
