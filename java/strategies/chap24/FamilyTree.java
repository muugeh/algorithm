package strategies.chap24;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public  class FamilyTree {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int C = Integer.parseInt(br.readLine());
    while(C-- > 0){
      StringTokenizer st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      int Q = Integer.parseInt(st.nextToken());
      st = new StringTokenizer(br.readLine());
      child.clear();
      for(int i = 0; i < N; i++)
        child.add(new ArrayList<>());

      for(int i = 1; i < N; i++)
        child.get(Integer.parseInt(st.nextToken())).add(i);

      no2Serial = new int[MAX_N];
      serial2no = new int[MAX_N];
      locInTrip = new int[MAX_N];
      depth = new int[MAX_N];

      for(int i = 0; i < Q; i++) {
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        RMQ rmq = prepareRMQ();
        bw.write(distance(rmq, a, b) + "\n");
        bw.flush();
      }
    }
  }

  private static final int MAX_N = 100000;
  private static ArrayList<ArrayList<Integer>> child = new ArrayList<>();
  private static int[] no2Serial, serial2no, locInTrip, depth;
  private static int nextSerial;

  private static void traverse(int here, int d, ArrayList<Integer> trip){
    no2Serial[here] = nextSerial;
    serial2no[nextSerial] = here;
    ++nextSerial;
    depth[here] = d;
    locInTrip[here] = trip.size();
    trip.add(no2Serial[here]);
    for(int i = 0; i < child.get(here).size(); i++){
      traverse(child.get(here).get(i), d+1, trip);
      trip.add(no2Serial[here]);
    }
  }

  private static RMQ prepareRMQ(){
    nextSerial = 0;
    ArrayList<Integer> trip = new ArrayList<>();
    traverse(0, 0, trip);
    return new RMQ(trip.stream().mapToInt(Integer::intValue).toArray());
  }

  private static int distance(RMQ rmq, int u, int v){
    int lu = locInTrip[u], lv = locInTrip[v];
    if(lu > lv){
      int tmp = lu;
      lu = lv;
      lv = tmp;
    }

    int lca = serial2no[rmq.query(lu, lv)];
    return depth[u] + depth[v] - 2 * depth[lca];
  }
}