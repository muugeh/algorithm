package strategies.chap29;

import java.io.*;
import java.util.StringTokenizer;

public class ChildrenDay {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int t = Integer.parseInt(br.readLine());
    while(t-- > 0){
      StringTokenizer st = new StringTokenizer(br.readLine());
      int d = Integer.parseInt(st.nextToken());
      int n = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());


    }

    br.close();
    bw.close();
  }
}