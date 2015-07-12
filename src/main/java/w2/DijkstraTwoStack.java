package w2;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Matija Vižintin
 * Date: 03. 07. 2015
 * Time: 21.27
 */
public class DijkstraTwoStack {
    private static final Collection<Character> operators = new ArrayList<>();

    static {
        operators.add('+');
        operators.add('-');
        operators.add('*');
        operators.add('/');
        operators.add('%');
    }

    private ArrayStack<Double> valueStack = new ArrayStack<>();
    private ArrayStack<Character> operatorStack = new ArrayStack<>();

    public DijkstraTwoStack() {
    }

    public Double calculate(String expression) {
        // wrap
        expression = "(" + expression + ")";

        for (Character c : expression.toCharArray()) {
            if (Character.isDigit(c)) {
                valueStack.push(Double.parseDouble(c.toString()));
            } else if (operators.contains(c)) {
                operatorStack.push(c);
            } else if (c.equals(')')) {
                Double calculated = process();
                valueStack.push(calculated);
            } else if (!c.equals('(') && !Character.isWhitespace(c)) {
                throw new IllegalArgumentException(c.toString());
            }
        }
        return valueStack.pop();
    }

    private Double process() {
        Double second = valueStack.pop();
        Double first = valueStack.pop();
        Character operator = operatorStack.pop();

        switch (operator) {
            case '+': return first + second;
            case '-': return first - second;
            case '*': return first * second;
            case '/': return first / second;
            case '%': return first % second;
            default: return null;
        }
    }
}
