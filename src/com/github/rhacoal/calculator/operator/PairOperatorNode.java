package com.github.rhacoal.calculator.operator;

public interface PairOperatorNode extends OperatorNode{

    default BinaryOperatorNode getPairChild() {
        if (getChild() == null || !getChild().isOperator()) {
            throw new ArithmeticException("A pair needed for the operator: " + getClass().getName());
        }
        OperatorNode node = (OperatorNode) getChild();
        while (!node.isPair()) {
            if (node.getChild().isOperator()) {
                node = (OperatorNode) node.getChild();
            } else {
                throw new ArithmeticException("A pair needed for the operator: " + getClass().getName());
            }
        }
        return (BinaryOperatorNode) node;
    }

}
