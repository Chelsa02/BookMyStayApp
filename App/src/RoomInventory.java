import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class RoomInventory implements Serializable {
    // serialVersionUID ensures that saved files remain compatible if class structure changes slightly
    private static final long serialVersionUID = 1L;

    private Map<String, Integer> roomAvailability;

    public RoomInventory() {
        roomAvailability = new HashMap<>();
        initializeDefaultInventory();
    }

    private void initializeDefaultInventory() {
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

    public int getAvailableRooms(String roomType) {
        return roomAvailability.getOrDefault(roomType, 0);
    }

    public void bookRooms(String roomType, int count) {
        int current = getAvailableRooms(roomType);
        roomAvailability.put(roomType, Math.max(0, current - count));
    }
}