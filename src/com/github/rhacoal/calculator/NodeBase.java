package com.github.rhacoal.calculator;

import com.github.rhacoal.calculator.specialnode.NumberNode;
import com.github.rhacoal.calculator.specialnode.PairNode;
import com.github.rhacoal.calculator.operator.BinaryOperatorNode;
import com.github.rhacoal.calculator.operator.UnaryOperatorNode;

import java.math.BigDecimal;

/**
 * Basic Node.
 * @see UnaryOperatorNode
 * @see BinaryOperatorNode
 * @see NumberNode
 * @see PairNode
 */
public interface NodeBase {

    NodeType getNodeType();

    BigDecimal calculate();

    int getPriority();

    default boolean isNumber() {
        return false;
    }

    default boolean isOperator() {
        return false;
    }

    default boolean isRoot() {
        return false;
    }

    default boolean isParentheses() {
        return false;
    }

}
