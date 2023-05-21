# Documentation 

Here you can find explanations of all functions that I used to solve this assignment.

## Binary Search Tree

### put

**Description:** This method adds key value pair to the BST or updates it

**Solution:** 

```java
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
    if(node.key.compareTo(key) > 0) {
       node.right = put(node.right, key, val);
    }
    else {
       node.val = val;
    }
       return node;
    }
```

### get

**Description:** This method extracts the value with a given key from the BST

**Solution:** 

```java
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
```

### delete

**Description:** This method removes a key value pair from the BST 

**Solution:** 

```java
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
     if(node.key.compareTo(key) > 0) {
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
```

### iterator

**Description:** This method returns an iterable collection of nodes and perform in-order traversal of the BST adding the nodes to the list in ascending order

**Solution:** 

```java
public Iterable<Node> iterator() {
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
```

### size

**Description:** This method returns the size of the BST

**Solution:** 

```java
public int size() {
   return size;
}
```



