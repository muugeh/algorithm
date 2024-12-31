package dp.boj;

// [양팔저울] https://www.acmicpc.net/problem/2629

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2679 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] weights = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = 0;
        for (int i = 0; i < n; i++) {
            weights[i] = Integer.parseInt(st.nextToken());
            sum += weights[i];
        }
        int m = Integer.parseInt(br.readLine());
        int[] marbles = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            marbles[i] = Integer.parseInt(st.nextToken());
        }
        boolean[][] canMake = new boolean[n][sum + 1];
        canMake[0][weights[0]] = true;

        for (int i = 1; i < n; i++) {
            canMake[i][weights[i]] = true;
            for (int j = 1; j <= sum; j++) {
                if (canMake[i - 1][j]) {
                    canMake[i][j] = true;
                    if (j - weights[i] > 0) {
                        canMake[i][j - weights[i]] = true;
                    }
                    if (weights[i] - j > 0) {
                        canMake[i][weights[i] - j] = true;
                    }
                    if (j + weights[i] <= sum) {
                        canMake[i][j + weights[i]] = true;
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            boolean answer = marbles[i] <= sum && canMake[n - 1][marbles[i]];
            System.out.print(answer ? "Y " : "N ");
        }
    }
}
