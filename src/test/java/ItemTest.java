import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ItemTest {
    Item item = new ElectronicsItem(2, "iPod", 2);

    @Test
    @DisplayName("item id should return 2")
    void getID() {
        assertEquals(2, item.getID());
    }

    @Test
    @DisplayName("item id should return 4 after setting id")
    void setID() {
        item.setID(4);
        assertEquals(4, item.getID());
    }

    @Test
    @DisplayName("item id should return \"iPod\" after getting item")
    void getName() {
        assertEquals("iPod", item.getName());
    }

    @Test
    @DisplayName("item name should return \"Walkman\" after setting name")
    void setName() {
        item.setName("Walkman");
        assertEquals("Walkman", item.getName());
    }

    @Test
    @DisplayName("item quantity should return 2 after getting quantity")
    void getQuantity() {
        assertEquals(2, item.getQuantity());
    }

    @Test
    @DisplayName("item quantity should return 5 after setting quantity")
    void setQuantity() {
        item.setQuantity(5);
        assertEquals(5, item.getQuantity());
    }
}