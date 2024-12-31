package strategies.chap21;

import java.util.ArrayList;
import java.util.List;

public class Node<T> {

  T data;
  Node<T> parent;
  List<Node<T>> children = new ArrayList<>();

  public Node(T data){
    this.data = data;
  }

  public Node(T data, Node<T> parent){
    this(data);
    this.parent = parent;
    parent.children.add(this);
  }

  public void addChild(Node<T> child){
    children.add(child);
  }

  public int height(Node<T> root){
    int h = 0;
    for(int i = 0; i < root.children.size(); ++i)
      h = Math.max(h, 1 + height(root.children.get(i)));
    return h;
  }

  void print(Node<T> root) {
    System.out.println(root.data);
    for (int i = 0; i < root.children.size(); i++) {
      print(root.children.get(i));
    }
  }

  public static void main(String[] args) {
    Node<String> root = new Node<>("root");
    Node<String> child = new Node<>("child1", root);
    Node<String> grand = new Node<>("grand1", child);
    root.print(root);
    System.out.println(root.height(root));
  }

}
