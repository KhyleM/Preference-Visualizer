/**
 * 
 */
package prj5;

import java.util.Iterator;
import java.util.NoSuchElementException;
import student.TestCase;

/**
 * @author <Zhengdao Jiao> <zhengj7>
 * @author <Khyle Mott> (khyle)
 * @author <Mujid Khan> (mujidk)
 * @version 2018/04/08
 */
public class LinkedListTest extends TestCase {
    private LinkedList<String> list;


    /**
     * the setUp method
     */
    public void setUp() {
        list = new LinkedList<String>();
        list.add("apple");
        list.add("bee");
        list.add("cat");
    }


    /**
     * test the size() method
     */
    public void testSize() {
        assertEquals(list.size(), 3);
    }


    /**
     * test the add(int index, E obj) method
     */
    public void testAdd() {
        list.add(2, "bee");
        assertEquals(list.size(), 4);

        Exception exception = null;
        try {
            list.add(6, "dog");
            fail("add() is not throwing an exception when it should");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue("add() is throwing the wrong type of exceptions",
            exception instanceof IndexOutOfBoundsException);

        exception = null;
        try {
            list.add(-1, "dog");
            fail("add() is not throwing an exception when it should");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue("add() is throwing the wrong type of exceptions",
            exception instanceof IndexOutOfBoundsException);

        exception = null;
        try {
            list.add(1, null);
            fail("add() is not throwing an exception when it should");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue("add() is throwing the wrong type of exceptions",
            exception instanceof IllegalArgumentException);
    }


    /**
     * test add method
     */
    public void testAdd3() {
        list.clear();
        list.add(0, "apple");
        assertEquals(1, list.size());
    }


    /**
     * test add(E obj) method
     */
    public void testAdd2() {
        list.add("bee");
        assertEquals(list.size(), 4);

        Exception exception = null;
        try {
            list.add(null);
            fail("add() is not throwing an exception when it should");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue("add() is throwing the wrong type of exceptions",
            exception instanceof IllegalArgumentException);
    }


    /**
     * test isEmpty() method
     */
    public void testIsEmpty() {
        assertFalse(list.isEmpty());
    }


    /**
     * test remove(E obj) method
     */
    public void testRemove() {
        assertTrue(list.remove("apple"));
        assertFalse(list.remove("dog"));
        assertTrue(list.remove("cat"));
        assertTrue(list.remove("bee"));

        list.add("apple");
        list.add("bee");

        assertTrue(list.remove("bee"));

    }


    /**
     * Tests removing from an empty list
     */
    public void testRemoveFromEmpty() {
        list = new LinkedList<String>();
        list.add("dance");
        list.add(0, "safety");
        list.clear();
        assertFalse(list.remove("safety"));
        Exception exception;
        exception = null;
        try {
            list.remove(0);
        }
        catch (IndexOutOfBoundsException e) {
            exception = e;
        }
        assertTrue(exception instanceof IndexOutOfBoundsException);

        LinkedList<String> emptyList = new LinkedList<String>();
        exception = null;
        try {
            emptyList.remove(0);
        }
        catch (IndexOutOfBoundsException e) {
            exception = e;
        }
        assertTrue(exception instanceof IndexOutOfBoundsException);
    }


    /**
     * Tests removing a object changes the size appropiately and that you can
     * remove the first and last elements
     */
    public void testRemoveObj() {
        list = new LinkedList<String>();
        assertFalse(list.remove(null));
        list.add("A");
        list.add("B");
        assertTrue(list.remove("A"));
        assertEquals("B", list.get(0));
        assertEquals(1, list.size());
        list.add("C");
        assertTrue(list.remove("C"));
        assertEquals("B", list.get(0));
    }


    /**
     * Tests that objects can be removed at the beginning and end and that the
     * size is changed
     */
    public void testRemoveIndex() {
        list = new LinkedList<String>();
        list.add("A");
        list.add("B");
        assertTrue(list.remove(1));
        assertEquals(1, list.size());
        list.add("B");
        assertTrue(list.remove(0));
        assertEquals(1, list.size());
    }


    /**
     * test remove(int index) method
     */
    public void testRemove2() {
        assertTrue(list.remove(1));

        Exception exception = null;
        try {
            list.remove(-1);
            fail("remove() is not throwing an exception when it should");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue("remove() is throwing the wrong type of exceptions",
            exception instanceof IndexOutOfBoundsException);

        exception = null;
        try {
            list.remove(6);
            fail("remove() is not throwing an exception when it should");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue("remove() is throwing the wrong type of exceptions",
            exception instanceof IndexOutOfBoundsException);

        list.clear();
        exception = null;
        try {
            list.remove(0);
            fail("remove() is not throwing an exception when it should");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue("remove() is throwing the wrong type of exceptions",
            exception instanceof IndexOutOfBoundsException);

    }


    /**
     * test get(int index) method
     */
    public void testGet() {
        assertEquals(list.get(0), "apple");

        Exception exception = null;
        try {
            list.get(-1);
            fail("get() is not throwing an exception when it should");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue("get() is throwing the wrong type of exceptions",
            exception instanceof IndexOutOfBoundsException);
    }


    /**
     * test contains(E obj) method
     */
    public void testContains() {
        assertTrue(list.contains("bee"));
        assertFalse(list.contains("dog"));

        list.remove(0);
        assertFalse(list.contains("apple"));
    }


    /**
     * test clear() method
     */
    public void testClear() {
        list.clear();
        assertEquals(list.size(), 0);
        list.clear();
        assertEquals(list.size(), 0);
    }


    /**
     * test lastIndexOf(E obj) method
     */
    public void testLastIndexOf() {
        list.add("apple");
        assertEquals(list.lastIndexOf("apple"), 3);
    }


    /**
     * test toString() method
     */
    public void testToString() {
        String str = "{apple, bee, cat}";
        assertEquals(str.toString(), str);

        str = "{apple, bee, dog, cat}";
        list.add(2, "dog");
        assertEquals(list.toString(), str);

        str = "{ele, apple, bee, dog, cat}";
        list.add(0, "ele");
        assertEquals(list.toString(), str);

        str = "{apple, bee, dog, cat}";
        list.remove(0);
        assertEquals(list.toString(), str);

        str = "{apple, bee, dog}";
        list.remove(3);
        assertEquals(list.toString(), str);

        str = "{apple, bee}";
        list.remove(2);
        assertEquals(list.toString(), str);

        list.clear();
        assertEquals(list.toString(), "{}");
    }


    /**
     * test Iterator()
     */
    public void testIterator() {
        list = new LinkedList<String>();
        String p1 = "1";
        String p2 = "2";
        String p3 = "2";
        String p4 = "2";
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);
        Iterator<String> pp = list.iterator();

        assertEquals(p1, pp.next());
        assertTrue(pp.hasNext());
        assertEquals(p2, pp.next());
        assertTrue(pp.hasNext());
        assertEquals(p3, pp.next());
        assertTrue(pp.hasNext());
        assertEquals(p4, pp.next());
        assertFalse(pp.hasNext());

        Exception e = null;
        try {
            pp.next();
            fail("it should throw an exception");
        }
        catch (Exception ee) {
            e = ee;
        }
        assertTrue("it should throw an exception",
            e instanceof NoSuchElementException);
    }
}
