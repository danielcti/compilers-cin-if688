package calculator;

import java.util.*;

class Solution {
  public int stacky(String[] tokens) {
    Token[] tokenList = tokenize(tokens);
    System.out.println(Arrays.toString(tokenList));

    Stack<String> stack = new Stack<String>();
    int x, y;
    String result = "";
    int value = 0;

    for (int i = 0; i < tokenList.length; i++) {
      if (tokenList[i].type.equals(TokenType.NUM)) {
        stack.push(tokenList[i].lexeme);
        continue;
      }

      x = Integer.parseInt(stack.pop());
      y = Integer.parseInt(stack.pop());

      switch (tokenList[i].type) {
        case PLUS:
          value = x + y;
          break;

        case MINUS:
          value = y - x;
          break;

        case STAR:
          value = x * y;
          break;

        case SLASH:
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

  private Token[] tokenize(String[] tokens) {
    Token[] tokenList = new Token[tokens.length];

    for (int i = 0; i < tokens.length; i++) {
      if (isNumber(tokens[i])) {
        tokenList[i] = new Token(TokenType.NUM, tokens[i]);
      } else {
        switch (tokens[i]) {
          case "+":
            tokenList[i] = new Token(TokenType.PLUS, tokens[i]);
            break;

          case "-":
            tokenList[i] = new Token(TokenType.MINUS, tokens[i]);
            break;

          case "*":
            tokenList[i] = new Token(TokenType.STAR, tokens[i]);
            break;

          case "/":
            tokenList[i] = new Token(TokenType.SLASH, tokens[i]);
            break;

          default:
            continue;
        }
      }
    }

    return tokenList;
  }
}