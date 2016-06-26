package com.github.rhacoal.calculator.operator.binaryoperator;

import com.github.rhacoal.calculator.exception.CalculationException;
import com.github.rhacoal.calculator.operator.BinaryOperatorNode;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class DivisionOperatorNode extends BinaryOperatorNode {

    @Override
    public BigDecimal calculate() throws CalculationException {
        return getLeftChild().calculate().divide(getRightChild().calculate(), 20, RoundingMode.HALF_DOWN);
    }

    @Override
    public int getPriority() {
        return 20;
    }

}
