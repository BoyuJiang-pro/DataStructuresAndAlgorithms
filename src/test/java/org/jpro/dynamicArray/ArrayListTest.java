package org.jpro.dynamicArray;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArrayListTest {

    private ArrayList arrayList;

    @Before
    public void setUp() {
        arrayList = initArrayList();
    }

    @Test
    public void clear() {
        Assert.assertFalse(arrayList.isEmpty());
        arrayList.clear();
        Assert.assertTrue(arrayList.isEmpty());
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
        Assert.assertTrue(new ArrayList().isEmpty());
        Assert.assertFalse(arrayList.isEmpty());
    }

    @Test
    public void contains() {
        Assert.assertFalse(arrayList.contains(0));
        Assert.assertTrue(arrayList.contains(66));
    }

    @Test
    public void add() {
        arrayList.add(88);
        arrayList.add(99);
        Assert.assertEquals(88, arrayList.get(7));
        Assert.assertEquals(99, arrayList.get(8));
    }

    @Test
    public void get() {
        Assert.assertEquals(11, arrayList.get(0));
        Assert.assertEquals(77, arrayList.get(6));
        try {
            arrayList.get(7);
        } catch (IndexOutOfBoundsException e) {
            return;
        }

        try {
            arrayList.get(-1);
        } catch (IndexOutOfBoundsException e) {
            return;
        }
        Assert.fail("未正常判断数组越界");
    }

    @Test
    public void set() {
        arrayList.set(0, 1);
        Assert.assertEquals(1, arrayList.get(0));
        arrayList.set(6, 7);
        Assert.assertEquals(7, arrayList.get(6));
    }

    @Test
    public void testAdd() {
        arrayList.add(0, 88);
        Assert.assertEquals(88, arrayList.get(0));
        Assert.assertEquals(11, arrayList.get(1));
        Assert.assertEquals(77, arrayList.get(7));
        try {
            arrayList.add(10, 100);
        } catch (IndexOutOfBoundsException e ) {
            return;
        }
        Assert.fail("未正常判断数组越界");
    }

    @Test
    public void remove() {
        arrayList.remove(0);
        arrayList.remove(5);
        try {
            arrayList.remove(5);
        } catch (IndexOutOfBoundsException e) {
            return;
        }
        Assert.fail("未正常判断数组越界");
    }

    @Test
    public void indexOf() {
        Assert.assertEquals(0 ,arrayList.indexOf(11));
        Assert.assertEquals(-1, arrayList.indexOf(0));
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

    @Test
    public void main() {
        System.out.println(arrayList.toString());
    }
}