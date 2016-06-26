package com.github.rhacoal.calculator.operator;

import com.github.rhacoal.calculator.exception.CalculationException;

public interface PairOperatorNode extends OperatorNode{

    default BinaryOperatorNode getPairChild() throws ArithmeticException {
        if (!getChild().isOperator()) {
            throw new ArithmeticException("A pair needed for the operator: " + getClass().getName());
        }
        OperatorNode node = (OperatorNode) getChild();
        if (!node.isPair()) {
            if (node.getChild().isOperator()) {
                node = (OperatorNode) node.getChild();
            } else {
                throw new ArithmeticException("A pair needed for the operator: " + getClass().getName());
            }
        }
        return (BinaryOperatorNode) node;
    }

}
