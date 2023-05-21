import java.util.ArrayList;
public class BST<K extends Comparable<K>, V> {
    private Node root;
    private int size = 0;
    private class Node {
        private K key;
        private V val;
        private Node left, right;
        // constructor
        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }
        // String representation of node
        @Override
        public String toString() {
            return "{Key is: " + this.key + " " + "and value is: " + this.val + "}";
        }
    }
    /*
    put -  inserts a new node into the tree with the given key value pair
    @return node
     */
    public void put(K key, V val) {
        this.root = put(root, key, val);
        size++;
    }
    public Node put(Node node, K key, V val) {
        if(node == null) {
            return new Node(key, val);
        }
        if(node.key.compareTo(key) < 0) {
            node.left = put(node.left, key, val);
        }
        else if(node.key.compareTo(key) > 0) {
            node.right = put(node.right, key, val);
        }
        else {
            node.val = val;
        }
        return node;
    }
    /*
    get - retrieves the value associated with the given key from the tree
    @return node
     */
    public V get(K key){
        Node node = get(root, key);
        return node != null ? node.val : null;
    }
    private Node get(Node node, K key) {
        if(node == null) {
            return null;
        }
        if(node.key.compareTo(key) < 0 ) {
            return get(node.left, key);
        }
        else if(node.key.compareTo(key) > 0) {
            return get(node.right, key);
        }
        else {
            return node;
        }
    }
    // @return the number of nodes in the tree
    public int size() {
        return size;
    }
    /*
    delete - removes the node with the given key from the tree
    @return node
     */
    public void delete(K key) {
        this.root = delete(root, key);
        size--;
    }
    private Node delete(Node node, K key) {
        if(node==null) {
            return null;
        }
        if(node.key.compareTo(key) < 0) {
            node.left = delete(node.left, key);
        }
        else if(node.key.compareTo(key) > 0) {
            node.right = delete(node.right, key);
        }
        else {
            if(node.left == null) {
                size--;
                return node.right;
            }
            else if(node.right == null) {
                size--;
                return node.left;
            }
            else {
                Node minNode = findMinNode(node.right);
                node.key = minNode.key;
                node.val = minNode.val;
                node.right = delete(node.right, minNode.key);
            }
        }
        return node;
    }
    // findMinNode - finding the minimum node
    private Node findMinNode(Node node) {
        if(node.left == null) {
            return node;
        }
        return findMinNode(node.left);
    }
    /*
    iterator -  performs an in-order traversal of the tree
    @return list
     */
    public Iterable<Node> iterator() {
        // ArrayList - to contain the nodes in correct order
        ArrayList<Node> arrayList = new ArrayList<>();
        inOrderTraversal(arrayList, root);
        return arrayList;
    }
    private void inOrderTraversal(ArrayList<Node> arrayList, Node node) {
        if(node == null) {
            return;
        }
        inOrderTraversal(arrayList, node.left);
        arrayList.add(node);
        inOrderTraversal(arrayList, node.right);
    }
}
