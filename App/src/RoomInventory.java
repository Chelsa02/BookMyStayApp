import java.util.HashMap;
import java.util.Map;

public class RoomInventory {

    private Map<String, Integer> roomAvailability;

    public RoomInventory() {
        roomAvailability = new HashMap<>();
        initializeInventory();
    }

    private void initializeInventory() {
        roomAvailability.put("Single", 5);
        roomAvailability.put("Double", 3);
        roomAvailability.put("Suite", 2);
    }

    public Map<String, Integer> getRoomAvailability() {
        return roomAvailability;
    }

    public void updateAvailability(String roomType, int count) {
        roomAvailability.put(roomType, count);
    }

    // ✅ ADD THIS METHOD HERE
    public int getAvailableRooms(String roomType) {
        return roomAvailability.getOrDefault(roomType, 0);
    }

    // ✅ ALSO ADD THIS (for your 2nd error)
    public void bookRooms(String roomType, int count) {
        int current = getAvailableRooms(roomType);
        roomAvailability.put(roomType, current - count);
    }
}