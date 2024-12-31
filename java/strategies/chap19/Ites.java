package strategies.chap19;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ites {

//  public static void main(String[] args) throws IOException {
//    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    int C = Integer.parseInt(br.readLine());
//    while (C-- > 0) {
//      StringTokenizer st = new StringTokenizer(br.readLine());
//      int K = Integer.parseInt(st.nextToken());
//      int N = Integer.parseInt(st.nextToken());
//
//      long A = 1983;
//      Queue<Integer> q = new LinkedList<>();
//      int sum = 0;
//      int count = 0;
//      for (int i = 1; i <= N; i++) {
//        int signal = (int) (A % 10000 + 1);
//        q.add(signal);
//        sum += signal;
//        while (sum > K) {
//          sum -= q.poll();
//        }
//        if (sum == K) {
//          count++;
//        }
//        A = (long) ((A * 214013 + 2531011) % Math.pow(2, 32));
//      }
//      System.out.println(count);
//    }
//  }

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
    int C = Integer.parseInt(bufferedReader.readLine());
    while(C-- > 0){
      StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
      int K = Integer.parseInt(stringTokenizer.nextToken());
      int N = Integer.parseInt(stringTokenizer.nextToken());

      long[] A = new long[N];
      int[] signals = new int[N+1];
      long MOD = (long)Math.pow(2, 32);

      A[0] = 1983;
      for(int i = 1; i < N; i++){
        A[i] = (A[i-1] * 214013 + 2531011) % MOD;
      }

      for(int i = 1; i <= N; i++){
        signals[i] = (int)(A[i-1] % 10000 + 1);
      }

      bufferedWriter.write(String.valueOf(countRanges(K, N)));
      bufferedWriter.newLine();
      bufferedWriter.flush();
    }
  }

  private static int simpleSolve(long[] a, int k) {
    int answer = 0;
    for(int head = 0; head < a.length; head++){
      int sum = 0;
      for(int tail = head; tail < a.length; tail++){
        sum += a[tail];
        if(sum == k)
          answer++;
        if(sum >= k) break;
      }
    }
    return answer;
  }

  private static int optimize(int[] signals, int k){
    int ret = 0, tail = 0, rangeSum = signals[0];
    for(int head = 0; head < signals.length; ++head){
      while(rangeSum < k && tail + 1 < signals.length)
        rangeSum += signals[++tail];

      if(rangeSum == k) ret++;

      rangeSum -= signals[head];
    }
    return ret;
  }

  static int countRanges(int k, int n){
    long A = 1983;

    Queue<Integer> range = new LinkedList<>();
    int ret = 0, rangeSum = 0;
    for(int i = 0; i < n; i++){
      int newSignal = (int)(A % 10000 + 1);
      rangeSum += newSignal;
      range.add(newSignal);

      while(rangeSum > k){
        rangeSum -= range.poll();
      }

      if(rangeSum == k) ret++;
      A = (A * 214013 + 2531011) % (long)Math.pow(2,32);
    }
    return ret;
  }
}