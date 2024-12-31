package strategies.chap7;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import util.Input;

public class Karatsuba {

  public static void main(String[] args) throws Exception {
    Karatsuba karatsuba = new Karatsuba();
    File file = Input.fileFromClassName(karatsuba);

    Scanner sc = new Scanner(file);

    int[] a = {3, 2, 1};
    int[] b = {6, 5, 4};

    List<Integer> list = multiply(a, b);
    for(Integer integer : list)
      System.out.print(integer);


  }

  static List<Integer> normalize(LinkedList<Integer> num) {
    num.push(0);
    for (int i = 0; i + 1 < num.size(); ++i) {
      if (num.get(i) < 0) {
        int borrow = Math.abs(num.get(i) + 9) / 10;
        num.set(i + 1, num.get(i + 1) - borrow);
        num.set(i, num.get(i) + borrow * 10);
      } else {
        num.set(i + 1, num.get(i + 1) + num.get(i) / 10);
        num.set(i, num.get(i) % 10);
      }
    }

    while (num.size() > 1 && num.peek() == 0) {
      num.pop();
    }
    return num;
  }

  static List<Integer> multiply(int[] a, int[] b) {
    ArrayList<Integer> c = new ArrayList<>();
    for (int i = 0; i < a.length + b.length + 1; i++) {
      c.add(0);
    }
    for (int i = 0; i < a.length; ++i) {
      for (int j = 0; j < b.length; ++j) {
        c.set(i + j, c.get(i+j) + a[i] * b[j]);
      }
    }
    return normalize(new LinkedList<>(c));
  }


}
