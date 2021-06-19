package org.jpro.dynamicArray;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArrayListTest {

    private ArrayList arrayList;

    @Before
    public void setUp() throws Exception {
        arrayList = initArrayList();
    }

    @Test
    public void clear() {
    }

    @Test
    public void size() {
        Assert.assertEquals(0, new ArrayList().size());
        Assert.assertEquals(7, arrayList.size());
        arrayList.add(88);
        Assert.assertEquals(8, arrayList.size());
        arrayList.remove(0);
        Assert.assertEquals(7, arrayList.size());
    }

    @Test
    public void isEmpty() {

    }

    @Test
    public void contains() {
    }

    @Test
    public void add() {
    }

    @Test
    public void get() {
    }

    @Test
    public void set() {
    }

    @Test
    public void testAdd() {
    }

    @Test
    public void remove() {
    }

    @Test
    public void indexOf() {
    }

    private ArrayList initArrayList() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(11);
        arrayList.add(22);
        arrayList.add(33);
        arrayList.add(44);
        arrayList.add(55);
        arrayList.add(66);
        arrayList.add(77);
        return arrayList;
    }
}