package strategies.chap24;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Mordor {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int C = Integer.parseInt(br.readLine());
    while(C-- > 0){
      StringTokenizer st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      int Q = Integer.parseInt(st.nextToken());
      int[] h = new int[N];
      st = new StringTokenizer(br.readLine());
      for(int i = 0; i < N; i++)
        h[i] = Integer.parseInt(st.nextToken());
      for(int i = 0; i < Q; i++) {
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        bw.write(solve(h, a, b) + "\n");
        bw.flush();
      }
    }
  }

  private static int solve(int[] h, int a, int b){
    RMQ rmq = new RMQ(h);
    int min = rmq.query(a, b);
    for(int i = 0; i < h.length; i++)
      h[i] *= -1;
    rmq = new RMQ(h);
    int max = rmq.query(a, b) * - 1;
    return max - min;
  }

}