public interface InventoryDelegate<T extends Item >  {
    void addItem(T item);
    void removeItem(int itemID) throws ItemNotFoundException, InsufficientStockException;
    String viewItems();
    public void editItem(T itemToEdit, String editedName, int editedQuantity);
    public void reduceItemQuantity(int itemID) throws ItemNotFoundException, InsufficientStockException;
}