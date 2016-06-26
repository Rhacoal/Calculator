package com.github.rhacoal.calculator.operator.unaryoperator;

import com.github.rhacoal.calculator.exception.CalculationException;
import com.github.rhacoal.calculator.operator.UnaryOperatorNode;

import java.math.BigDecimal;

public class UnaryPlusOperator extends UnaryOperatorNode {

    @Override
    public BigDecimal calculate() throws CalculationException {
        return getChild().calculate();
    }

    @Override
    public int getPriority() {
        return 100;
    }
}
