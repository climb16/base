package online.jfree.base.container.list;

import online.jfree.base.container.LineList;

/**
 * author : Guo LiXiao
 * date : 2017-6-19  10:16
 */

public abstract class AbstractLineList<E> implements LineList<E> {

    protected int size;

    protected abstract void init();

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public void clear() {
        init();
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean contains(E e) {
        return indexOf(e) > 0;
    }
}
