package sort.boj;

// [나이순 정렬] https://www.acmicpc.net/problem/10814

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ10814 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(br.readLine());
    List<Person> people = new ArrayList<>();
    while (n-- > 0) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int age = Integer.parseInt(st.nextToken());
      String name = st.nextToken();
      people.add(new Person(age, name));
    }
    Collections.sort(people);
    for (Person person : people) {
      bw.write(person + "\n");
    }
    bw.flush();
    bw.close();
    br.close();
  }

  private static class Person implements Comparable<Person> {
    int age;
    String name;

    public Person(int age, String name) {
      this.age = age;
      this.name = name;
    }

    @Override
    public int compareTo(Person o) {
      return Integer.compare(age, o.age);
    }

    @Override
    public String toString() {
      return age + " " + name;
    }

  }

}
