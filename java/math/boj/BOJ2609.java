package math.boj;

// [최대공약수와 최소공배수] https://www.acmicpc.net/problem/2609

import java.io.*;
import java.util.Arrays;

public class BOJ2609 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] nums = Arrays.stream(br.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
        int gcd = gcd(nums[0], nums[1]);
        bw.write(gcd + "\n");
        bw.write(nums[0] * nums[1] / gcd + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static int gcd(int num1, int num2){
        if(num2 == 0) return num1;
        else return gcd(num2, num1 % num2);
    }
}
