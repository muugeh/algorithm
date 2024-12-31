package strategies.chap4;

import java.util.Collections;
import java.util.LinkedList;

public class Factor {

    LinkedList<Integer> factor(int n) {
        if (n == 1) return new LinkedList<>(Collections.singletonList(1));
        LinkedList<Integer> answer = new LinkedList<>();
        for (int div = 2; n > 1; ++div) {
            while (n % div == 0) {
                n /= div;
                answer.add(div);
            }
        }
        return answer;
    }

    int firstIndex(LinkedList<Integer> array, int element) {
        for (int i = 0; i < array.size(); i++)
            if (array.get(i) == element)
                return i;
        return -1;
    }

    public static void main(String[] args) {
        Factor factor = new Factor();
        System.out.println(factor.factor(20));
    }

}
