package bruteforce.boj;

import java.io.*;

public class BOJ2231 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(br.readLine());
    int min = Integer.MAX_VALUE;
    for(int i = 1; i < n; i++){
      int composition = i;
      int j = i;
      while(j > 0){
        composition += j % 10;
        j /= 10;
      }
      if(composition == n)
        min = Math.min(min, i);
    }
    if(min == Integer.MAX_VALUE) min = 0;
    bw.write(String.valueOf(min));
    bw.flush();
    bw.close();
    br.close();
  }

}
