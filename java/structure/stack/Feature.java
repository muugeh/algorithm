package structure.stack;

import java.util.ArrayList;
import java.util.LinkedList;

public class Feature {

    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();
        LinkedList<Integer> queue = new LinkedList<>();
        int length = progresses.length;

        for (int i = 0; i < length; i++) {
            queue.add((100 - progresses[i]) / speeds[i]);
        }

        while (!queue.isEmpty()) {
            int task = 1;

            int now = queue.remove();
            while(!queue.isEmpty() && now >= queue.peek()) {
                task++;
                queue.remove();
            }

            answer.add(task);
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }


    public static void main(String[] args) {
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};

//         int[] progresses = {};
//         int[] speeds = {};
//         int[] progresses = {95,96};
//         int[] speeds = {2,2};


        Feature feature = new Feature();
        int[] answer = feature.solution(progresses, speeds);
        for (int i : answer)
            System.out.println(i);
    }
}
