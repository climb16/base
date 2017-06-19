package online.jfree.base.container.list;

import online.jfree.base.container.LineList;

/**
 * ??????????
 * author : Guo LiXiao
 * date : 2017-6-7  14:52
 */

public class LinkedLineList<E> extends AbstractLineList<E> implements LineList<E> {

    transient Node<E> first;

    public LinkedLineList() {
    }

    @Override
    protected void init() {
        this.size = 0;
        first = null;
    }

    /**
     * ????????
     * @param index
     * @return
     */
    protected Node<E> node(int index) {
        Node<E> x = first;
        for (int i = 0; i < index; i++)
            x = x.next;
        return x;
    }

    /**
     * ????????
     *
     * @param index
     */
    private void checkCapacity(int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException(new StringBuffer("[index : ").append(index).append("] , [size : ").append(size).append("] ").toString());
    }


    @Override
    public E get(int index) {
        checkCapacity(index);
        return node(index).item;
    }

    @Override
    public int indexOf(E e) {
        int index = 0;
        for (Node<E> x = first; x != null; x = x.next) {
            if (e == null && x.item == null || e.equals(x.item))
                return index;
            index++;
        }
        return -1;
    }

    @Override
    public E set(int index, E e) {
        checkCapacity(index);
        Node<E> node = node(index);
        E old = node.item;
        node.item = e;
        return old;
    }

    @Override
    public E remove(int index) {
        checkCapacity(index);
        if (index == 0) {
            Node<E> node = first;
            Node<E> next = node.next;
            first = next;
            size --;
            return first.item;
        } else {
            Node<E> pre = node(index - 1);
            Node<E> node = pre.next;
            Node<E> next = node.next;
            pre.next = next;
            size --;
            return node.item;
        }
    }

    @Override
    public E add(E e) {
        if (size == 0) {
            first = new Node<>(e, null);
            size ++;
            return first.item;
        }
        return add(size - 1, e);
    }

    @Override
    public E add(int index, E e) {
        checkCapacity(index);
        Node<E> node = node(index);
        Node<E> next = node.next;
        node.next = new Node<>(e, next);
        size ++;
        return node.next.item;
    }

    private static final class Node<E> {
        E item;
        Node<E> next;

        public Node(E item, Node<E> next) {
            this.item = item;
            this.next = next;
        }
    }
}
