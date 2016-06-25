package com.github.rhacoal.calculator.operator.binaryoperator;

import com.github.rhacoal.calculator.operator.BinaryOperatorNode;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PowerOperatorNode extends BinaryOperatorNode {

    @Override
    public BigDecimal calculate() {
        BigDecimal rval = getRightChild().calculate();
        if (rval.subtract(new BigDecimal(rval.intValue())).abs().doubleValue() < 1E-12)
            return getLeftChild().calculate().pow(getRightChild().calculate().intValue());
        else
            return new BigDecimal(Math.pow(getLeftChild().calculate().doubleValue(), rval.doubleValue())).setScale(10, RoundingMode.HALF_DOWN);
    }

    @Override
    public int getPriority() {
        return 30;
    }
}
