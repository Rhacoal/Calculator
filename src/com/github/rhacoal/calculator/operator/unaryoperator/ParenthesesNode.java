package com.github.rhacoal.calculator.operator.unaryoperator;

import com.github.rhacoal.calculator.operator.UnaryOperatorNode;

import java.math.BigDecimal;

public class ParenthesesNode extends UnaryOperatorNode {

    boolean raised = false;

    @Override
    public BigDecimal calculate() {
        return getChild().calculate();
    }

    @Override
    public int getPriority() {
        return raised ? 10000 : 0;
    }

    public void raisePriority() {
        this.raised = true;
    }

    @Override
    public boolean isParentheses() {
        return true;
    }

    public boolean isClose() {
        return raised;
    }
}
