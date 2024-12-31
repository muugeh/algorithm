package math.boj;

// [나누기] https://www.acmicpc.net/problem/1075

import java.io.*;

public class BOJ1075 {

  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(br.readLine());
    int f = Integer.parseInt(br.readLine());
    int min = 0;
    for(int i = 0; i < 100; i++){
      if(((n / 100) * 100 + i) % f == 0){
        min = i;
        break;
      }
    }
    bw.write(String.format("%02d", min));
    bw.flush();
    br.close();
    bw.close();
  }
}
