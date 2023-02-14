package com.xuan.structures.tree;

public class BinarySearchTree <E extends Comparable<E>>{
    private class Node{
        public E value;
        public Node left;
        public Node right;

        public Node(E value){
            this.value = value;
            this.left = null;
            this.right = null;
        }
        public Node(){
            this(null);
        }
    }
    private Node root;
    private int size;

    public BinarySearchTree(){
        this.root = null;
        this.size = 0;
    }

    public int getSize(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }

    public void add(E e){
        root = add(root, e);
    }

    private Node add(Node node, E e){
        if (node == null){
            size ++;
            return new Node(e);
        }
        if (e.compareTo(node.value) > 0){
            node.right = add(node.right, e);
        }else if (e.compareTo(node.value) < 0){
            node.left = add(node.left, e);
        }
        return node;
    }

    private Boolean contains(E e){
        if (size == 0) return false;
        return contains(root, e);
    }

    private Boolean contains(Node node, E e){
        if (node == null) return false;
        if (e.compareTo(node.value) < 0){
            return contains(node.left, e);
        }else if (e.compareTo(node.value) > 0){
            return contains(node.right, e);
        }else {
            return true;
        }
    }

    public void preOrder(){
        preOrder(root);
    }

    private void preOrder(Node node){
        if (node == null) return;
        System.out.println(node.value);
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder(){
        inOrder(root);
    }

    private void inOrder(Node node){
        if (node == null) return;
        inOrder(node.left);
        System.out.println(node.value);
        inOrder(node.right);
    }

    public void postOrder(){
        postOrder(root);
    }

    private void postOrder(Node node){
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.value);
    }

    public E minimum(){
        if (size == 0) throw new RuntimeException("bst is empty.");
        return minimum(root).value;
    }

    private Node minimum(Node node){
        if (node.left == null) return node;
        return minimum(node.left);
    }

    public E maximum(){
        if (size == 0) throw new RuntimeException("bst is empty.");
        return maximum(root).value;
    }

    private Node maximum(Node node){
        if (node.right == null) return node;
        return maximum(node.right);
    }

    public E removeMin(){
        if (size == 0) throw new RuntimeException("bst is empty.");
        E res = minimum();
        root = removeMin(root);
        return res;
    }

    private Node removeMin(Node node){
        if (node.left == null){
            Node rightNode = node.right;
            node.right = null;
            size -- ;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    public E removeMax(){
        if (size == 0) throw new RuntimeException("bst is empty.");
        E res = maximum();
        root = removeMax(root);
        return res;
    }

    public void remove(E e){
        if (size == 0) throw new RuntimeException("bst is empty.");
        root = remove(root, e);
    }

    private Node remove(Node node, E e){
        if (node == null){
            return null;
        }
        if (e.compareTo(node.value) < 0){
            return remove(node.left, e);
        }else if (e.compareTo(node.value) > 0){
            return remove(node.right, e);
        }else {
            // e.compareTo(node.value) == 0
            if (node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size --;
                return leftNode;
            }
            if (node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size --;
                return rightNode;
            }

            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.left = node.right = null;
            return successor;
        }
    }

    private Node removeMax(Node node){
        if (node.right == null){
            Node leftNode = node.left;
            node.left = null;
            size --;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        generateBSTString(root, 0, sb);
        return sb.toString();
    }

    private void generateBSTString(Node node, int depth, StringBuilder res){
        if (node == null){
            res.append(generateDepthString(depth) + "null \n");
            return;
        }
        res.append(generateDepthString(depth) + node.value + "\n");
        generateBSTString(node.left, depth + 1 , res);
        generateBSTString(node.right, depth + 1 , res);

    }

    private String generateDepthString(int depth){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < depth; i ++){
            sb.append("--");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.add(5);
        bst.add(1);
        bst.add(10);
        bst.add(8);
        bst.add(3);
        bst.add(0);
        System.out.println(bst.removeMax());
        System.out.println();
        System.out.println(bst);
    }
}
