package dp.boj;

// [계단 오르기] https://www.acmicpc.net/problem/2579

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ2579 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    List<Integer> floors = new ArrayList<>();
    for(int i = 0; i < n; i++)
      floors.add(Integer.parseInt(br.readLine()));
    System.out.println(getMax(floors));
  }

  private static int getMax(List<Integer> floors) {
    int top = floors.size();
    int[][] cache = init(top, floors);

    for(int i = 2; i < cache.length; i++){
      cache[i][0] = Math.max(cache[i - 2][1], cache[i - 2][0]) + floors.get(i);
      cache[i][1] = cache[i - 1][0] + floors.get(i);
    }
    return Math.max(cache[top-1][0], cache[top-1][1]);
  }

  private static int[][] init(int top, List<Integer> floors){
    int[][] cache = new int[top][2];
    cache[0][0] = floors.get(0);
    if(top > 1){
      cache[1][0] = floors.get(1);
      cache[1][1] = floors.get(0) + floors.get(1);
    }
    return cache;
  }

}
