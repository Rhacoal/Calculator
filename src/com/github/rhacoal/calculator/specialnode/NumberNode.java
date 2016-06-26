package com.github.rhacoal.calculator.specialnode;

import com.github.rhacoal.calculator.NodeType;
import com.github.rhacoal.calculator.NodeBase;
import com.github.rhacoal.calculator.exception.CalculationException;

import java.math.BigDecimal;

public class NumberNode implements NodeBase {

    private final BigDecimal value;

    @Override
    public NodeType getNodeType() {
        return NodeType.NUMBER;
    }

    @Override
    public BigDecimal calculate() throws CalculationException {
        return value;
    }

    @Override
    public boolean isNumber() {
        return true;
    }

    @Override
    public int getPriority() {
        return Integer.MAX_VALUE;
    }

    public BigDecimal getValue() {
        return value;
    }

    public NumberNode(BigDecimal value) {
        this.value = value;
    }

    public NumberNode(String value) {
        this(new BigDecimal(value));
    }

}
