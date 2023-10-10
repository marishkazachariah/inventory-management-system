public interface InventoryDelegate {
    void addItem(Item item);
    void removeItem(int itemID) throws ItemNotFoundException, InsufficientStockException;
    void viewItems();
    public void editItem(Item taskYouWantToEdit, String editedName);
    public void reduceItemQuantity(int itemID) throws ItemNotFoundException, InsufficientStockException;
    }
