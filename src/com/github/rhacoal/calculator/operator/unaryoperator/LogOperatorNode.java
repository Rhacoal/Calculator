package com.github.rhacoal.calculator.operator.unaryoperator;

import com.github.rhacoal.calculator.exception.CalculationException;
import com.github.rhacoal.calculator.operator.BinaryOperatorNode;
import com.github.rhacoal.calculator.operator.PairOperatorNode;
import com.github.rhacoal.calculator.operator.UnaryOperatorNode;

import java.math.BigDecimal;

public class LogOperatorNode extends UnaryOperatorNode implements PairOperatorNode{

    @Override
    public BigDecimal calculate() throws CalculationException {
        BinaryOperatorNode bon = getPairChild();
        return new BigDecimal(Math.log(bon.getRightChild().calculate().doubleValue()) / Math.log(bon.getLeftChild().calculate().doubleValue()));
    }

    @Override
    public int getPriority() {
        return 100;
    }

}
