package strategies.chap4;

import java.util.Arrays;
import java.util.ArrayList;

public class MovingAverage {

    public static void main(String[] args) {
        ArrayList<Double> N = new ArrayList<>(Arrays.asList(1D, 2D, 3D, 4D, 5D));
        int M = 3;

        MovingAverage movingAverage = new MovingAverage();
        ArrayList<Double> results = movingAverage.movingAverage2(N, M);

        for (double result : results)
            System.out.println("AVERAGE : " + result);
    }

    ArrayList<Double> movingAverage1(ArrayList<Double> N, int M) {
        ArrayList<Double> answer = new ArrayList<>();

        for (int i = 0; i < N.size() - (M - 1); i++) {
            double partialSum = 0;

            for (int f = i; f < i + M; f++)
                partialSum += N.get(f);

            answer.add(partialSum / M);
        }
        return answer;
    }

    ArrayList<Double> movingAverage2(ArrayList<Double> N, int M) {
        ArrayList<Double> answer = new ArrayList<>();
        int size = N.size();

        double partialSum = 0;
        for (int i = 0; i < M - 1; i++) {
            partialSum += N.get(i);
        }

        for (int i = M - 1; i < size; i++) {
            partialSum += N.get(i);
            answer.add(partialSum / M);
            partialSum -= N.get(i - (M - 1));
        }

        answer.add(partialSum / M);
        return answer;
    }


}
