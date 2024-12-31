package strategies.chap26;

public class TrieNode {

  private static final int ALPHABETS = 26;
  TrieNode[] children;
  boolean terminal;

  public TrieNode() {
    children = new TrieNode[ALPHABETS];
    terminal = false;
  }

  private int toNumber(char ch) {
    return ch - 'A';
  }

  private String nextString(String str){
    return str.length() == 1 ? "" : str.substring(1);
  }

  public void insert(String key) {
    if(key.isEmpty()) terminal = true;
    else {
      int next = toNumber(key.charAt(0));
      if (children[next] == null) {
        children[next] = new TrieNode();
      }
      children[next].insert(nextString(key));
    }
  }

  public TrieNode find(String key) {
    if(key.isEmpty()) return this;
    int next = toNumber(key.charAt(0));
    if (children[next] == null) {
      return null;
    }
    return children[next].find(nextString(key));
  }
}