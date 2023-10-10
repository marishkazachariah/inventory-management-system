import java.util.ArrayList;
import java.util.List;

public class Inventory<T extends Item> implements InventoryDelegate<T> {
    private List<T> items = new ArrayList<>();

    @Override
    public void addItem(T item) {
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
            throw new ItemNotFoundException("Item with id " + itemID + " not found.");
        }
    }

    @Override
    public void reduceItemQuantity(int itemID) throws ItemNotFoundException, InsufficientStockException {
        boolean isRemoved = false;
        for (Item item: items) {
            if(item.getID() == itemID) {
                item.setQuantity(item.getQuantity() - 1);
                if(item.getQuantity() <= 0) {
                    throw new InsufficientStockException("Item with id" + itemID + " not in stock.");
                }
                isRemoved = true;
                break;
            }
        }
        if(!isRemoved) {
            throw new ItemNotFoundException("Item with id " + itemID + " not found.");
        }
    }

    @Override
    public void viewItems() {
        StringBuilder listOfItems = new StringBuilder();

        listOfItems.append("ID, Name, Quantity\n");

        // Append artist details to the StringBuilder
        for (Item item : items) {
            listOfItems.append(item.getID()).append(" ").append(item.getName()).append(" ").append(item.getQuantity()).append("\n");
            System.out.println(listOfItems);
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
