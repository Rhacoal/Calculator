package com.github.rhacoal.calculator.operator;

import com.github.rhacoal.calculator.NodeBase;
import com.github.rhacoal.calculator.NodeType;

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


    Map<String, Class<? extends OperatorNode>> unaryMap = new HashMap<>();
    Map<String, Class<? extends OperatorNode>> binaryMap = new HashMap<>();

    static void registerOperator(String name, Class<? extends OperatorNode> clazz, NodeType type) {
        switch (type) {
            case BINARY: case PAIR:
                binaryMap.put(name, clazz);
                break;
            case UNARY:
                unaryMap.put(name, clazz);
                break;
            case NUMBER:
                throw new IllegalArgumentException("Number nodes not allowed to register!");
        }
    }

    static OperatorNode getOperator(String name, NodeType type) {
        Class<? extends OperatorNode> clazz = null;
        switch (type) {
            case BINARY: case PAIR:
                clazz = binaryMap.get(name);
                break;
            case UNARY:
                clazz = unaryMap.get(name);
                break;
            case NUMBER:
                throw new IllegalArgumentException("Number nodes not allowed for this method!");
        }
        if (clazz == null)
            return null;
        else {
            OperatorNode node;
            try {
                node = clazz.newInstance();
            } catch (InstantiationException ex) {
                return null;
            } catch (IllegalAccessException ex) {
                return null;
            }
            return node;
        }
    }

    static OperatorNode getOperator(char name, NodeType type) {
        return getOperator(new String(new char[]{name}),type);
    }

}
