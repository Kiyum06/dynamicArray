
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class DynamicStringListTest {

    // get() tests
    @Test
    void testGetValidIndex() {
        DynamicStringList list = new DynamicStringList();

        // Arrange
        list.add("Apple");
        list.add("Banana");

        // Act
        String result = list.get(1);

        // Assert
        assertEquals("Banana", result);
    }

    @Test
    void testGetNegativeIndex() {
        DynamicStringList list = new DynamicStringList();
        list.add("Apple");

        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.get(-1);
        });
    }

    @Test
    void testGetIndexTooLarge() {
        DynamicStringList list = new DynamicStringList();
        list.add("Apple");

        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.get(5);
        });
    }


    // set() tests
    @Test
    public void testSetValidIndex() {
        DynamicStringList list = new DynamicStringList();
        list.add("A");
        list.add("B");

        list.set(1, "C");

        assertEquals("C", list.get(1));
    }

    @Test
    public void testSetInvalidIndex() {
        DynamicStringList list = new DynamicStringList();

        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.set(0, "X");
        });
    }

    // add() tests
    @Test
    public void testAddSingleElement() {
        DynamicStringList list = new DynamicStringList();
        list.add("A");

        assertEquals(1, list.size());
        assertEquals("A", list.get(0));
    }

    @Test
    public void testAddMultipleElements() {
        DynamicStringList list = new DynamicStringList();

        list.add("A");
        list.add("B");
        list.add("C");

        assertEquals(3, list.size());
        assertEquals("C", list.get(2));
    }

    @Test
    public void testAddTriggersResize() {
        DynamicStringList list = new DynamicStringList();

        for (int i = 0; i < 15; i++) {
            list.add("X");
        }

        assertEquals(15, list.size());
        assertTrue(list.capacity() >= 15);
    }


    // remove tests
    @Test
    public void testRemoveMiddle() {
        DynamicStringList list = new DynamicStringList();
        list.add("A");
        list.add("B");
        list.add("C");

        String removed = list.remove(1);

        assertEquals("B", removed);
        assertEquals(2, list.size());
        assertEquals("C", list.get(1));
    }

    @Test
    public void testRemoveFirst() {
        DynamicStringList list = new DynamicStringList();
        list.add("A");
        list.add("B");

        list.remove(0);

        assertEquals("B", list.get(0));
    }


    @Test
    public void testRemoveLast() {
        DynamicStringList list = new DynamicStringList();
        list.add("A");
        list.add("B");

        String removed = list.remove(1);

        assertEquals("B", removed);
        assertEquals(1, list.size());
    }


    @Test
    public void testSize() {
        DynamicStringList list = new DynamicStringList();

        list.add("A");
        list.add("B");

        assertEquals(2, list.size());
    }

}