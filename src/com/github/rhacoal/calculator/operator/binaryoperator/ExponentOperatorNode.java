package com.github.rhacoal.calculator.operator.binaryoperator;

import com.github.rhacoal.calculator.exception.CalculationException;
import com.github.rhacoal.calculator.operator.BinaryOperatorNode;

import java.math.BigDecimal;

public class ExponentOperatorNode extends BinaryOperatorNode {

    @Override
    public BigDecimal calculate() throws CalculationException {
        int power = getRightChild().calculate().intValue();
        return getLeftChild().calculate().movePointRight(power);
    }

    @Override
    public int getPriority() {
        return 40;
    }
}
