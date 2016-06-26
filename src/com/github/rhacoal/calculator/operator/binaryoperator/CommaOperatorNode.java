package com.github.rhacoal.calculator.operator.binaryoperator;

import com.github.rhacoal.calculator.exception.CalculationException;
import com.github.rhacoal.calculator.operator.BinaryOperatorNode;

import java.math.BigDecimal;

public class CommaOperatorNode extends BinaryOperatorNode {

    @Override
    public BigDecimal calculate() throws CalculationException {
        return getRightChild().calculate();
    }

    @Override
    public int getPriority() {
        return 1;
    }

    @Override
    public boolean isPair() {
        return true;
    }
}
