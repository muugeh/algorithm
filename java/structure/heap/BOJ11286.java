package structure.heap;

// [절댓값 힙] https://www.acmicpc.net/problem/11286

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ11286 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int n = Integer.parseInt(br.readLine());
    Heap heap = new Heap(n);
    while (n-- > 0) {
      int x = Integer.parseInt(br.readLine());
      if (x == 0) sb.append(heap.remove()).append("\n");
      else heap.add(x);
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

        if (Math.abs(data) > Math.abs(parentValue)) {
          break;
        } else if (Math.abs(data) == Math.abs(parentValue) && data > parentValue) {
          break;
        }

        array[index] = parentValue;
        index = parent;
      }
      array[index] = data;
    }

    public int remove() {
      if (size == 0) {
        return 0;
      }

      int root = array[1];
      int end = array[size];
      array[size] = 0;

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

        if (right <= size) {
          if ((Math.abs(childValue) > Math.abs(array[right])
              || ((Math.abs(childValue) == Math.abs(array[right])) && (childValue > array[right])))) {
            child = right;
            childValue = array[child];
          }
        }

        if (Math.abs(childValue) > Math.abs(end)) {
          break;
        } else if ((Math.abs(childValue) == Math.abs(end)) && (childValue > end)) {
          break;
        }

        array[parent] = childValue;
        parent = child;
      }
      array[parent] = end;
    }
  }
}
