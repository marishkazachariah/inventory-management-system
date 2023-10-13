import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InventoryTest {

    private Inventory<FoodItem> inventory = new Inventory<>();

    @BeforeEach
    public void setupInventory() {
        inventory = new Inventory<>();
    }

    @Test
    @DisplayName("item is added to the inventory")
    void addItem() {
        inventory.addItem(new FoodItem(1, "Hamburger", 2));
        assertTrue(inventory.viewItems().contains("Hamburger"));
    }

    @Test
    @DisplayName("item is removed from the inventory")
    void removeItem() {
        inventory.addItem(new FoodItem(2, "Potatoes", 4));
        assertDoesNotThrow(() -> inventory.removeItem(2));
        assertFalse(inventory.viewItems().contains("Potatoes"));
    }

    @Test
    @DisplayName("ItemNotFoundException thrown when removing item")
    void RemoveItemNotFoundException() {
        assertThrows(ItemNotFoundException.class, () -> inventory.removeItem(1));
    }

    @Test
    @DisplayName("InsufficientStockException thrown when removing item")
    void RemoveItemInsufficientStockException() {
        inventory.addItem( new FoodItem(1, "Tomato", 0));
        assertThrows(InsufficientStockException.class, () -> inventory.removeItem(1));
    }

    @Test
    @DisplayName("reduce item quantity by one using item id")
    void reduceItemQuantity() {
        FoodItem cheese = new FoodItem(2, "Cheese", 5);
        inventory.addItem(cheese);
        assertDoesNotThrow(() -> inventory.reduceItemQuantity(2));
        assertEquals(4, cheese.getQuantity());
    }

    @Test
    @DisplayName("ItemNotFoundException thrown when reducing item quantity")
    void ReduceItemQuantityItemNotFoundException() {
        assertThrows(ItemNotFoundException.class, () -> inventory.reduceItemQuantity(23));
    }

    @Test
    @DisplayName("InsufficientStockException thrown when reducing item quantity")
    void ReduceItemQuantityInsufficientStockException() {
        inventory.addItem(new FoodItem(1, "Crackers", 0));
        assertThrows(InsufficientStockException.class, () -> inventory.reduceItemQuantity(1));
    }

    @Test
    @DisplayName("view items in inventory")
    void viewItems() {
        inventory.addItem(new FoodItem(5, "Chocolate", 10));
        inventory.addItem(new FoodItem(6, "Eggs", 6));
        inventory.addItem(new FoodItem(7, "Bread", 1));
        assertTrue(inventory.viewItems().contains("Chocolate"));
        assertTrue(inventory.viewItems().startsWith("ID"));
    }

    @Test
    @DisplayName("edit an item in the inventory")
    void editItem() {
        FoodItem chips = new FoodItem(8, "Chips", 3);
        inventory.addItem(chips);
        inventory.editItem(chips, "Crisps", 3);
        assertEquals("Crisps", chips.getName());
    }
}