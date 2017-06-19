package online.jfree.base.container.list;

import online.jfree.base.container.LineList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * LinkedLineList Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>���� 19, 2017</pre>
 */
public class LinkedLineListTest {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    LineList<Integer> lineList = new LinkedLineList<>();

    @Before
    public void before() throws Exception {
        for (int i = 0; i < 100; i ++ ){
            lineList.add(i);
        }
    }

    @Test
    public void testIsEmpty() throws Exception {
        logger.info("empty: {}", lineList.isEmpty());
    }


    @Test
    public void testClear() throws Exception {
        lineList.clear();
        this.testGetSet();
        logger.info("empty: {}", lineList.isEmpty());
    }


    @Test
    public void testGetSet() throws Exception {
        for (int i = 0; i < lineList.size(); i ++){
            logger.info("index : {}, value : {}", i, lineList.get(i));
        }
    }


    @Test
    public void testIndexOf() throws Exception {
        logger.info("index of i : {}", lineList.indexOf(1));
    }


    @Test
    public void testContains() throws Exception {
        logger.info("contains : {}", lineList.contains(5));

    }


    @Test
    public void testRemove() throws Exception {
        lineList.remove(2);
        this.testGetSet();
    }


    @Test
    public void testAddE() throws Exception {
        lineList.add(8);
        this.testGetSet();

    }


    @Test
    public void testAddForIndexE() throws Exception {
        lineList.add(0, 9);
        this.testGetSet();
    }


    @Test
    public void testSize() throws Exception {
        logger.info("contains : {}", lineList.size());
    }

} 
