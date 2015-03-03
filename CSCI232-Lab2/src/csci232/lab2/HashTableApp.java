package csci232.lab2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class HashTableApp {


    private static final Scanner input = new Scanner(System.in);
    private static HashTable hashTable;
    private static int size;
    private static final Random rng = new Random();
    private static final int MAX_SIZE = 255;
    private static boolean foundPrime = false;

    public static void main(String[] args) throws IOException {
        do {
            System.out.print("Please enter a size for the Hash Table: ");
            int n = getInt();

            if (!isPrime(n)) {
                System.out.print("\nSorry, " + n + " is not a prime number.  "
                        + "Let's find a prime bigger than " + n + "!\n");
                int size = findPrime(n);

                if (size == -1) {
                    System.out.print("We couldn't find a prime [p > " + n
                            + "] but [p < " + MAX_SIZE + "]. Please try again!\n");
                } else {
                    System.out.print("We found the prime " + size + ": Let's make "
                            + size + " the size of our Hash Table!\n");
                    foundPrime = true;
                }
            } else {
                System.out.print(n + " is already a prime!  "
                        + "So let's make our Hash Table!\n");
                foundPrime = true;
                size = n;
            }
        } while (!foundPrime);

        System.out.print("Would you rather enter values into the Hash Table yourself?   ([y]es / [n]o)");
        char a = getChar();
        if (a == 'y') {
            hashTable = new HashTable(size, false);
        } else {
            hashTable = new HashTable(size, true);
        }
        if (hashTable.isRandom()) {
            for (int i = 0; i < size; i++) {
                hashTable.insert(getRandom());
            }
        } else {
            for (int i = 0; i < size; i++) {
                System.out.println("Please enter in value " + i + " to enter into the HashTable!");
                int temp = getInt();
                hashTable.insert(temp);
            }
        }

        do {
            System.out.println("************xX_MENU_Xx************");
            System.out.println("Please enter the first letter of [S]how, [I]nsert, [F]ind , or e[X]it.");
            char choice = getChar();

            switch (choice) {
                case 's':
                case 'S':
                    hashTable.showHashTable();
                    break;
                case 'i':
                case 'I':
                    System.out.println("What would you like to insert?");
                    int valueToInsert = getInt();
                    hashTable.insert(valueToInsert);
                    break;
                case 'f':
                case 'F':
                    System.out.println("What would you like to find?");
                    int valueToFind = getInt();
                    if(hashTable.find(valueToFind) != null){
                        System.out.printf("%d exists in the table!!\n", valueToFind);
                    }else{
                        System.out.printf("%d doesn't exist in the table!!\n", valueToFind);
                    }
                    break;
                case 'x':
                case 'X':
                    System.out.println("Now exiting the HashTable!  Good bye!");
                    System.exit(0);
                    break;
            }
        } while (true);
    }
    public static int getRandom() {
        return rng.nextInt(MAX_SIZE) + 1;
    }

    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }

    public static char getChar() throws IOException {
        String s = getString();
        return s.charAt(0);
    }

    public static int getInt() throws IOException {
        String s = getString();
        return Integer.parseInt(s);
    }

    public static int findPrime(int n) {
        for (int i = n; i < MAX_SIZE; i++) {
            if (isPrime(i)) {
                return i;
            }
        }
        return -1;
    }

    public static boolean isPrime(int n) {
        for (int i = 3; (i * i) < n; i += 2) {
            if (n % i == 0 || n % 2 == 0) {
                return false;
            }
        }
        return true;
    }

}
