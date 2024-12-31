package greedy.boj;

// [회의실 배정] https://www.acmicpc.net/problem/1931

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1931 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(br.readLine());
    List<Meeting> meetings = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      meetings.add(new Meeting(start, end));
    }
    Collections.sort(meetings);
    int count = 0;
    int end = 0;
    for (Meeting meeting : meetings) {
      if (meeting.start >= end) {
        count++;
        end = meeting.end;
      }
    }
    bw.write(String.valueOf(count));
    bw.flush();
    bw.close();
    br.close();
  }

  private static class Meeting implements Comparable<Meeting> {
    int start;
    int end;

    public Meeting(int start, int end) {
      this.start = start;
      this.end = end;
    }

    @Override
    public int compareTo(Meeting o) {
      if (end > o.end)
        return 1;
      else if (end < o.end)
        return -1;
      else
        return Integer.compare(start, o.start);
    }
  }

}
