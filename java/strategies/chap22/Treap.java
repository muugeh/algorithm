package strategies.chap22;

public class Treap {

  int key;
  int priority;
  int size;
  Treap left, right;

  public Treap(int key){
    this.key = key;
    this.priority = (int)(Math.random() * 100);
  }

  public void setLeft(Treap left){
    this.left = left;
    calcSize();
  }

  public void setRight(Treap right){
    this.right = right;
    calcSize();
  }

  // size 멤버를 갱신한다.
  public void calcSize(){
    size = 1;
    if(left != null) size += left.size;
    if(right != null) size += right.size;
  }
  
  public NodePair split(Treap root, int key){
    if(root == null) return new NodePair(null, null);
    
    if(root.key < key){
      NodePair rs = split(root.right, key);
      root.setRight(rs.left);
      return new NodePair(root, rs.right);
    }
    
    NodePair ls = split(root.left, key);
    root.setLeft(ls.right);
    return new NodePair(ls.left, root);
  }
  
  public Treap insert(Treap root, Treap node){
    if(root == null) return node;
    if(root.priority < node.priority){
      NodePair splitted = split(root, node.key);
      node.setLeft(splitted.left);
      node.setRight(splitted.right);
      return node;
    } 
    else if(node.key < root.key)
      root.setLeft(insert(root.left, node));
    else
      root.setRight(insert(root.right, node));
    return root;
  }

  public Treap merge(Treap left, Treap right){
    if(left == null) return right;
    if(right == null) return left;
    if(left.priority < right.priority){
      right.setLeft(merge(left, right.left));
      return right;
    }
    left.setRight(merge(left.right, right));
    return left;
  }

  public Treap erase(Treap root, int key){
    if(root == null) return null;

    if(root.key == key){
      return merge(root.left, root.right);
    }
    if(key < root.key)
      root.setLeft(erase(root.left, key));
    else
      root.setRight(erase(root.right, key));
    return root;
  }

  // root 에서 k번째 원소 반환
  public Treap kth(Treap root, int k){
    int leftSize = 0;
    if(root.left != null) leftSize = root.left.size;
    if(k <= leftSize) return kth(root.left, k);
    if(k == leftSize + 1) return root;
    return kth(root.right, k - leftSize - 1);
  }

  public int countLessThan(Treap root, int key){
    if(root == null) return 0;
    if(root.key >= key)
      return countLessThan(root.left, key);
    int ls = root.left != null ? root.left.size : 0;
    return ls + 1 + countLessThan(root.right, key);
  }

  class NodePair{
    
    Treap left, right;
    
    public NodePair(Treap left, Treap right){
      this.left = left;
      this.right = right;
    }
  }
  
}