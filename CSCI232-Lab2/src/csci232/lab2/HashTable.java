package csci232.lab2;


public class HashTable {

    private final int tableSize;
    private final boolean isRandom;
    public BinaryTree[] hashTable;

    public HashTable(int tableSize, boolean isRandom) {
        this.tableSize = tableSize;
        this.isRandom = isRandom;
        hashTable = new BinaryTree[tableSize];
        for(int i = 0; i < tableSize; i++){
            hashTable[i] = new BinaryTree();
        }
    }

    public void insert(int n) {
        // check to see if it is inserted already
        if (hashTable[getKey(n)].find(n) == null) {
            Node node = new Node(n);
            hashTable[getKey(n)].insert(node);
        } else {  // we found that node already, so let's not insert it!
            System.out.printf("The HashTable already has item %d in it!\n", n);
        }
    }

    public void showHashTable() {
        for (int i = 0; i < tableSize; i++) {
            if (hashTable[i] != null) {
                System.out.printf("(%d)-> ", i);
                hashTable[i].traverse(2);
                // the 2 in traverse() is for inOrder traversal
            }
        }
    }

    public Integer find(int n) {
        if(hashTable[getKey(n)].find(n) != null){
            return n;
        }
        else{
            return null;
        }
    }

    public int getKey(int n) {
        return n % tableSize;
    }

    public boolean isRandom() {
        return isRandom;
    }

}
