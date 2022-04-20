/* *******************************************************************
 * Copyright (c) 2021 Universidade Federal de Pernambuco (UFPE).
 * 
 * This file is part of the Compilers course at UFPE.
 * 
 * During the 1970s and 1980s, Hewlett-Packard used RPN in all 
 * of their desktop and hand-held calculators, and continued to 
 * use it in some models into the 2020s. In computer science, 
 * reverse Polish notation is used in stack-oriented programming languages 
 * such as Forth, STOIC, PostScript, RPL and Joy.
 *  
 * Contributors: 
 *     Henrique Rebelo      initial design and implementation 
 *     http://www.cin.ufpe.br/~hemr/
 * ******************************************************************/

package calculator;

/**
 * @author Henrique Rebelo
 */
public class Token {

  public final TokenType type; // token type
  public final String lexeme; // token value

  public Token(TokenType type, String value) throws IllegalArgumentException {
    if (!this.isValidToken(value)) {
      throw new IllegalArgumentException("Unexpected character: " + value);
    }
    this.type = type;
    this.lexeme = value;
  }

  @Override
  public String toString() {
    return "Token [type=" + this.type + ", lexeme=" + this.lexeme + "]";
  }

  private boolean isValidToken(String token) {
    return this.isNumeric(token) || this.isOperator(token);
  }

  private boolean isOperator(String token) {
    return token.equals("+") || token.equals("-") || token.equals("*")
        || token.equals("/");
  }

  private boolean isNumeric(String str) {
    return str.matches("-?\\d+(\\.\\d+)?"); // match a number with optional '-' and decimal.
  }
}