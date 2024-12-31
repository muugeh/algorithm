package strategies.chap22;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Map;
import java.util.TreeMap;

public class Nerd2{
  static TreeMap<Integer, Integer> nerd = new TreeMap<>();


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int C = Integer.parseInt(br.readLine());
    while(C-- >0){
      int N = Integer.parseInt(br.readLine());
      int answer = 0;
      nerd.clear();
      while(N-- > 0){
        String[] split = br.readLine().split(" ");
        int[] point = new int[split.length];
        for(int i = 0; i < point.length; i++)
          point[i] = Integer.parseInt(split[i]);
        answer += registered(point[0], point[1]);
      }
      bw.write(String.valueOf(answer));
      bw.newLine();
      bw.flush();
    }
  }

  static boolean isDominated(int x, int y){
    Integer minRight = nerd.ceilingKey(x);
    if(minRight == null) return false;
    return y < nerd.get(minRight);
  }

  static void removeDominated(int x, int y){
    while(true) {
      Integer maxLeft = nerd.lowerKey(x);
      if(maxLeft == null) break;
      if(nerd.get(maxLeft) > y) break;
      nerd.remove(maxLeft);
    }
  }

  static int registered(int x, int y){
    if(isDominated(x , y)) return nerd.size();
    removeDominated(x, y);
    nerd.put(x, y);
    return nerd.size();
  }


}