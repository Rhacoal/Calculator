package com.github.rhacoal.calculator.operator.binaryoperator;

import com.github.rhacoal.calculator.exception.CalculationException;
import com.github.rhacoal.calculator.operator.BinaryOperatorNode;

import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class ModAndRemOperatorNode extends BinaryOperatorNode {

    @Override
    public int getPriority() {
        return 30;
    }

    public static class RemOperatorNode extends ModAndRemOperatorNode {

        @Override
        public BigDecimal calculate() throws CalculationException {
            return getLeftChild().calculate().remainder(getRightChild().calculate());
        }

    }

    public static class ModOperatorNode extends ModAndRemOperatorNode {

        @Override
        public BigDecimal calculate() throws CalculationException {
            BigDecimal lval = getLeftChild().calculate();
            BigDecimal rval = getRightChild().calculate();
            return lval.subtract(rval.multiply(new BigDecimal(lval.divide(rval, 0 , RoundingMode.FLOOR).toBigInteger())));
        }

    }

}
