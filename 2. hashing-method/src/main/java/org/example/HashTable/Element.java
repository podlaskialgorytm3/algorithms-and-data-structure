package org.example.HashTable;

import static java.util.Objects.*;

public class Element<T extends Comparable<T>> {
    protected T value;
    protected Element next;

    Element(T value, Element next){
        validateParams(value);

        this.value = value;
        this.next = next;
    }

    private void validateParams(T value){
        if(isNull(value)){
            throw new IllegalArgumentException("Value is null");
        }
    }
}
