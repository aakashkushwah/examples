package com.akushwah.dsalgo.hashtables;

//does not handle collision
public class SimpleHashTable<K,V> {
    private V[] hashTable;

    public SimpleHashTable(){
        hashTable = (V[])new Object[10];
    }

    private int hashKey(K key){
       return  key.hashCode()%hashTable.length;
    }

    public void put(K k, V v){
        int hashedKey = hashKey(k);

        if(occupied(hashedKey)){
            System.out.println("Sorry there is already an employee at this position "+hashedKey);
        } else {
            hashTable[hashedKey] = v;
        }
    }

    public V get(K k){
        return hashTable[hashKey(k)];
    }

    private boolean occupied(int index){
        return hashTable[index]!=null;
    }

    public void printHashTable(){
        for (int i = 0; i <hashTable.length ; i++) {
            System.out.println(hashTable[i]);
        }
    }

}
