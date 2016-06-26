package com.github.rhacoal.calculator;

import com.github.rhacoal.calculator.operator.binaryoperator.*;
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

        registerOperator("(", ParenthesesNode.class, UNARY);
        registerOperator("-", UnaryMinusOperatorNode.class, UNARY);
        registerOperator("log", LogOperatorNode.class, UNARY);
        registerOperator("lg", LgOperatorNode.class, UNARY);
        registerOperator("ln", LnOperatorNode.class, UNARY);
    }

}
