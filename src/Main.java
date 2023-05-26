public class Main {
    public static void main(String[] args) {
        BST<Integer, String> tree = new BST<>();
        //Inserting the elements
        tree.put(66, "Value 66");
        tree.put(55, "Value 55");
        tree.put(99, "Value 99");
        tree.put(88, "Value 88");
        tree.put(77, "Value 77");

        //Iterating over the tree and printing the result
        Iterable it = tree.iterator();
        for(Object elem : it) {
            System.out.println(elem);
        }


    }
}