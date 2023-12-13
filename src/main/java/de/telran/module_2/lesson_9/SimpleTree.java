package de.telran.module_2.lesson_9;

public class SimpleTree {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.insert(1, "Node1");
        binaryTree.insert(3, "Node3");
        binaryTree.insert(2, "Node2");
        binaryTree.insert(4, "Node4");
        binaryTree.insert(6, "Node6");
        binaryTree.insert(0, "Node0");

        System.out.println(binaryTree.find(4));

        binaryTree.print();

        Node root = binaryTree.getRoot();

//        Util.breadthFirstSearch(root, 3);

       Util.depthInorder(root);
        System.out.println();
       Util.depthInorderStack(root);
        System.out.println();
        Util.depthPreorder(root);
    }

}
