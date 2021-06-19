package org.jpro.dynamicArray;

import org.jpro.pojo.Person;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArrayListTest {

    private ArrayList<Integer> arrayList;
    private ArrayList<Person> personArrayList;

    @Before
    public void setUp() {
        arrayList = initArrayList();
        personArrayList = initPersonArrayList();
    }

    @Test
    public void clear() {
        Assert.assertFalse(arrayList.isEmpty());
        arrayList.clear();
        Assert.assertTrue(arrayList.isEmpty());
    }

    @Test
    public void size() {
        Assert.assertEquals(0, new ArrayList<Integer>().size());
        Assert.assertEquals(7, arrayList.size());
        arrayList.add(88);
        Assert.assertEquals(8, arrayList.size());
        arrayList.remove(0);
        Assert.assertEquals(7, arrayList.size());
    }

    @Test
    public void isEmpty() {
        Assert.assertTrue(new ArrayList<Integer>().isEmpty());
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
        Assert.assertEquals(88, arrayList.get(7).intValue());
        Assert.assertEquals(99, arrayList.get(8).intValue());
        arrayList.add(100);
        arrayList.add(200);
        arrayList.add(300);
        personArrayList.add(new Person("lili", 21));
        personArrayList.add(new Person("lulu", 12));
    }

    @Test
    public void get() {
        Assert.assertEquals(11, arrayList.get(0).intValue());
        Assert.assertEquals(77, arrayList.get(6).intValue());
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
        Assert.assertEquals(1, arrayList.get(0).intValue());
        arrayList.set(6, 7);
        Assert.assertEquals(7, arrayList.get(6).intValue());
        Assert.assertEquals(7, arrayList.size());
    }

    @Test
    public void testAdd() {
        arrayList.add(0, 88);
        Assert.assertEquals(88, arrayList.get(0).intValue());
        Assert.assertEquals(11, arrayList.get(1).intValue());
        Assert.assertEquals(77, arrayList.get(7).intValue());
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
        Assert.assertEquals(0, personArrayList.indexOf(new Person("jack", 11)));
        Assert.assertEquals(-1, personArrayList.indexOf(new Person("jack", 22)));
    }

    private ArrayList<Integer> initArrayList() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(11);
        arrayList.add(22);
        arrayList.add(33);
        arrayList.add(44);
        arrayList.add(55);
        arrayList.add(66);
        arrayList.add(77);
        return arrayList;
    }

    private ArrayList<Person> initPersonArrayList() {
        ArrayList<Person> personArrayList = new ArrayList<>();
        personArrayList.add(new Person("jack", 11));
        personArrayList.add(new Person("tom", 1));
        return personArrayList;
    }

    @Test
    public void main() {
        System.out.println(arrayList);
        System.out.println(personArrayList);
    }
}