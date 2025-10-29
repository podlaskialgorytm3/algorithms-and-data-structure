package org.example.HashTable;

public class HashListChainMultiplicativeHashing <T extends Comparable<T>> extends HashListChaining<T> {
    private static final double KNUTH_A = (Math.sqrt(5) - 1) / 2.0;
    private double A;

    public HashListChainMultiplicativeHashing(){
        super();
        this.A = KNUTH_A;
    }

    public HashListChainMultiplicativeHashing(int size){
        super(size);
        this.A = KNUTH_A;
    }

    public HashListChainMultiplicativeHashing(double A){
        super();
        validateA(A);
        this.A = A;
    }

    public HashListChainMultiplicativeHashing(int size, double A){
        super(size);
        validateA(A);
        this.A = A;
    }

    @Override
    int countHashId(T value) {
        int hashCode = value.hashCode();

        int key = hashCode & Integer.MAX_VALUE;

        double x = key * A;
        double frac = x - Math.floor(x);
        int hashId = (int) Math.floor(size * frac);

        if (hashId >= size) {
            hashId = size - 1;
        } else if (hashId < 0) {
            hashId = 0;
        }

        return hashId;
    }

    private void validateA(double a){
        if(a <= 0 || a >= 1){
            throw new IllegalArgumentException("A must be beetween 0 and 1.");
        }
    }

    public String toString(){
        return "Haszowanie przez Mnożenie";
    }

}
