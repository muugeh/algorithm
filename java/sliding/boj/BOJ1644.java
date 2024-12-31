package sliding.boj;

// [소수의 연속합] https://www.acmicpc.net/problem/1644

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BOJ1644 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(br.readLine());
    List<Boolean> primes = getPrime(n);
    bw.write(String.valueOf(count(primes)));
    bw.flush();
    bw.close();
    br.close();
  }

  private static int count(List<Boolean> primes) {
    int n = primes.size() - 1;
    int count = 0;
    int end = 2;
    int sum = 0;
    for (int start = 2; start <= n; start++) {
      while (start <= n && !primes.get(start)) {
        start++;
      }
      while (sum < n && end <= n) {
        if (primes.get(end)) sum += end;
        end++;
      }
      if (sum == n) count++;
      sum -= start;
    }
    return count;
  }

  private static List<Boolean> getPrime(int n) {
    List<Boolean> primes = new ArrayList<>(n + 1);
    primes.add(false);
    primes.add(false);
    for (int i = 2; i <= n; i++)
      primes.add(i, true);
    for (int i = 2; (i * i) <= n; i++) {
      if (primes.get(i)) {
        for (int j = i * i; j <= n; j += i)
          primes.set(j, false);
      }
    }
    return primes;
  }

}
