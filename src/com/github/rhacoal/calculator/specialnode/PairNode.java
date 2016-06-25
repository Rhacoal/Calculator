package com.github.rhacoal.calculator.specialnode;

import com.github.rhacoal.calculator.NodeType;
import com.github.rhacoal.calculator.operator.BinaryOperatorNode;

import java.math.BigDecimal;

public class PairNode extends BinaryOperatorNode {

    @Override
    public BigDecimal calculate() {
        return null;
    }

    @Override
    public int getPriority() {
        return 1000;
    }

    @Override
    public NodeType getNodeType() {
        return NodeType.PAIR;
    }

}
