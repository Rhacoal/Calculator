package com.github.rhacoal.calculator.operator.binaryoperator;

import com.github.rhacoal.calculator.operator.BinaryOperatorNode;

import java.math.BigDecimal;

public class MultiplicationOperatorNode extends BinaryOperatorNode {

    @Override
    public BigDecimal calculate() {
        return getLeftChild().calculate().multiply(getRightChild().calculate());
    }

    @Override
    public int getPriority() {
        return 20;
    }

}
