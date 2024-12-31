package greedy.boj;

// [주유소] https://www.acmicpc.net/problem/13305

import java.io.*;
import java.util.Arrays;

public class BOJ13305 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(br.readLine());
    int[] distance = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    int[] price = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

    int minPrice = Integer.MAX_VALUE;
    long totalPrice = 0;
    for (int i = 0; i < n - 1; i++) {
      minPrice = Math.min(minPrice, price[i]);
      totalPrice += (long) minPrice * distance[i];
    }
    bw.write(String.valueOf(totalPrice));
    bw.flush();
    bw.close();
    br.close();
  }

}
