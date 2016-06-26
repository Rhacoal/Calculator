package com.github.rhacoal.calculator.operator.unaryoperator;

import com.github.rhacoal.calculator.operator.UnaryOperatorNode;

import java.math.BigDecimal;

public class LnOperatorNode extends UnaryOperatorNode {

    @Override
    public BigDecimal calculate() {
        return new BigDecimal(Math.log10(getChild().calculate().doubleValue()));
    }

    @Override
    public int getPriority() {
        return 100;
    }

}
