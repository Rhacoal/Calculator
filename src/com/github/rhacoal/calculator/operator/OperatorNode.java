package com.github.rhacoal.calculator.operator;

import com.github.rhacoal.calculator.NodeBase;
import com.github.rhacoal.calculator.NodeType;
import com.github.rhacoal.calculator.exception.CalculationException;

import java.util.HashMap;
import java.util.Map;

public interface OperatorNode extends NodeBase {

    default boolean isOperator() {
        return true;
    }

    NodeBase getChild();

    /**
     * Replace a child
     * @return The child being replaced.
     */
    NodeBase setChild(NodeBase child);

    OperatorNode getParent();

    NodeBase setParent(OperatorNode node);


    Map<String, Class<? extends OperatorNode>> prefixMap = new HashMap<>();
    Map<String, Class<? extends OperatorNode>> binaryMap = new HashMap<>();

    static void registerOperator(String name, Class<? extends OperatorNode> clazz, NodeType type) {
        switch (type) {
            case BINARY: case SUFFIX:
                binaryMap.put(name, clazz);
                break;
            case PREFIX:
                prefixMap.put(name, clazz);
                break;
            case NUMBER:
                throw new IllegalArgumentException("Number nodes not allowed to register!");
        }
    }

    static OperatorNode getOperator(String name, NodeType type) throws CalculationException {
        Class<? extends OperatorNode> clazz = null;
        switch (type) {
            case BINARY: case SUFFIX:
                clazz = binaryMap.get(name);
                break;
            case PREFIX:
                clazz = prefixMap.get(name);
                break;
            case NUMBER:
                throw new CalculationException("No number as operators.");
        }
        if (clazz == null)
            throw new CalculationException(
                    (type == NodeType.BINARY ? "Binary" : "Unary") + " operator \"" + name + "\" doesn't exist."
            );
        else {
            OperatorNode node;
            try {
                node = clazz.newInstance();
            } catch (InstantiationException | IllegalAccessException ex) {
                throw new CalculationException(
                        "Operator \"" + name + "\" is unavailable to be created an instance with."
                );
            }
            return node;
        }
    }

    static OperatorNode getOperator(char name, NodeType type) throws CalculationException {
        return getOperator(new String(new char[]{name}),type);
    }

}
