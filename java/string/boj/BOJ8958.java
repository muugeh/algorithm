package string.boj;

// [OX퀴즈] https://www.acmicpc.net/problem/8958

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ8958 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int c = Integer.parseInt(br.readLine());

    while(c-- > 0){
      int sum = 0;
      int accumulation = 0;
      String result = br.readLine();

      for(int i = 0; i < result.length(); i++){
        if(result.charAt(i) == 'O') {
          sum += ++accumulation;
        }
        else {
          accumulation = 0;
        }
      }

      System.out.println(sum);
    }

  }

}
