package com.github.rhacoal.calculator.operator;

import com.github.rhacoal.calculator.exception.CalculationException;

public interface PairOperatorNode extends OperatorNode{

    default BinaryOperatorNode getPairChild() throws CalculationException {
        if (getChild() == null || !getChild().isOperator()) {
            throw new CalculationException("A pair needed for the operator: " + getClass().getSimpleName());
        }
        OperatorNode node = (OperatorNode) getChild();
        while (!node.isPair()) {
            if (node.getChild().isOperator()) {
                node = (OperatorNode) node.getChild();
            } else {
                throw new CalculationException("A pair needed for the operator: " + getClass().getName());
            }
        }
        return (BinaryOperatorNode) node;
    }

}
