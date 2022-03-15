package com.daryll.datastructures.bst;

public class BSTTest {
    public static void main(String[] args) {

        /*BinarySearchTree<Character> bsTree = new BinarySearchTree<>();

        char[] alpha = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j'};

        bsTree.insert('e');
        bsTree.insert('c');
        bsTree.insert('h');
        bsTree.insert('i');
        bsTree.insert('j');
        bsTree.insert('a');
        bsTree.insert('d');

        for(int g = 0; g < 10; ++g) {
            System.out.println((bsTree.search(alpha[g]) ? alpha[g] + " is found" : alpha[g] + " isn't found"));
        }*/

        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(60);
        bst.insert(50);
        bst.insert(30);
        bst.insert(58);
        bst.insert(46);
        bst.insert(70);
        bst.insert(80);
        bst.insert(77);

        /*BinarySearchTree<String> bst = new BinarySearchTree<>();
        bst.insert("B");
        bst.insert("C");
        bst.insert("A");*/

        bst.preorder();
        System.out.println();

        bst.inorder();
        System.out.println();

        bst.postorder();
        System.out.println();

        System.out.println("Tree height: "+bst.treeHeight());
        System.out.println("# of nodes: "+bst.treeNodeCount());
        System.out.println("# of leaf nodes: "+bst.treeLeavesCount());
    }
}
