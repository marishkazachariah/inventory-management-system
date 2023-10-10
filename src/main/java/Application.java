public class Application {
    public void run() {
        // Create an inventory for FoodItems and add items
        Inventory<FoodItem> foodInventory = new Inventory<>();
        foodInventory.addItem(new FoodItem(1, "Cereal", 3));
        foodInventory.addItem(new FoodItem(2, "Bagel", 6));

        // Create an inventory for ElectronicsItems and add items
        Inventory<ElectronicsItem> electronicsInventory = new Inventory<>();
        electronicsInventory.addItem(new ElectronicsItem(1, "Smartphone", 4));
        electronicsInventory.addItem(new ElectronicsItem(2, "Laptop", 4));

        // view items from the electronics inventory
       electronicsInventory.viewItems();

        // implement try/catch method
        try {
            foodInventory.removeItem(3);
        } catch (ItemNotFoundException | InsufficientStockException e) {
            System.out.println(e.getMessage());
        }
    }
}
