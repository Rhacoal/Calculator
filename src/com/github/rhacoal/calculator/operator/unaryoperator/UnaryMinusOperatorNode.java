package com.github.rhacoal.calculator.operator.unaryoperator;


import com.github.rhacoal.calculator.operator.UnaryOperatorNode;

import java.math.BigDecimal;

public class UnaryMinusOperatorNode extends UnaryOperatorNode {

    @Override
    public BigDecimal calculate() {
        return getChild().calculate().negate();
    }

    @Override
    public int getPriority() {
        return 100;
    }
}
