package strategies.chap11;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Kakuro2 {

  static int N;
  static int Q;
  static int[][] board; // 흰칸 or 검은칸
  static int[][] value; // 각 흰칸에 쓴 숫자
  static int[] sum; // 힌트 칸에 쓰인 숫자
  static int[] length;
  static int[] known;
  static int[][][] hint;
  static int[][][] candidates;


  public static void main(String[] args) throws FileNotFoundException {

    Scanner sc = new Scanner(new File(Kakuro2.class.getResource(".")
                                                   .getPath() + "input/kakuro2.txt"));
    int C = sc.nextInt();

    while (C-- > 0) {

      N = sc.nextInt();
      board = new int[N][N];
      value = new int[N][N];
      length = new int[N*N];
      sum = new int[N*N];
      known = new int[N*N];
      hint = new int[N][N][2];

      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          board[i][j] = sc.nextInt();
        }
      }

      Q = sc.nextInt();

      for (int i = 0; i < Q; i++) {
        int y = sc.nextInt() - 1;
        int x = sc.nextInt() - 1;
        int direction = sc.nextInt();
        int v = sc.nextInt();

        hint[y][x][direction] = v;
        y = y + (direction == 1 ? 1 : 0);
        x = x + (direction == 0 ? 1 : 0);

        while(x < N && y < N){
          if(board[y][x] == 0) break;
          hint[y][x][direction] = v;
          y = y + (direction == 1 ? 1 : 0);
          x = x + (direction == 0 ? 1 : 0);
        }
      }

      System.out.println(hint);
      generateCandidates();
      System.out.println(candidates);

      search();
    }
  }

  static int getSize(int mask) {
    return Integer.bitCount(mask);
  }

  static int getSum(int mask) {
    int sum = 0;
    for (int i = 1; i < 10; i++) {
      if ((mask & 1 << i) == 1 << i) {
        sum += i;
      }
    }
    return sum;
  }

  static int getCandidates(int len, int sum, int known) {
    int allSets = 0;

    for (int set = 0; set < 1024; set += 2) {
      if ((set & known) == known && getSize(set) == len && getSum(set) == sum) {
        allSets |= set;
      }
    }

    return allSets & ~known;
  }


  static void generateCandidates() {
    candidates = new int[10][46][1024];

    for (int set = 0; set < 1024; set += 2) {
      int l = getSize(set), s = getSum(set);

      int subset = set;

      while (true) {
        candidates[l][s][subset] |= (set & ~subset);
        if (subset == 0) {
          break;
        }
        subset = (subset - 1) & set;
      }
    }
  }

  static void put(int y, int x, int val) {
    for (int h = 0; h < 2; ++h) {
      known[hint[y][x][h]] += (1 << val);
    }
    value[y][x] = val;
  }

  static void remove(int y, int x, int val) {
    for (int h = 0; h < 2; ++h) {
      known[hint[y][x][h]] -= (1 << val);
    }
    value[y][x] = 0;
  }

  static int getCandHint(int hint){
    return candidates[length[hint]][sum[hint]][known[hint]];
  }

  static int getCandCoord(int y, int x){
    return getCandHint(hint[y][x][0]) & getCandHint(hint[y][x][1]);
  }

  static void printSolution(){
    for(int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++)
        System.out.println(value[i][j] + " ");
      System.out.println();
    }

  }

  static boolean search(){
    int y = -1, x = -1, minCands = 1023;
    for(int i = 0; i < N; ++i)
      for(int j = 0; j < N; ++j)
        if(board[i][j] == 1 && value[i][j] == 0){
          int cands = getCandCoord(i, j);
          if(getSize(minCands) > getSize(cands)){
            minCands = cands;
            y = i; x = j;
          }
        }
    if(minCands == 0) return false;

    if(y == -1){
      printSolution();
      return true;
    }

    for(int val = 1; val <= 9; ++val)
      if((minCands & (1 << val)) == (1<<val)){
        put(y,x,val);
        if(search()) return true;
        remove(y,x,val);
      }
    return false;
  }

}
