package programmers.level2;

// [가장 큰 정사각형 찾기] https://programmers.co.kr/learn/courses/30/lessons/12905

import java.util.Arrays;

public class Practice05 {
  public static void main(String[] args) {

    int[][] board = {{0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0}};
    System.out.println(solution(board));
  }

  static int[][] square;
  private static int solution(int[][] board) {
    int max = 0;
    square = new int[board.length][board[0].length];
    for(int[] row : square){
      Arrays.fill(row, -1);
    }

    for(int i = 0; i < board.length; i++){
      for(int j = 0; j < board[0].length; j++){
        max = Math.max(max, getMaxSquare(board, i, j));
      }
    }

    return max * max;
  }

  public static int getMaxSquare(int[][] board, int y, int x){
    if(square[y][x] != -1) return square[y][x];

    if(board[y][x] == 0) return square[y][x] = 0;

    int size = 1;
    if(y + 1 < board.length && x + 1 < board[0].length){
      int down =  getMaxSquare(board, y + 1, x);
      int right =  getMaxSquare(board, y, x + 1);
      int arrow =  getMaxSquare(board, y + 1, x + 1);
      size += Math.min(Math.min(down, right), arrow);
    }

    return square[y][x] = size;
  }

}
