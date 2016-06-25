package com.github.rhacoal.calculator;

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

    private void expectUnaryOrNumber() throws CalculationException {

        if (index == expression.length() - 1)                                       //end of expression
            return;

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
            expectBinaryOrRightParentheses();
        } else if (nb.isOperator()) {
            ((OperatorNode)nb).setParent(former);
            former = (OperatorNode)nb;
            expectUnaryOrNumber();
        }

    }

    private void expectBinaryOrRightParentheses() throws CalculationException {

        if (index == expression.length() - 1)                                       //end of expression
            return;

        NodeBase nb;
        char previous = expression.charAt(index);
        if (previous == ')') {                                                      //right parentheses
            if (former == null) {
                throw new CalculationException(expression.substring(0, index + 1) + " doesn't have a left parentheses");
            } else {
                while ((!former.isParentheses()) || ((ParenthesesNode) former).isClose()) {
                    former = former.getParent();
                }
                ((ParenthesesNode) former).raisePriority();
            }
            former = former.getParent();
            ++ index;
            expectBinaryOrRightParentheses();
            return;
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
        expectUnaryOrNumber();

    }


    private NumberNode readNumber() {
        int start_point = index;
        while (index < expression.length() && ((between(expression.charAt(index), '0', '9')) || expression.charAt(index) == '.')) {
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

    private static boolean between(char c, char c1, char c2) {
        return c >= c1 && c <= c2;
    }

    public BigDecimal calculate() throws CalculationException {
        rootNode = new RootNode();
        former = rootNode;
        expectUnaryOrNumber();
        return rootNode.calculate();
    }

    public Calculation(String expression) {
        this.expression = expression.toLowerCase() + " ";
    }

}
