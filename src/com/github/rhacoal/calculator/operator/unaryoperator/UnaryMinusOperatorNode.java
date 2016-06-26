package com.github.rhacoal.calculator.operator.unaryoperator;


import com.github.rhacoal.calculator.exception.CalculationException;
import com.github.rhacoal.calculator.operator.UnaryOperatorNode;

import java.math.BigDecimal;

public class UnaryMinusOperatorNode extends UnaryOperatorNode {

    @Override
    public BigDecimal calculate() throws CalculationException {
        return getChild().calculate().negate();
    }

    @Override
    public int getPriority() {
        return 100;
    }
}
