package online.jfree.base.container.list;

import online.jfree.base.container.LineList;

/**
 * 线性表 双向链表
 * author : Guo LiXiao
 * date : 2017-6-19  9:59
 */

public class DualLinkedLineList<E> extends AbstractLineList<E> implements LineList<E> {

    private transient Node<E> first;
    private transient Node<E> last;

    /**
     * 根据索引获取元素
     *
     * @param index
     * @return
     */
    protected Node<E> node(int index) {
        if (index < (size >> 1)) {
            Node<E> x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            Node<E> x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }

    /**
     * 校验列表索引越界
     *
     * @param index
     */
    private void checkCapacity(int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException(new StringBuffer("[index : ").append(index).append("] , [size : ").append(size).append("] ").toString());
    }


    @Override
    protected void init() {
        this.size = 0;
        first = null;
        last = null;
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
        Node<E> node = node(index);
        final E e = node.item;
        final Node<E> next = node.next;
        final Node<E> prev = node.prev;
        if (prev == null) {
            first = next;
            first.prev = null;
        } if (next == null){
            last = prev;
            last.next = null;
        } else {
            prev.next = next;
            next.prev = prev;
        }
        size--;
        return e;
    }

    @Override
    public E add(E e) {
        if (first == null) {
            first = new Node<>(null, e, null);
            last = first;
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
        node.next = new Node<>(node, e, next);
        if (next == null) last = node.next;
        size ++;
        return node.next.item;
    }

    private static final class Node<E> {
        E item;
        Node<E> prev;
        Node<E> next;

        public Node(Node<E> prev, E item, Node<E> next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }

}
