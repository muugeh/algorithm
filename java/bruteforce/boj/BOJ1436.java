package bruteforce.boj;

// [영화감독 숌] https://www.acmicpc.net/problem/1436

import java.io.*;

public class BOJ1436 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(br.readLine());
    int count = 0;
    int start = 666;
    while(count < n){
      if(String.valueOf(start).contains("666")) {
        count++;
        if(count == n)
          break;
      }
      start++;
    }
    bw.write(String.valueOf(start));
    bw.flush();
    bw.close();
    br.close();
  }

}
