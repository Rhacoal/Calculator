package com.github.rhacoal.calculator.operator.binaryoperator;

import com.github.rhacoal.calculator.operator.BinaryOperatorNode;

import java.math.BigDecimal;

public class PlusOperatorNode extends BinaryOperatorNode {

    public BigDecimal calculate() {
        return getLeftChild().calculate().add(getRightChild().calculate());
    }

    @Override
    public int getPriority() {
        return 10;
    }
}
