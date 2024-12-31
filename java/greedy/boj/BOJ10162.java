package greedy.boj;

// [전자레인지] https://www.acmicpc.net/problem/10162

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10162 {

  private static final int[] buttons = {300, 60, 10};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());
    count(t);
  }

  private static void count(int t) {
    if(t % 10 != 0){
      System.out.println(-1);
      return;
    }

    int order = 0;
    while(order < 3){
      System.out.print(t / buttons[order]);
      if(order != 2)
        System.out.print(" ");
      t %= buttons[order];
      order++;
    }
  }

}