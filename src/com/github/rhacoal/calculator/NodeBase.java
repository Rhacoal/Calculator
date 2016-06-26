package com.github.rhacoal.calculator;

import com.github.rhacoal.calculator.exception.CalculationException;
import com.github.rhacoal.calculator.specialnode.NumberNode;
import com.github.rhacoal.calculator.operator.BinaryOperatorNode;
import com.github.rhacoal.calculator.operator.UnaryOperatorNode;

import java.math.BigDecimal;

/**
 * Basic Node.
 * @see UnaryOperatorNode
 * @see BinaryOperatorNode
 * @see NumberNode
 */
public interface NodeBase {

    NodeType getNodeType();

    BigDecimal calculate() throws CalculationException;

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

    default boolean isPair() {
        return false;
    }
}
