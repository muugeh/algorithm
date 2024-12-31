package strategies.chap6;

public class Permutation {

  static int count = 1;

  public static void main(String[] args){

    int[] elements = {1,2,3,4,5};

    printAllRecursive(0, elements);


    System.out.println(recursive(10));
  }

  public static void printAllRecursive(int n, int[] elements){
    if(n == elements.length) {
      print(elements);
      return;
    }

    for(int i = n; i < elements.length; i++){
      swap(elements, i, n);
      printAllRecursive(n+1, elements);
      swap(elements, i, n);
    }
  }

  public static void swap(int[] elements, int x, int y){
    int tmp = elements[x];
    elements[x] = elements[y];
    elements[y] = tmp;
  }

  public static void print(int[] elements){

    System.out.print(count++ + " ");
    for(int i = 0; i < elements.length; i++){
      System.out.print(elements[i] + " ");
    }
    System.out.println();
  }


  public static int recursive(int n){
    if(n == 1) return 1;

    return n * recursive(n - 1);

  }
}
