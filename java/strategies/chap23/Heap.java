package strategies.chap23;

import java.util.ArrayList;
import java.util.Collections;

public class Heap {

  ArrayList<Integer> heap = new ArrayList<>();

  public void push(int newValue){
    heap.add(newValue);
    int idx = heap.size() - 1;
    while(idx > 0 && heap.get((idx - 1)/ 2) < heap.get(idx)){
      Collections.swap(heap, idx, (idx - 1) / 2);
      idx = (idx - 1) / 2;
    }
  }

  public void pop(){
    int last = heap.size() - 1;
    heap.set(0, heap.get(last));
    heap.remove(last);
    int here = 0;
    while(true){
      int left = here * 2 + 1, right = here * 2 + 2;
      if(left >= heap.size()) break;
      int next = here;
      if(heap.get(next) < heap.get(left))
        next = left;
      if(right < heap.size() && heap.get(next) < heap.get(right))
        next = right;
      if(next == here) break;
      Collections.swap(heap, here, next);
      here = next;
    }
  }

}