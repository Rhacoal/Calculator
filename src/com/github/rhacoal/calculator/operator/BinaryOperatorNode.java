package com.github.rhacoal.calculator.operator;

import com.github.rhacoal.calculator.NodeBase;
import com.github.rhacoal.calculator.NodeType;

public abstract class BinaryOperatorNode implements OperatorNode {

    private NodeBase leftNode = null, rightNode = null;
    private OperatorNode parent = null;

    public void setLeftChild(NodeBase nb) {
        this.leftNode = nb;
    }

    public NodeBase getLeftChild() {
        return leftNode;
    }

    public void setRightChild(NodeBase nb) {
        this.rightNode = nb;
    }

    public NodeBase getRightChild() {
        return rightNode;
    }

    @Override
    public NodeType getNodeType() {
        return NodeType.BINARY;
    }

    @Override
    public NodeBase getChild() {
        return getRightChild();
    }

    @Override
    public NodeBase setChild(NodeBase child) {
        NodeBase nb = getRightChild();
        setRightChild(child);
        return nb;
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
