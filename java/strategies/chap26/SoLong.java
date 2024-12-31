package strategies.chap26;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class SoLong {

  private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    int c = Integer.parseInt(br.readLine());
    while(c-- > 0){
      st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());

      TrieNode trieNode = readInput(n);
      int answer = m - 1;
      st = new StringTokenizer(br.readLine());
      for(int i = 0; i < m; i++){
        String next = st.nextToken();
        int count = trieNode.countKeys(trieNode, next);
        System.out.println("WORD : " + next + " " + count);
        answer += count;
      }
      bw.write(answer + "\n");
      bw.flush();
    }
  }

  static TrieNode readInput(int words) throws IOException {
    List<Pair> input = new ArrayList<>();
    for(int i = 0; i < words; i++){
      st = new StringTokenizer(br.readLine());
      String buf = st.nextToken();
      int freq = Integer.parseInt(st.nextToken());
      input.add(new Pair(-freq, buf));
    }
    Collections.sort(input);
    TrieNode trie = new TrieNode();
    int i = 0;
    for(Pair pair: input){
      trie.insert(pair.word, i);
      i++;
    }
    trie.first = -1;
    return trie;
  }

  private static class Pair implements Comparable<Pair>{

    int frequency;
    String word;

    public Pair(int frequency, String word){
      this.frequency = frequency;
      this.word = word;
    }

    @Override
    public int compareTo(Pair o) {
      Pair pair = (Pair) o;
      if(this.frequency > pair.frequency) return 1;
      else if(this.frequency < pair.frequency) return -1;
      else{
        return word.compareTo(pair.word);
      }
    }
  }

  private static class TrieNode{

    private static final int ALPHABETS = 26;
    TrieNode[] children;
    // 이 노드에서 종료하는 문자열의 번호, 없으면 -1
    int terminal = - 1;
    // 이 노드를 루트로 하는 트라이에 가장 먼저 추가된 번호, 기본 -1
    int first = -1;

    public TrieNode(){
      children = new TrieNode[ALPHABETS];
    }

    private int toNumber(char ch){
      return ch - 'A';
    }

    private String nextString(String str) {
      return str.length() == 1 ? "" : str.substring(1);
    }

    public void insert(String key, int id){
      if(first == -1) first = id;
      if(key.isEmpty()) terminal = id;
      else{
        int next = toNumber(key.charAt(0));
        if(children[next] == null)
          children[next] = new TrieNode();
        children[next].insert(nextString(key), id);
      }
    }

    public TrieNode find(String key){
      if(key.isEmpty()) return this;
      int next = toNumber(key.charAt(0));
      if(children[next] == null) return null;
      return children[next].find(nextString(key));
    }

    public int type(String key, int id){
      if(key.isEmpty()) return 0;
      if(first == id) return 1;
      int next = toNumber(key.charAt(0));
      return 1 + children[next].type(nextString(key), id);
    }

    public int countKeys(TrieNode trie, String word){
      TrieNode node = trie.find(word);
      if(node == null || node.terminal == -1) return word.length();
      return trie.type(word, node.terminal);
    }
  }
}