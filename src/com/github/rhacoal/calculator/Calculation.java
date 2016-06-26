package com.github.rhacoal.calculator;

import com.github.rhacoal.calculator.exception.CalculationException;
import com.github.rhacoal.calculator.operator.OperatorNode;
import com.github.rhacoal.calculator.operator.unaryoperator.RootNode;
import com.github.rhacoal.calculator.operator.BinaryOperatorNode;
import com.github.rhacoal.calculator.operator.unaryoperator.ParenthesesNode;
import com.github.rhacoal.calculator.specialnode.NumberNode;

import java.math.BigDecimal;

public class Calculation {

    private final String expression;
    private int index = 0;
    private RootNode rootNode = null;
    private OperatorNode former = null;

    private enum ExpectationType {
        UnaryOrNumber, BinaryOrRightParentheses, Null
    }
    
    private ExpectationType expectUnaryOrNumber() throws CalculationException {

        if (index == expression.length() - 1)                                       //end of expression
            return ExpectationType.Null;

        NodeBase nb;
        char previous = expression.charAt(index);
        if ((between(previous, '0', '9')) || previous == '.') {                 //number
            nb = readNumber();
        } else {
            if (between(previous, 'a', 'z')) {                                  //unary like "sqrt"
                nb = OperatorNode.getOperator(readWord(), NodeType.UNARY);
            } else {                                                            //unary like "-"
                nb = OperatorNode.getOperator(previous, NodeType.UNARY);
                ++ index;
            }
        }

        if (nb.isNumber()) {
            former.setChild(nb);
            return ExpectationType.BinaryOrRightParentheses;
        } else if (nb.isOperator()) {
            ((OperatorNode)nb).setParent(former);
            former = (OperatorNode)nb;
            return ExpectationType.UnaryOrNumber;
        }

        return ExpectationType.Null;

    }
    
    private ExpectationType expectBinaryOrRightParentheses() throws CalculationException {

        if (index == expression.length() - 1)                                       //end of expression
            return ExpectationType.Null;

        NodeBase nb;
        char previous = expression.charAt(index);
        if (previous == ')') {                                                      //right parentheses
            while ((!former.isParentheses()) || ((ParenthesesNode) former).isClose()) {
                former = former.getParent();
                if (former == null) {
                    throw new CalculationException("Position " + (index + 1) + " expected a left parentheses");
                }
            }
            ((ParenthesesNode) former).raisePriority();
            former = former.getParent();
            ++ index;
            return ExpectationType.BinaryOrRightParentheses;
        } else if (between(previous, 'a', 'z')) {                                   //binary like "mod"
            nb = OperatorNode.getOperator(readWord(), NodeType.BINARY);
        } else {                                                                    //binary like "+"
            nb = OperatorNode.getOperator(previous, NodeType.BINARY);
            ++ index;
        }

        OperatorNode on = former;
        BinaryOperatorNode node = (BinaryOperatorNode) nb;
        while (nb.getPriority() <= on.getPriority()) {
            on = on.getParent();
        }
        NodeBase on_child = node.setParent(on);             //find the node with lower priority
        node.setLeftChild(on_child);                        //exchange the node's position with the previous one
        former = node;
        return ExpectationType.UnaryOrNumber;

    }

    private NumberNode readNumber() {
        int start_point = index;
        while (index < expression.length()
                && ((between(expression.charAt(index), '0', '9'))
                    || expression.charAt(index) == '.')) {
            index ++;
        }
        return new NumberNode(new BigDecimal(expression.substring(start_point, index)));
    }

    private String readWord() {
        int start_point = index;
        while (between(expression.charAt(index), 'a', 'z')) {
            index ++;
        }
        return expression.substring(start_point, index);
    }

    private String readOperator () {
        int start_point = index;
        while (!(between(expression.charAt(index), '0', '9')
                || expression.charAt(index) == '.')
                || between(expression.charAt(index), 'a', 'z')
                || between(expression.charAt(index), 'A', 'Z')) {
            index ++;
        }
        return expression.substring(start_point, index);
    }

    private static boolean between(char c, char c1, char c2) {
        return c >= c1 && c <= c2;
    }

    public BigDecimal calculate() throws CalculationException {
        rootNode = new RootNode();
        former = rootNode;
        ExpectationType et = ExpectationType.UnaryOrNumber;
        while(et != ExpectationType.Null) {
            switch (et) {
                case UnaryOrNumber:
                    et = expectUnaryOrNumber();
                    break;
                case BinaryOrRightParentheses:
                    et = expectBinaryOrRightParentheses();
                    break;
                default:
                    break;
            }
        }
        try {
            return rootNode.calculate();
        } catch (ArithmeticException ae) {
            throw new CalculationException(ae.getMessage());
        }
    }

    public Calculation(String expression) {
        this.expression = expression.toLowerCase().replace(" ", "") + " ";
    }

}
