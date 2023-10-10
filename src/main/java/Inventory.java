import java.util.ArrayList;
import java.util.List;

public class Inventory implements InventoryDelegate {
    List<Item> items = new ArrayList<>();

    @Override
    public void addItem(Item item) {
        items.add(item);
    }

    @Override
    public void removeItem(int itemID) throws ItemNotFoundException, InsufficientStockException {
        boolean isRemoved = false;
        for (Item item: items) {
            if(item.getID() == itemID) {
                if(item.getQuantity() <= 0) {
                    throw new InsufficientStockException("Item " + itemID + " not in stock.");
                }
                items.remove(item);
                isRemoved = true;
                break;
            }
        }
        if(!isRemoved) {
            throw new ItemNotFoundException("Item with " + itemID + " not found.");
        }
    }

    @Override
    public void reduceItemQuantity(int itemID) throws ItemNotFoundException, InsufficientStockException {
        boolean isRemoved = false;
        for (Item item: items) {
            if(item.getID() == itemID) {
                item.setQuantity(item.getQuantity() - 1);
                if(item.getQuantity() <= 0) {
                    throw new InsufficientStockException("Item " + itemID + " not in stock.");
                }
                isRemoved = true;
                break;
            }
        }
        if(!isRemoved) {
            throw new ItemNotFoundException("Item with " + itemID + " not found.");
        }
    }

    @Override
    public void viewItems() {
        for (int i = 0; i < items.size(); i++) {
            System.out.println(" " + items.get(i).toString());
        }
    }

    @Override
    public void editItem(Item taskYouWantToEdit, String editedName){
        for (Item item : items) {
            if (item.equals(taskYouWantToEdit)) {
                item.setName(editedName);
            }
        }
    }
}
