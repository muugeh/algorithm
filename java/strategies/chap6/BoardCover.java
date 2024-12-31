package strategies.chap6;

import java.util.Scanner;

public class BoardCover {

  public static void main(String[] args) throws Exception {

    Scanner sc = new Scanner(System.in);
    int C = sc.nextInt();

    while (C-- > 0) {
      int H = sc.nextInt();
      int W = sc.nextInt();
      int[][] board = new int[H][W];

      String line;
      for (int i = 0; i < H; i++) {
        line = sc.next()
                 .replace("#", "1")
                 .replace(".", "0");
        for (int j = 0; j < W; j++) {
          board[i][j] = Integer.parseInt(line.substring(j, j + 1));
        }
      }
      System.out.println(cover(board));
    }
  }

  static final int[][][] coverType = {
      {{0, 0}, {1, 0}, {0, 1}},
      {{0, 0}, {0, 1}, {1, 1}},
      {{0, 0}, {1, 0}, {1, 1}},
      {{0, 0}, {1, 0}, {1, -1}}
  };

  private static int cover(int[][] board) {
    int x = -1, y = -1;

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (board[i][j] == 0) {
          y = i;
          x = j;
          break;
        }
      }
      if (y != -1) {
        break;
      }
    }

    if (y == -1) {
      return 1;
    }

    int answer = 0;

    for (int type = 0; type < 4; type++) {
      if (set(board, y, x, type, 1)) {
        answer += cover(board);
      }
      set(board, y, x, type, -1);
    }

    return answer;
  }

  // board의 (y, x)를 type번으로 덮거나 덮던 블록을 없앱니다.
  // delta = 1이면 덮고, -1이면 없앱니다
  // 겹치거나 검은 칸을 덮을 때 false를 반환합니다.
  static boolean set(int[][] board,
                     int y, int x, int type, int delta) {

    boolean ok = true;
    for (int i = 0; i < 3; i++) {
      final int ny = y + coverType[type][i][0];
      final int nx = x + coverType[type][i][1];
      if (ny < 0 || ny >= board.length ||
          nx < 0 || nx >= board[0].length) {
        ok = false;
      } else if ((board[ny][nx] += delta) > 1) {
        ok = false;
      }
    }
    return ok;
  }

}
