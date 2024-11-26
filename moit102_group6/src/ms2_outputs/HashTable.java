package ms2_outputs;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class HashTable {
    private String[] table;
    private static final int SIZE = 50;

    public HashTable() {
        table = new String[SIZE];
        Arrays.fill(table, null);
    }

    private int hashFunction(String key) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(key.getBytes());
        int hashValue = 0;
        for (byte b : hash) {
            hashValue = (hashValue * 31 + b) % SIZE;
        }
        return Math.abs(hashValue);
    }

    public void insert(String key) throws NoSuchAlgorithmException {
        int hashKey = hashFunction(key);
        while (table[hashKey] != null) {
            hashKey = (hashKey + 1) % SIZE;
        }
        table[hashKey] = key; // Store the entire stock entry
    }

    public String search(String key) throws NoSuchAlgorithmException {
        int hashKey = hashFunction(key);
        int originalHashKey = hashKey; // Store original hash to detect cycles

        while (table[hashKey] != null) {
            if (table[hashKey].equals(key)) {
                return table[hashKey];
            }
            hashKey = (hashKey + 1) % SIZE;

            // Prevent infinite loop in case of a full table or no match found
            if (hashKey == originalHashKey) {
                break;
            }
        }
        return null; // Return null if not found
    }

    public void delete(String key) throws NoSuchAlgorithmException {
        int hashKey = hashFunction(key);
        while (table[hashKey] != null) {
            if (table[hashKey].equals(key)) {
                table[hashKey] = null;
                return;
            }
            hashKey = (hashKey + 1) % SIZE;
        }
    }
}
