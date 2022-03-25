package calculator;

import java.util.*;

class Solution {
  public int stacky(String[] tokens) {
    Stack<String> stack = new Stack<String>();
    int x, y;
    String result = "";
    String choice;
    int value = 0;

    for (int i = 0; i < tokens.length; i++) {
      if (isNumber(tokens[i])) {
        stack.push(tokens[i]);
        continue;
      } else {
        choice = tokens[i];
      }

      x = Integer.parseInt(stack.pop());
      y = Integer.parseInt(stack.pop());

      switch (choice) {
        case "+":
          value = x + y;
          break;

        case "-":
          value = y - x;
          break;

        case "*":
          value = x * y;
          break;

        case "/":
          value = y / x;
          break;

        default:
          continue;
      }

      result = Integer.toString(value);
      stack.push(result);
    }

    return Integer.parseInt(stack.pop());
  }

  private boolean isNumber(String token) {
    return !token.equals("+") && !token.equals("-") && !token.equals("*") && !token.equals("/");
  }
}
