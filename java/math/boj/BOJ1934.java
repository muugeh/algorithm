package math.boj;

// [최소공배수] https://www.acmicpc.net/problem/1934

import java.io.*;
import java.util.Arrays;

public class BOJ1934 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int t = Integer.parseInt(br.readLine());
    while (t-- > 0) {
      int[] nums = Arrays.stream(br.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
      int gcd = gcd(nums[0], nums[1]);
      bw.write(nums[0] * nums[1] / gcd + "\n");
    }
    bw.flush();
    bw.close();
    br.close();
  }

  public static int gcd(int num1, int num2) {
    if (num2 == 0) return num1;
    else return gcd(num2, num1 % num2);
  }
}
