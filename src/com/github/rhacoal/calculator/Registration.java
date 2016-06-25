package com.github.rhacoal.calculator;

import com.github.rhacoal.calculator.operator.OperatorNode;
import com.github.rhacoal.calculator.operator.binaryoperator.*;
import com.github.rhacoal.calculator.operator.unaryoperator.UnaryMinusOperatorNode;
import com.github.rhacoal.calculator.specialnode.PairNode;
import com.github.rhacoal.calculator.operator.unaryoperator.ParenthesesNode;

public class Registration {

    public static void register() {
        OperatorNode.registerOperator("+", PlusOperatorNode.class, NodeType.BINARY);
        OperatorNode.registerOperator("-", MinusOperatorNode.class, NodeType.BINARY);
        OperatorNode.registerOperator("*", MultiplicationOperatorNode.class, NodeType.BINARY);
        OperatorNode.registerOperator("/", DivisionOperatorNode.class, NodeType.BINARY);
        OperatorNode.registerOperator("e", ExponentOperatorNode.class, NodeType.BINARY);
        OperatorNode.registerOperator("^", PowerOperatorNode.class, NodeType.BINARY);
        OperatorNode.registerOperator(",", PairNode.class, NodeType.PAIR);
        OperatorNode.registerOperator("mod", ModAndRemOperatorNode.ModOperatorNode.class, NodeType.BINARY);
        OperatorNode.registerOperator("rem", ModAndRemOperatorNode.RemOperatorNode.class, NodeType.BINARY);

        OperatorNode.registerOperator("(", ParenthesesNode.class, NodeType.UNARY);
        OperatorNode.registerOperator("-", UnaryMinusOperatorNode.class, NodeType.UNARY);
    }

}
