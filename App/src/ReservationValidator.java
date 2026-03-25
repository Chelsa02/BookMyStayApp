import java.util.Set;

public class ReservationValidator {

    private static final Set<String> VALID_ROOM_TYPES = Set.of("Single", "Double", "Suite");

    public void validate(String guestName, String roomType, int roomsRequested, RoomInventory inventory)
            throws InvalidBookingException {

        // Guest name validation
        if (guestName == null || guestName.trim().isEmpty()) {
            throw new InvalidBookingException("Guest name cannot be empty.");
        }

        // Room type validation
        if (!VALID_ROOM_TYPES.contains(roomType)) {
            throw new InvalidBookingException("Invalid room type.");
        }

        // Room count validation
        if (roomsRequested <= 0) {
            throw new InvalidBookingException("Room count must be greater than 0.");
        }

        // Inventory validation
        int available = inventory.getAvailableRooms(roomType);
        if (available < roomsRequested) {
            throw new InvalidBookingException("Not enough rooms available.");
        }
    }
}