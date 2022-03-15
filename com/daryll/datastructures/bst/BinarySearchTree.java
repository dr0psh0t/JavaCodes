package com.daryll.datastructures.bst;

//  BinaryTreeNode<T extends Comparable<T>>: making only T objects comparable with each other
//  implements Comparable<BinaryTreeNode<T>>: making the BinaryTreeNode objects comparable
class BinaryTreeNode<T extends Comparable<T>> implements Comparable<T> {
    public T data;
    public BinaryTreeNode<T> leftLink;
    public BinaryTreeNode<T> rightLink;

    public BinaryTreeNode(T data) {
        this.data = data;
        leftLink = null;
        rightLink = null;
    }

    @Override
    public String toString() {
        return data+"";
    }

    @Override
    public int compareTo(T o) {
        return data.compareTo(o);
    }
}

public class BinarySearchTree<T extends Comparable<T>> {
    private BinaryTreeNode<T> root;

    public BinarySearchTree() {
        root = null;
    }

    public boolean search(T searchData) {
        if (root == null) {
            return false;
        } else {
            BinaryTreeNode<T> current = root;

            while (current != null) {
                if (current.data.equals(searchData)) {
                    return true;
                } else {
                    if (current.data.compareTo(searchData) > 0) {
                        current = current.leftLink;
                    } else {
                        current = current.rightLink;
                    }
                }
            }
        }

        return false;
    }

    public void insert(T insertData) {
        BinaryTreeNode<T> newNode = new BinaryTreeNode<>(insertData);

        if (root == null) {
            root = newNode;
        } else {
            BinaryTreeNode<T> current;
            BinaryTreeNode<T> trailCurrent = null;

            current = root;

            while (current != null) {
                trailCurrent = current;

                if (current.data.equals(insertData)) {
                    System.err.println(insertData+" has already been inserted.");
                    return;
                } else {
                    if (current.data.compareTo(insertData) > 0) {
                        current = current.leftLink;
                    } else {
                        current = current.rightLink;
                    }
                }
            }

            if (trailCurrent.data.compareTo(insertData) > 0) {
                trailCurrent.leftLink = newNode;
            } else {
                trailCurrent.rightLink = newNode;
            }
        }
    }

    public void delete(T deleteData) {
        BinaryTreeNode<T> current, trailCurrent;
        boolean found = false;

        if (root == null) {
            System.err.println("Cannot delete an empty tree.");
        } else {
            current = trailCurrent = root;

            while (current != null && !found) {
                if (current.data.equals(deleteData)) {
                    found  = true;
                } else {
                    trailCurrent = current;

                    if (current.data.compareTo(deleteData) > 0) {
                        current = current.leftLink;
                    } else {
                        current = current.rightLink;
                    }
                }
            }

            if (current == null) {
                System.err.println("Data to delete in not in tree.");
            } else if (found) {
                if (current == root) {
                    root = deleteFromTree(root);
                } else if (trailCurrent.data.compareTo(deleteData) > 0) {
                    trailCurrent.leftLink = deleteFromTree(trailCurrent.leftLink);
                } else {
                    trailCurrent.rightLink = deleteFromTree(trailCurrent.rightLink);
                }
            }
        }
    }

    private BinaryTreeNode<T> deleteFromTree(BinaryTreeNode<T> node) {
        if (node == null) {
            System.err.println("The node to be deleted is null.");
        } else if (node.leftLink == null && node.rightLink == null) {
            node = null;
        } else if (node.leftLink == null) {
            node = node.rightLink;
        } else if (node.rightLink == null) {
            node = node.leftLink;
        } else {
            BinaryTreeNode<T> current = node.leftLink;
            BinaryTreeNode<T> trailCurrent = null;

            while (current.rightLink != null) {
                trailCurrent = current;
                current = current.rightLink;
            }

            node.data = current.data;

            if (trailCurrent == null) {
                node.leftLink = current.leftLink;
            } else {
                trailCurrent.rightLink = current.leftLink;
            }
        }

        return node;
    }

    public int treeHeight(){return height(root);}

    public int treeNodeCount(){return nodeCount(root);}

    public int treeLeavesCount(){return leafCount(root);}

    private int height(BinaryTreeNode<T> node) {
        if (node == null) {
            return 0;
        } else {
            return 1 + Math.max(height(node.leftLink), height(node.rightLink));
        }
    }

    private int nodeCount(BinaryTreeNode<T> node) {
        if (node == null) {
            return 0;
        } else {
            return 1 + nodeCount(node.leftLink) + nodeCount(node.rightLink);
        }
    }

    private int leafCount(BinaryTreeNode<T> node) {
        if (node == null) {
            return 0;
        } else if (node.leftLink == null && node.rightLink == null) {
            return 1 + leafCount(node.leftLink) + leafCount(node.rightLink);
        } else {
            return leafCount(node.leftLink) + leafCount(node.rightLink);
        }
    }

    public void preorder(){preorderHelper(root);}

    public void inorder(){inorderHelper(root);}

    public void postorder(){postorderHelper(root);}

    //  visit the node, traverse the left subtree, traverse the right subtree.
    private void preorderHelper(BinaryTreeNode<T> node) {
        if (node != null) {
            System.out.print(node+" ");
            preorderHelper(node.leftLink);
            preorderHelper(node.rightLink);
        }
    }

    //  traverse the left subtree, visit the node, traverse the right subtree.
    private void inorderHelper(BinaryTreeNode<T> node) {
        if (node != null) {
            inorderHelper(node.leftLink);
            System.out.print(node+" ");
            inorderHelper(node.rightLink);
        }
    }

    //  traverse the left subtree, traverse the right subtree, visit the node.
    private void postorderHelper(BinaryTreeNode<T> node) {
        if (node != null) {
            postorderHelper(node.leftLink);
            postorderHelper(node.rightLink);
            System.out.print(node+" ");
        }
    }
}