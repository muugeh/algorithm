package strategies.chap4;


import java.util.Arrays;
import java.util.LinkedList;

public class BinSearch {

    int binsearch(LinkedList<Integer> list, int x){
        int size = list.size();
        int lo = -1, hi = size;

        // 반복문 불변식 1: lo < hi
        // 반복문 불변식 2: A[lo] < x <= A[hi]
        // 여기부터 불변식이 성립
        while(lo + 1 < hi){
            System.out.println("lo : " + lo + " hi : " + hi);
            int mid = (lo + hi) / 2;
            if(list.get(mid) < x)
                lo = mid;
            else
                hi = mid;
            // 끝날때도 성립해야 한다.
        }

        return hi;
    }



    public static void main(String[] args){
        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));

        BinSearch binSearch = new BinSearch();

        System.out.println(binSearch.binsearch(list, 10));
    }

}
