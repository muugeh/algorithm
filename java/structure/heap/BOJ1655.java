package structure.heap;

// [가운데를 말해요] https://www.acmicpc.net/problem/1655

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1655 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int n = Integer.parseInt(br.readLine());
    Heap min = new Heap(n);
    Heap max = new Heap(n);
    while (n-- > 0) {
      int x = Integer.parseInt(br.readLine());
      if (min.size == max.size) max.add(-x);
      else min.add(x);
      if (min.size != 0 && min.peek() < -max.peek()) {
        int minValue = min.remove();
        int maxValue = max.remove();
        max.add(-minValue);
        min.add(-maxValue);
      }
      sb.append(-max.peek()).append("\n");
    }
    System.out.println(sb);
  }

  private static class Heap {
    int[] array;
    int size;

    public Heap(int capacity) {
      size = 0;
      array = new int[capacity];
    }

    public int getParent(int index) {
      return index / 2;
    }

    public int getLeftChild(int index) {
      return index * 2;
    }

    public int getRightChild(int index) {
      return index * 2 + 1;
    }

    public void resize(int newCapacity) {
      int[] newArray = new int[newCapacity];
      System.arraycopy(array, 1, newArray, 1, size);
      this.array = newArray;
    }

    public void add(int data) {
      if (size + 1 == array.length) {
        resize(array.length * 2);
      }

      siftUp(size + 1, data);
      size++;
    }

    private void siftUp(int index, int data) {
      while (index > 1) {
        int parent = getParent(index);
        int parentValue = array[parent];

        if (data > parentValue) {
          break;
        }

        array[index] = parentValue;
        index = parent;
      }
      array[index] = data;
    }

    public int peek() {
      return array[1];
    }

    public int remove() {
      int root = array[1];
      int end = array[size];
      siftDown(end);
      return root;
    }

    private void siftDown(int end) {
      array[1] = end;
      size--;

      int parent = 1;
      int child;

      while ((child = getLeftChild(parent)) <= size) {
        int right = getRightChild(parent);
        int childValue = array[child];

        if (right <= size && childValue > array[right]) {
          child = right;
          childValue = array[child];
        }

        if (childValue > end) {
          break;
        }

        array[parent] = childValue;
        parent = child;
      }

      array[parent] = end;
    }
  }
}
