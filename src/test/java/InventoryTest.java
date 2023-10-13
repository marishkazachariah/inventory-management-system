import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InventoryTest {

    private Inventory<FoodItem> inventory = new Inventory<>();

    @BeforeEach
    public void setupInventory() {
        inventory = new Inventory<>();
    }

    @Test
    void addItem() {
        inventory.addItem(new FoodItem(1, "Hamburger", 2));
        assertTrue(inventory.viewItems().contains("Hamburger"));
    }

    @Test
    void removeItem() {
        inventory.addItem(new FoodItem(2, "Potatoes", 4));
        assertDoesNotThrow(() -> inventory.removeItem(2));
        assertFalse(inventory.viewItems().contains("Potatoes"));
    }

    @Test
    void RemoveItemNotFoundException() {
        assertThrows(ItemNotFoundException.class, () -> inventory.removeItem(1));
    }

    @Test
    void RemoveItemInsufficientStockException() {
        inventory.addItem( new FoodItem(1, "Tomato", 0));
        assertThrows(InsufficientStockException.class, () -> inventory.removeItem(1));
    }

    @Test
    void reduceItemQuantity() {
        FoodItem cheese = new FoodItem(2, "Cheese", 5);
        inventory.addItem(cheese);
        assertDoesNotThrow(() -> inventory.reduceItemQuantity(2));
        assertEquals(4, cheese.getQuantity());
    }

    @Test
    void ReduceItemQuantityItemNotFoundException() {
        assertThrows(ItemNotFoundException.class, () -> inventory.reduceItemQuantity(23));
    }

    @Test
    void ReduceItemQuantityInsufficientStockException() {
        inventory.addItem(new FoodItem(1, "Crackers", 0));
        assertThrows(InsufficientStockException.class, () -> inventory.reduceItemQuantity(1));
    }

    @Test
    void viewItems() {
        inventory.addItem(new FoodItem(5, "Chocolate", 10));
        inventory.addItem(new FoodItem(6, "Eggs", 6));
        inventory.addItem(new FoodItem(7, "Bread", 1));
        assertTrue(inventory.viewItems().contains("Chocolate"));
        assertTrue(inventory.viewItems().startsWith("ID"));
    }

    @Test
    void editItem() {
        FoodItem chips = new FoodItem(8, "Chips", 3);
        inventory.addItem(chips);
        inventory.editItem(chips, "Crisps", 3);
        assertEquals("Crisps", chips.getName());
    }
}