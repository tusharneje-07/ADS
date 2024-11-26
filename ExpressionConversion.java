import java.util.*;

public class ExpressionConversion {

  public static void main(String[] args) {
    System.out.println(convert("1+2*3"));
  }

  public static int precedance(char op) {
    switch (op) {
      case '+':
      case '-':
        return 1;
      case '*':
      case '/':
        return 2;
      case '^':
        return 3;
      default:
        return 0;
    }
  }

  public static String convert(String infix) {
    Stack<Character> stack = new Stack<Character>();
    StringBuilder postfix = new StringBuilder();

    for (char op : infix.toCharArray()) {
      // Is Operand -> Push Directly
      if (Character.isLetterOrDigit(op)) {
        postfix.append(op);
      }
      
      // opening bracket
      else if (op == '('){
        stack.push('(');  
      }

      // closing bracket
      else if(op == ')'){
        while(!stack.isEmpty() && stack.peek() != ')'){
            postfix.append(stack.pop());
        }
        stack.pop();
      }

      // Exponential
      else if(op == '^'){
        stack.push('^');
      }

      // operators
      else{
        while(!stack.isEmpty() && precedance(stack.peek()) >= precedance(op)){
            postfix.append(stack.pop());
        }
        stack.push(op);
      }
      System.out.println("Step : Stack " + stack + " Postfix : " + postfix);
    }
    while(!stack.isEmpty()){
        postfix.append(stack.pop());
    }
    return postfix.toString();

  }
}
