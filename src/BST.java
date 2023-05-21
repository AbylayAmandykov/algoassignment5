public class BST<K extends Comparable<K>, V> {
    private Node root;
    private class Node {
        private K key;
        private V val;
        private Node left, right;
        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }
    public void put(K key, V val) {
        root = put(root, key, val);
    }
    public Node put(Node node, K key, V val) {
        if(node == null) {
            return new Node(key, val);
        }
        if(node.key.compareTo(key) < 0) {
            node.left = put(node.left, key, val);
        }
        if(node.key.compareTo(key) > 0) {
            node.right = put(node.right, key, val);
        }
        else {
            node.val = val;
        }
        return node;
    }
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
        if(node.key.compareTo(key) > 0) {
            return get(node.right, key);
        }
        else {
            return node;
        }
    }
    public void delete(K key) {}
    public Iterable<K> iterator() {}
}
