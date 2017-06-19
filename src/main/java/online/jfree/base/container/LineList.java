package online.jfree.base.container;

/**
 * author : Guo LiXiao
 * date : 2017-6-14  11:46
 */

public interface LineList <E>{

    /**
     * lineList 是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 清空 lineList
     */
    void clear();

    /**
     * 获取指定位置元素
     * @param index
     * @return
     */
    E get(int index);

    /**
     * 获取元素第一次出现的位置
     * @param e
     * @return
     */
    int indexOf(E e);

    /**
     * 判断 lineList是否包含指定元素
     * @param e
     * @return
     */
    boolean contains(E e);

    /**
     * 设置指定位置数据，如数据已存在 则覆盖原数据
     * @param index
     * @param e
     * @return
     */
    E set(int index, E e);

    /**
     * 移除指定位置元素
     * @param index
     * @return
     */
    E remove(int index);

    /**
     * 在lineList结尾插入元素
     * @param e
     * @return
     */
    E add(E e);

    /**
     * 在index后面插入元素
     * @param index
     * @param e
     * @return
     */
    E add(int index, E e);

    /**
     * 返回lineList长度
     * @return
     */
    int size();



}
