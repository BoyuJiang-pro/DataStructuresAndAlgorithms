package org.jpro.dynamicArray;

public class Main {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add(11);
        list.add(22);
        list.add(33);
        System.out.println(list);
        list.remove(2);
        System.out.println(list);
        list.remove(2);
    }

}
