package cz.cvut.fel.pjv;

public class NodeImpl implements Node{
    private int val;
    private Node leftNode;
    private Node rightNode;

    public NodeImpl(int val, Node leftNode, Node rightNode){
        this.val = val;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    @Override
    public int getValue(){
        return this.val;
    }
    @Override
    public Node getLeft(){
        return this.leftNode;
    }
    @Override
    public Node getRight(){
        return this.rightNode;
    }

}
