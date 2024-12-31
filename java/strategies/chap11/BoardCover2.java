package strategies.chap11;

import java.io.*;
import java.util.*;

public class BoardCover2 {

  public static class Pair{
    int x, y;

    public Pair(int x, int y){
      this.x = x;
      this.y = y;
    }
  }

  static List<List<Pair>> rotations = new ArrayList<>();

  static int H, W, R, C;
  static char[][] board;
  static char[][][] blocks;

  static int[][] covered;
  static int best;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    while (T-- > 0) {
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      H = Integer.parseInt(st.nextToken());
      W = Integer.parseInt(st.nextToken());
      R = Integer.parseInt(st.nextToken());
      C = Integer.parseInt(st.nextToken());

      board = new char[H][W];
      for (int i = 0; i < H; i++) {
        String line = br.readLine();
        for (int j = 0; j < W; j++)
          board[i][j] = line.charAt(j);
      }

      blocks = new char[4][][];
      for (int i = 0; i < 4; i++)
        blocks[i] = i % 2 == 0 ? new char[R][C] : new char[C][R];


      for (int i = 0; i < R; i++) {
        String line = br.readLine();
        for (int j = 0; j < C; j++)
          blocks[0][i][j] = line.charAt(j);
      }

      generateRotations();
      covered = new int[H][W];
      for (int i = 0; i < H; i++)
        Arrays.fill(covered[i], -1);

      System.out.println(solve());
    }
  }

  private static void rotate() {
    for(int type = 1; type < blocks.length; type++) {
      for (int i = 0; i < blocks[type].length; i++)
        for (int j = 0; j < blocks[type][i].length; j++)
          blocks[type][i][j] = blocks[type - 1][j][blocks[type].length - 1 - i];
    }
  }

  private static void generateRotations(){
    rotations.clear();
    rotate();
    for(int rot = 0; rot < 4; rot++){
      int originY = -1, originX = -1;
      rotations.add(new ArrayList<>());
      for(int i = 0; i < blocks[rot].length; i++)
        for(int j = 0; j < blocks[rot][i].length; j++)
          if(blocks[rot][i][j] == '#'){
            if(originY == -1){
              originY = i;
              originX = j;
            }
            rotations.get(rot).add(new Pair(j - originX, i - originY));
          }
    }
  }

  private static boolean set(int y, int x, int type, int delta) {
    boolean possible = true;
    List<Pair> rotation = rotations.get(type);

    for (Pair pair : rotation) {
      int ny = pair.y + y;
      int nx = pair.x + x;

      if (ny < 0 || ny >= H || nx < 0 || nx >= W) {
        possible = false;
        break;
      }
      else if ((covered[ny][nx] += delta) > 1) {
        possible = false;
      }
    }
    return possible;
  }

  private static void search(int placed) {
    int y = -1, x = -1;
    for (int i = 0; i < H; ++i) {
      for (int j = 0; j < W; ++j)
        if (covered[i][j] == 0) {
          y = i;
          x = j;
          break;
        }
      if (y != -1)
        break;
    }

    if (y == -1) {
      best = Math.max(best, placed);
      return;
    }

    for (int type = 0; type < rotations.size(); ++type) {
      if(set(y, x, type, 1))
        search(placed + 1);
      set(y, x, type, -1);
    }

    covered[y][x] = 1;
    search(placed);
    covered[y][x] = 0;
  }

  static int solve() {
    best = 0;
    for (int i = 0; i < H; i++)
      for(int j = 0; j < W; j++)
          covered[i][j] = (board[i][j] == '#' ? 1 : 0);

    search(0);
    return best;
  }
}
