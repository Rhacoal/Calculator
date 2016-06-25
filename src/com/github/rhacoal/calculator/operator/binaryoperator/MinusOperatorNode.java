package com.github.rhacoal.calculator.operator.binaryoperator;

import com.github.rhacoal.calculator.operator.BinaryOperatorNode;

import java.math.BigDecimal;

public class MinusOperatorNode extends BinaryOperatorNode {

    @Override
    public BigDecimal calculate() {
        return getLeftChild().calculate().subtract(getRightChild().calculate());
    }

    @Override
    public int getPriority() {
        return 10;
    }
}
