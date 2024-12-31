package strategies.chap28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WordChain {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int c = Integer.parseInt(br.readLine());
        while (c-- > 0) {
            int n = Integer.parseInt(br.readLine());
            List<String> words = new ArrayList<>();
            for (int i = 0; i < n; i++)
                words.add(br.readLine());
            System.out.println(solve(words));
        }
    }

    private static List<List<Integer>> adj = new ArrayList<>();
    private static List<List<List<String>>> graph = new ArrayList<>();
    // indegree[i] = i 로 시작하는 단어의 수
    private static List<Integer> indegree = new ArrayList<>();
    // outdegree[i] = i 로 끝나는 단어의 수
    private static List<Integer> outdegree = new ArrayList<>();

    private static void makeGraph(List<String> words) {
        graph.clear();
        adj.clear();
        indegree.clear();
        outdegree.clear();
        for (int i = 0; i < 26; i++) {
            graph.add(new ArrayList<>());
            adj.add(new ArrayList<>());
            indegree.add(0);
            outdegree.add(0);
            for (int j = 0; j < 26; j++) {
                graph.get(i).add(new ArrayList<>());
                adj.get(i).add(0);
            }
        }

        for (String word : words) {
            int front = word.charAt(0) - 'a';
            int back = word.charAt(word.length() - 1) - 'a';
            graph.get(front).get(back).add(word);
            adj.get(front).set(back, adj.get(front).get(back) + 1);
            outdegree.set(front, outdegree.get(front) + 1);
            indegree.set(back, indegree.get(back) + 1);
        }
    }

    private static void getEulerCircuit(int here, List<Integer> circuit) {
        for (int there = 0; there < adj.size(); ++there) {
            int edge = adj.get(here).get(there);
            while (edge > 0) {
                adj.get(here).set(there, edge - 1);
                edge = adj.get(here).get(there);
                getEulerCircuit(there, circuit);
            }
        }
        circuit.add(here);
    }

    private static List<Integer> getEulerTrailOrCircuit() {
        List<Integer> circuit = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (outdegree.get(i) == indegree.get(i) + 1) {
                getEulerCircuit(i, circuit);
                return circuit;
            }
        }

        for (int i = 0; i < 26; i++)
            if (outdegree.get(i) > 0) {
                getEulerCircuit(i, circuit);
                return circuit;
            }
        return circuit;
    }

    private static boolean checkEuler() {
        int plus1 = 0, minus1 = 0;
        for (int i = 0; i < 26; ++i) {
            int delta = outdegree.get(i) - indegree.get(i);
            if (delta < -1 || 1 < delta) return false;
            if (delta == 1) plus1++;
            if (delta == -1) minus1++;
        }
        return (plus1 == 1 && minus1 == 1) || (plus1 == 0 && minus1 == 0);
    }

    private static String solve(List<String> words) {
        makeGraph(words);
        if (!checkEuler())
            return "IMPOSSIBLE";
        List<Integer> circuit = getEulerTrailOrCircuit();
        if (circuit.size() != words.size() + 1)
            return "IMPOSSIBLE";

        Collections.reverse(circuit);
        String ret = "";
        for (int i = 1; i < circuit.size(); i++) {
            int a = circuit.get(i - 1), b = circuit.get(i);
            if (ret.length() != 0) ret += " ";
            int lastIndex = graph.get(a).get(b).size() - 1;
            ret += graph.get(a).get(b).get(lastIndex);
            graph.get(a).get(b).remove(lastIndex);
        }
        return ret;
    }
}