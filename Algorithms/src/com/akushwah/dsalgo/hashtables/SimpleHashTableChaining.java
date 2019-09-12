package com.akushwah.dsalgo.hashtables;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;

//collision correction by chaining
public class SimpleHashTableChaining<K, V> {
    private LinkedList<StoredData<K,V>>[] hashTable;

    public SimpleHashTableChaining() {
        hashTable = new LinkedList[10];
        for (int i = 0; i < hashTable.length ; i++) {
            hashTable[i] = new LinkedList<>();
        }
    }

    private int hashKey(K key) {
        return Math.abs(key.hashCode())
                % hashTable.length;
    }

    public void put(K k, V v) {
        int hashedKey = hashKey(k);
        hashTable[hashedKey].add(new StoredData<>(k,v));
    }

    public V get(K k) {
        int hashedKey = hashKey(k);
        LinkedList<StoredData<K, V>> list = hashTable[hashedKey];
        if(list.size() == 1){
            return list.peek().value;
        }else{
            ListIterator<StoredData<K,V>> iterator = list.listIterator();
            while (iterator.hasNext()){
                StoredData<K, V> data = iterator.next();
                if(data.key.equals(k)){
                    return data.value;
                }
            }
        }

        return null;
    }

    public V remove(K k) {
        int hashedKey = hashKey(k);
        ListIterator<StoredData<K,V>> iterator = hashTable[hashedKey].listIterator();
        StoredData<K, V> data = null;
        int index = 0;
        while (iterator.hasNext()){
            data = iterator.next();
            index++;
            if(data.key.equals(k)){
                break;
            }
        }
        if(data == null){
            return null;
        } else{
            hashTable[hashedKey].remove(index-1);
            return data.value;
        }
    }


    public void printHashTable() {
        for (int i = 0; i < hashTable.length ; i++) {
            if(hashTable[i].isEmpty()){
               System.out.println("Position= "+i+" :Empty");
            }else{
                System.out.print("Position= "+i+" :");
                ListIterator<StoredData<K,V>> iterator = hashTable[i].listIterator();
                while (iterator.hasNext()){
                   System.out.print(iterator.next().value);
                   System.out.print(" -> ");
                }
                System.out.println("null");
            }
        }
    }

}
