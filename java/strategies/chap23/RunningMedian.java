package strategies.chap23;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class RunningMedian {

  static RNG rng = new RNG();

  public static void main(String[] args) throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int C = Integer.parseInt(br.readLine());
    while(C-- > 0){
      StringTokenizer st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      rng.set(a, b);
      bw.write(solve(N) + "\n");
      bw.flush();
    }
  }

  private static int solve(int n) {
    int count = 0;
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    for(int i = 1; i <= n; i++){
      if(maxHeap.size() == minHeap.size())
        maxHeap.add(rng.next());
      else
        minHeap.add(rng.next());

      if(!minHeap.isEmpty() && !maxHeap.isEmpty() && minHeap.peek() < maxHeap.peek()){
        int a = maxHeap.peek(), b = minHeap.peek();
        maxHeap.poll();
        minHeap.poll();
        maxHeap.add(b);
        minHeap.add(a);
      }
      count = (count + maxHeap.peek()) % 20090711;
    }
    return count;
  }

  static class RNG{
    int seed, a, b;

    public void set(int a, int b){
      this.seed = 1983;
      this.a = a;
      this.b = b;
    }

    public int next(){
      int ret = seed;
      seed = (int)(((seed * (long) a) + b) % 20090711);
      return ret;
    }
  }

}