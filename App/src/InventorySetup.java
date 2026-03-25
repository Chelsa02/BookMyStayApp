import java.io.Serializable;
import java.util.Map;

// Implementing Serializable allows this object to be saved to a file
public class InventorySetup implements Serializable {

    // Assuming RoomInventory is the class that holds the actual Map
    private RoomInventory roomInventory = new RoomInventory();

    // This is the method your Recovery class was looking for
    public void initializeInventory(int single, int doubleR, int suite) {
        // Here you would call the logic to set these specific numbers
        // For now, let's assume roomInventory handles the storage
        System.out.println("Initializing inventory with " + single + " Singles, " + doubleR + " Doubles, and " + suite + " Suites.");
    }

    // This is the method for displaying the status
    public void displayInventory() {
        Map<String, Integer> rooms = roomInventory.getRoomAvailability();

        System.out.println("Current Inventory:");
        System.out.println("Single: " + rooms.getOrDefault("Single", 0));
        System.out.println("Double: " + rooms.getOrDefault("Double", 0));
        System.out.println("Suite: " + rooms.getOrDefault("Suite", 0));
    }
}