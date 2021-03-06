package org.jpro.dynamicArray;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ArrayList<E> {

    private static final Logger logger = LoggerFactory.getLogger(ArrayList.class);

    private static final int DEFAULT_CAPACITY = 10;
    private static final int ELEMENT_NOT_FOUND = -1;

    /**
     * 元素的数量
     */
    private int size;

    /**
     * 所有的元素
     */
    private E[] elements;

    public ArrayList(int capacity) {
        capacity = Math.max(DEFAULT_CAPACITY, capacity);
        elements = (E[]) new Object[capacity];
    }

    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * 清除所有元素
     */
    public void clear() {
        for(int i = 0; i <size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    /**
     * 元素数量
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * 是否为空
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 是否包含某个元素
     * @param element
     * @return
     */
    public boolean contains(E element) {
        return indexOf(element) != ELEMENT_NOT_FOUND;
    }

    /**
     * 添加到元素尾部
     * @param element
     */
    public void add(E  element) {
        add(size, element);
    }

    /**
     * 获取index位置的元素
     * @param index
     * @return
     */
    public E get(int index) {
        rangeCheck(index);
        return elements[index];
    }

    /**
     * 设置index位置的元素
     * @param index
     * @param element
     * @return
     */
    public E set(int index, E element) {
        rangeCheck(index);
        E old = elements[index];
        elements[index] = element;
        return old;
    }

    /**
     * 往index位置添加元素
     * @param index
     * @param element
     */
    public void add (int index, E element) {
        rangeCheckOfAdd(index);
        ensureCapacity(size + 1);
        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = element;
        size++;
    }

    private void ensureCapacity(int capacity) {
        int oldCapacity = elements.length;
        if (oldCapacity >= capacity) {
            return;
        }
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
        logger.debug("oldCapacity:{} 扩容为 newCapacity:{}", oldCapacity ,newCapacity);
    }


    /**
     * 删除index位置的元素
     * @param index
     * @return
     */
    public E remove(int index) {
        rangeCheck(index);
        E old = elements[index];
        for (int i = index + 1; i < size; i++) {
            elements[i - 1] = elements[i];
        }
        elements[--size] = null;
        return old;
    }

    /**
     * 查看元素的索引
     * @param element
     * @return
     */
    public int indexOf(E element) {
        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (element.equals(elements[i])) {
                    return i;
                }
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("size=").append(size).append(", [");
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                sb.append(", ");
            }
            sb.append(elements[i]);
        }
        sb.append("]");
        return sb.toString();
    }

    private void outOfBound(int index) {
        throw new IndexOutOfBoundsException("Index:" + index + ", size:" + size);
    }

    private void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            outOfBound(index);
        }
    }

    private void rangeCheckOfAdd(int index) {
        if (index < 0 || index > size) {
            outOfBound(index);
        }
    }
}
