package calculator;

import java.io.IOException;

public class Main {
  static String fileName = "src/calculator/Calc1.stk";

  public static void main(String[] args) throws IOException {
    FileArrayProvider fap = new FileArrayProvider();
    String[] input = fap.readLines(fileName);
    // String[] s = { "4", "8", "+", "3", "*" };

    Solution sol = new Solution();
    int result = sol.stacky(input);
    System.out.println(result);
  }
}