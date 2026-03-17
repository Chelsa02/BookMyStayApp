import java.util.HashMap;
import java.util.Map;

public class RoomInventory {

    // Stores available room count for each room type
    private Map<String, Integer> roomAvailability;

    // Constructor initializes the inventory
    public RoomInventory() {
        roomAvailability = new HashMap<>();
        initializeInventory();
    }

    // Initialize default room availability
    private void initializeInventory() {
        roomAvailability.put("Single", 5);
        roomAvailability.put("Double", 3);
        roomAvailability.put("Suite", 2);
    }

    // Returns current availability
    public Map<String, Integer> getRoomAvailability() {
        return roomAvailability;
    }

    // Update availability for a room type
    public void updateAvailability(String roomType, int count) {
        roomAvailability.put(roomType, count);
    }
}