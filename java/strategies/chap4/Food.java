package strategies.chap4;

import java.util.LinkedList;

public class Food {


    boolean canEveryBodyEat(LinkedList<Integer> menu) {


        return true;
    }


    private static final int INF = 987654321;
    // 요리할 수 있는 음식의 종류의 수
    int M;
    // food번째 음식을 만들지 결정
    int selectMenu(LinkedList<Integer> menu, int food) {
        if (food == M) {
            if (canEveryBodyEat(menu)) return menu.size();
            // 못 먹는 사람이 있으면 아주 큰 값 반환
            return INF;
        }
        // 이 음식을 만들지 않는 경우의 답 계산
        int answer = selectMenu(menu, food + 1);
        // 이 음식을 만드는 경우의 답 계산 후 더 작은 값 선택
        menu.add(food);
        answer = Math.min(answer, selectMenu(menu, food + 1));
        menu.remove();
        return answer;
    }

}
