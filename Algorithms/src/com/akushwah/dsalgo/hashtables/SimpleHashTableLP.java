package com.akushwah.dsalgo.hashtables;

//Linear Probing
public class SimpleHashTableLP<K, V> {
    private StoredData<K, V>[] hashTable;

    public SimpleHashTableLP() {
        hashTable = new StoredData[10];
    }

    private int hashKey(K key) {
        return ((String) key).length()
                % hashTable.length;
    }

    private int findKey(K k) {
        int hashedKey = hashKey(k);
        if (hashTable[hashedKey] != null && hashTable[hashedKey].key.equals(k)) {
            return hashedKey;
        }
        int stopIndex = hashedKey;
        if (hashedKey == hashTable.length - 1) {
            hashedKey = 0;
        } else {
            hashedKey++;
        }
        while (hashedKey != stopIndex && hashTable[hashedKey] != null && !hashTable[hashedKey].key.equals(k)) {
            hashedKey = (hashedKey + 1) % hashTable.length;
        }
//        if (stopIndex == hashedKey) {
//            return -1;
//        } else {
//            return hashedKey;
//        }
        if (hashTable[hashedKey] != null && hashTable[hashedKey].key.equals(k)) {
            return hashedKey;
        } else {
            return -1;
        }
    }

    public void put(K k, V v) {
        int hashedKey = hashKey(k);
        if (occupied(hashedKey)) {
            int stopIndex = hashedKey;
            if (hashedKey == hashTable.length - 1) {
                hashedKey = 0;
            } else {
                hashedKey++;
            }
            while (occupied(hashedKey) && hashedKey != stopIndex) {
                hashedKey = (hashedKey + 1) % hashTable.length;
            }
        }
        if (occupied(hashedKey)) {
            System.out.println("Sorry there is already an employee at this position " + hashedKey);
        } else {
            hashTable[hashedKey] = new StoredData(k, v);
        }
    }

    public V get(K k) {
        int hashedKey = findKey(k);
        if (hashedKey == -1) {
            return null;
        }
        return hashTable[hashedKey].value;
    }

    private boolean occupied(int index) {
        return hashTable[index] != null;
    }

    public V remove(K k) {
        int hashedKey = findKey(k);
        if (hashedKey == -1) {
            return null;
        }

        V v = hashTable[hashedKey].value;
        hashTable[hashedKey] = null;
        rehash();
        return v;

    }

    private void rehash(){
        StoredData<K, V> oldData[] = hashTable;
        hashTable = new StoredData[hashTable.length];
        int j=0;
        for (int i = 0; i <hashTable.length ; i++) {
            if(oldData[i]!=null){
                put(oldData[i].key, oldData[i].value);
            }
        }
    }

    public void printHashTable() {
        for (int i = 0; i < hashTable.length; i++) {
            if (hashTable[i] == null) {
                System.out.println("Empty");
            } else {
                System.out.println("Position " + i + " Value= " + hashTable[i].value);
            }
        }
    }

}
