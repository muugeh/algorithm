package util;

import java.io.File;
import java.util.Scanner;

public class Input {

  public static File fileFromClassName(Object object){
    String className = object.getClass().getSimpleName().toLowerCase();
    String chapter = object.getClass().getPackage().toString().split("\\.")[1].replace("chap", "");

    return new File("./src/strategies/chap" + chapter + "/input/" +  className + ".txt");
  }

  public static Scanner sc(Object object) {
    Scanner sc = new Scanner(System.in);
    try{
      sc = new Scanner(fileFromClassName(object));
    }catch (Exception e){
      System.out.println("파일이 존재하지 않습니다.");
    }
    return sc;
  }

  public static Scanner sc(String fileName) {
    Scanner sc = new Scanner(System.in);
    try{
      sc = new Scanner(fileName);
    }catch (Exception e){
      System.out.println("파일이 존재하지 않습니다.");
    }
    return sc;
  }

}
