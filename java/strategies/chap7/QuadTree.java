package strategies.chap7;

import java.io.File;
import java.util.Scanner;

public class QuadTree {

  public static void main(String[] args) throws Exception {
    File file = new File("./src/goo/chap7/input/quadtree.txt");
    Scanner sc = new Scanner(file);

    int C = sc.nextInt();
    while (C-- > 0) {
      String compress = sc.next();
      System.out.println(quadTree(compress));
    }
  }

  private static String quadTree(String compress) {
    char head = compress.charAt(0);
    if (head == 'b' || head == 'w') {
      return Character.toString(head);
    }

    String remains = compress.substring(1);
    String ul = quadTree(remains);

    remains = remains.substring(ul.length());
    String ur = quadTree(remains);

    remains = remains.substring(ur.length());
    String ll = quadTree(remains);

    remains = remains.substring(ll.length());
    String lr = quadTree(remains);
    return "x" + ll + lr + ul + ur;
  }
}


