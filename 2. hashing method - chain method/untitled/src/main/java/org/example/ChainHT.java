package org.example;

public class ChainHT {
    private final int BASIC_SIZE = 1031;
    private Node [] t;

    public ChainHT() {
        t = new Node[BASIC_SIZE];
    }
    public ChainHT(int s){
        t = new Node[prime(s)];
    }

    public void insert(Object o){
        int i = o.hashCode() % t.length;
        Node p = t[i];
        while (p != null) {
            if( p.content.equals(o))
                return;
        }
        t[i] = new Node(o, t[i]);
    }

    private class Node{
        Object content;
        Node next;

        Node(Object content){
            this.content = content;
            this.next = null;
        }

        Node(Object content, Node next){
            this.content = content;
            this.next = next;
        }
    }

    public static int prime(int base){
        NEXT: for(int cand = base; cand < 2 * base; cand++){
            for(int j = 2; j < Math.sqrt(cand); j++){
                if( cand % j == 0){
                    continue NEXT;
                }
                return cand;
            }
        }
        return base;
    }

    public static void main(String[] args) {

    }
}
