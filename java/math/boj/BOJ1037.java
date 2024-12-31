package math.boj;

// [약수] https://www.acmicpc.net/problem/1037

import java.io.*;
import java.util.Arrays;

public class BOJ1037 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(br.readLine());
    int[] arr =
        Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();

    long min = (long) arr[arr.length - 1] * arr[0];
    long max = arr[arr.length - 1] * 1000000L;
    for (long i = min; i <= max; i++) {
      boolean allDivided = true;
      for (int factor : arr) {
        if (i % factor != 0) {
          allDivided = false;
          break;
        }
      }
      if (allDivided) {
        bw.write(String.valueOf(i));
        break;
      }
    }
    bw.flush();
    bw.close();
    br.close();
  }
}
