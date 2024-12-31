package greedy.boj;

// [단어 수학] https://www.acmicpc.net/problem/1339

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class BOJ1339 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    List<String> words = new ArrayList<>();
    PriorityQueue<Alphabet> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
    int[] alphabets = new int[26];
    for (int i = 0; i < n; i++) {
      words.add(br.readLine());
      char[] ch = words.get(i).toCharArray();
      for (int j = 0; j < ch.length; j++) {
        alphabets[ch[j] - 'A'] += Math.pow(10, ch.length - j - 1);
      }
    }

    for (int i = 0; i < 26; i++) {
      if (alphabets[i] != 0) {
        priorityQueue.offer(new Alphabet((char) (i + 'A'), alphabets[i]));
      }
    }

    int sum = 0;
    for (int i = 9; i >= 0; i--) {
      if (priorityQueue.isEmpty()) break;
      Alphabet alphabet = priorityQueue.poll();
      sum += alphabet.priority * i;
    }

    System.out.println(sum);
    br.close();
  }

  private static class Alphabet implements Comparable<Alphabet> {
    char alphabet;
    int priority;

    public Alphabet(char alphabet, int priority) {
      this.alphabet = alphabet;
      this.priority = priority;
    }

    @Override
    public int compareTo(Alphabet o) {
      return this.priority - o.priority;
    }
  }
}
