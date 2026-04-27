
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class DynamicStringListTest {

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
}