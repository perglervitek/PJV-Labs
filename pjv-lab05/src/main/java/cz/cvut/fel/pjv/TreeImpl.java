package cz.cvut.fel.pjv;

import java.util.Arrays;

public class TreeImpl implements Tree{
    private Node rootNode = null;

    // Main method for testing
//         public static void main(String[] args) {
//            for(int i = 0; i <= 10; i++){
//                Tree tree = new TreeImpl();
//                int[] arr = new int[i];
//                for (int j=0; j < i; j++){
//                    arr [j] = j+1;
//                }
//                tree.setTree(arr);
//                System.out.println(tree);
//            }
//        }

    @Override
    public void setTree(int[] values){
        if(values.length == 0) return;
//        System.out.println(Arrays.toString(values));
        rootNode = this.toNode(values, 0, values.length-1);
    }

    public Node toNode(int[] values, int start, int end){
        Node node = null;
        if(start <= end) {
            int rootPosition = (start +end)/2;
            if((end-start) % 2 != 0) rootPosition+=1;
            node = new NodeImpl(values[rootPosition], toNode(values, start, rootPosition-1), toNode(values, rootPosition+1, end));
        }
        return node;
    }

    @Override
    public String toString (){
        StringBuilder sb = new StringBuilder();
        return nodeToString(sb,0, this.rootNode).toString();
    }

    private StringBuilder nodeToString(StringBuilder sb, int spaces, Node node){
        if(node == null) return sb;
        for(int i = 0; i < spaces; i++){
            sb.append(" ");
        }
        sb.append("- "+node.getValue()+"\n");
        sb= nodeToString(sb,spaces+1, node.getLeft());
        sb =nodeToString(sb,spaces+1, node.getRight());
        return sb;
    }

    @Override
    public Node getRoot() {
        return this.rootNode;
    }

}
