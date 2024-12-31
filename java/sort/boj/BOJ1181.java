package sort.boj;

// [단어 정렬] https://www.acmicpc.net/problem/1181

import java.io.*;
import java.util.*;

public class BOJ1181 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(br.readLine());
    Set<Word> words = new TreeSet<>();
    for(int i = 0; i < n; i++){
      words.add(new Word(br.readLine()));
    }
    for(Word word : words){
      bw.write(word + "\n");
    }
    bw.flush();
    bw.close();
    br.close();
  }

  private static class Word implements Comparable<Word>{
    String word;
    public Word(String word){
      this.word = word;
    }

    @Override
    public int compareTo(Word o) {
      if(this.word.length() > o.word.length())
        return 1;
      else if(this.word.length() < o.word.length())
        return -1;
      else{
        return word.compareTo(o.word);
      }
    }

    @Override
    public String toString() {
      return word;
    }

  }
}
