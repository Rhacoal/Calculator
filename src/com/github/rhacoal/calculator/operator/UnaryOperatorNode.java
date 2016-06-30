package com.github.rhacoal.calculator.operator;

import com.github.rhacoal.calculator.NodeBase;
import com.github.rhacoal.calculator.NodeType;

public abstract class UnaryOperatorNode implements OperatorNode {

    private NodeBase child;
    private OperatorNode parent;

    @Override
    public NodeBase setChild(NodeBase child) {
        NodeBase nb = getChild();
        this.child = child;
        return nb;
    }

    @Override
    public NodeBase getChild() {
        return child;
    }

    @Override
    public NodeType getNodeType() {
        return NodeType.PREFIX;
    }

    @Override
    public NodeBase setParent(OperatorNode node) {
        this.parent = node;
        return node.setChild(this);
    }

    @Override
    public OperatorNode getParent() {
        return parent;
    }

}
