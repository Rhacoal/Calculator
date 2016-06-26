package com.github.rhacoal.calculator.operator.unaryoperator;

import com.github.rhacoal.calculator.exception.CalculationException;
import com.github.rhacoal.calculator.operator.UnaryOperatorNode;

import java.math.BigDecimal;

public class LgOperatorNode extends UnaryOperatorNode {

    @Override
    public BigDecimal calculate() throws CalculationException {
        return new BigDecimal(Math.log10(getChild().calculate().doubleValue()));
    }

    @Override
    public int getPriority() {
        return 100;
    }

}
