package org.example.HashTable;

import static java.util.Objects.isNull;

public abstract class HashListChaining<T extends Comparable<T>> implements HashTable<T>{
    private final static int DEFAULT_SIZE = 127;

    private Element [] hashElements;
    private int sizeHashElements;
    protected int size;

    public HashListChaining(int size){
        validateInputHashSize(size);

        this.size = size;
        this.hashElements = new Element[size];
    }

    public HashListChaining(){
        this(DEFAULT_SIZE);
    }

    @Override
    public void add(T value) {
        validateInputValue(value);

        int hashId = countHashId(value);
        Element<T> oldElement = findElement(value, hashId);

        if(oldElement != null){
            oldElement.value =  value;
        }
        else{
            hashElements[hashId] = new Element(value, hashElements[hashId]);
            sizeHashElements++;
        }
    }

    @Override
    public T delete(T value) {
        validateInputValue(value);

        int hashId = countHashId(value);

        Element previousElement = null;
        Element element = hashElements[hashId];

        while(element != null){
            if(element.value.compareTo(value) == 0){
                if(previousElement != null){
                    previousElement.next = element.next;
                }
                else{
                    hashElements[hashId] = element;
                }
                sizeHashElements--;
                break;
            }
            previousElement = element;
            element = element.next;
        }

        return value;
    }

    @Override
    public T get(T value) {
        validateInputValue(value);

        int hashId = countHashId(value);
        Element<T> element = findElement(value, hashId);

        return element != null ? element.value : null;
    }

    public void print(){
        for(int i = 0; i < size; i++){
            Element<T> current = hashElements[i];
            System.out.print(i + " bucket: ");
            if(current != null){
                System.out.print(current.value + " ");
                while(current.next != null){
                    System.out.print("-> " + current.next.value);
                    current = current.next;
                }
            }
            System.out.println();
        }
    }

    private double countLoadFactor(){
        return (double) sizeHashElements / size;
    }

    private Element<T> findElement(T value, int hashId){
        Element<T> currentElement = hashElements[hashId];

        while(currentElement != null && currentElement.value.compareTo(value) != 0){
            currentElement = currentElement.next;
        }

        return currentElement;
    }

    abstract int countHashId(T value);

    private void validateInputHashSize(int size){
        if(size < 1){
            throw new IllegalArgumentException("Size is too small.");
        }
    }

    private void validateInputValue(T value){
        if(isNull(value)){
            throw new IllegalArgumentException("Value is null");
        }
    }

}
