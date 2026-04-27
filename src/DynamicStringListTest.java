
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

    
}