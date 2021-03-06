package csci232.lab2;

class Node implements Comparable {

    public int key;         // data item (key)
    public Node leftChild; // this node's left child
    public Node rightChild; // this node's right child

    public Node(int freq) {
        key = freq;
    }

    public void displayNode() // display ourself
    {
        System.out.print('{');
        System.out.print(key);
        System.out.print("} ");
    }

    @Override
    public int compareTo(Object o) {
        if (Integer.parseInt(o.toString()) <= this.key) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return Integer.toString(key);
    }
} // end class Node
