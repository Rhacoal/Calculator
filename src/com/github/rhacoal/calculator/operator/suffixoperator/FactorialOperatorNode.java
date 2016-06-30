package com.github.rhacoal.calculator.operator.suffixoperator;

import com.github.rhacoal.calculator.exception.CalculationException;
import com.github.rhacoal.calculator.operator.SuffixOperatorNode;

import java.math.BigDecimal;
import java.math.BigInteger;

public class FactorialOperatorNode extends SuffixOperatorNode {

    @Override
    public BigDecimal calculate() throws CalculationException {
        int val = getChild().calculate().intValue();
        if (val < 0) throw new CalculationException("Smaller than 0");
        BigInteger ret = BigInteger.ONE;
        for (int i = 1; i <= val; i ++) {
            ret = ret.multiply(BigInteger.valueOf(i));
        }
        return new BigDecimal(ret);
    }

    @Override
    public int getPriority() {
        return 100;
    }
}
