package com.github.rhacoal.calculator;

import com.github.rhacoal.calculator.operator.binaryoperator.*;
import com.github.rhacoal.calculator.operator.suffixoperator.FactorialOperatorNode;
import com.github.rhacoal.calculator.operator.unaryoperator.*;

import static com.github.rhacoal.calculator.NodeType.*;
import static com.github.rhacoal.calculator.operator.OperatorNode.registerOperator;

public class Registration {

    public static void register() {
        registerOperator("+", PlusOperatorNode.class, BINARY);
        registerOperator("-", MinusOperatorNode.class, BINARY);
        registerOperator("*", MultiplicationOperatorNode.class, BINARY);
        registerOperator("/", DivisionOperatorNode.class, BINARY);
        registerOperator("e", ExponentOperatorNode.class, BINARY);
        registerOperator("^", PowerOperatorNode.class, BINARY);
        registerOperator(",", CommaOperatorNode.class, BINARY);
        registerOperator("mod", ModAndRemOperatorNode.ModOperatorNode.class, BINARY);
        registerOperator("rem", ModAndRemOperatorNode.RemOperatorNode.class, BINARY);
        registerOperator("%", ModAndRemOperatorNode.RemOperatorNode.class, BINARY);

        registerOperator("(", ParenthesesNode.class, PREFIX);
        registerOperator("-", UnaryMinusOperatorNode.class, PREFIX);
        registerOperator("+", UnaryPlusOperator.class, PREFIX);
        registerOperator("log", LogOperatorNode.class, PREFIX);
        registerOperator("lg", LgOperatorNode.class, PREFIX);
        registerOperator("ln", LnOperatorNode.class, PREFIX);

        registerOperator("!", FactorialOperatorNode.class, SUFFIX);
    }

}
