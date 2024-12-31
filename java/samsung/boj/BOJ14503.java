package samsung.boj;

// [로봇 청소기] https://www.acmicpc.net/problem/14503

import java.io.*;
import java.util.StringTokenizer;

public class BOJ14503 {

  private static final int[] dy = {-1, 0, 1, 0};
  private static final int[] dx = {0, 1, 0, -1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    int r = Integer.parseInt(st.nextToken());
    int c = Integer.parseInt(st.nextToken());
    int d = Integer.parseInt(st.nextToken());

    boolean[][] map = new boolean[n][m];
    boolean[][] visited = new boolean[n][m];


    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        map[i][j] = st.nextToken().equals("1");
      }
    }

    int clean = 0;

    while (true) {
      boolean blocked = true;
      if (!map[r][c] && !visited[r][c]) {
        visited[r][c] = true;
        clean++;
      }

      for (int i = 1; i <= 4; i++) {
        d = (d + 3) % 4;
        int ny = dy[d] + r;
        int nx = dx[d] + c;
        if (ny >= 0 && nx >= 0 & ny < n && nx < m) {
          if (!map[ny][nx] && !visited[ny][nx]) {
            blocked = false;
            r = ny;
            c = nx;
            break;
          }
        }
      }

      if (blocked) {
        int nd = (d + 2) % 4;
        r += dy[nd];
        c += dx[nd];
        if (r >= 0 && c >= 0 && r < n && c < m){
          if(map[r][c])
            break;
        }
      }
    }

    bw.write(String.valueOf(clean));
    bw.flush();
    bw.close();
    br.close();
  }
}