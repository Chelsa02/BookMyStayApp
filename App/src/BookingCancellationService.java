import java.util.Stack;

/**
 * Use Case 10: Booking Cancellation & Inventory Rollback
 */
public class BookingCancellationService {

    private Stack<String> rollbackHistory = new Stack<>();

    public void cancelBooking(Reservation reservation, RoomInventory inventory) {
        if (reservation == null) return;

        String roomType = reservation.getRoomType();

        // 1. Record released room ID in rollback structure (LIFO)
        String releasedRoomId = roomType + "-RECOVERED";
        rollbackHistory.push(releasedRoomId);

        // 2. Increment inventory count using your existing methods
        // First, get the current count
        int currentCount = inventory.getAvailableRooms(roomType);
        // Then, update it by adding 1
        inventory.updateAvailability(roomType, currentCount + 1);

        System.out.println("Booking cancelled successfully. Inventory restored for: " + roomType);
    }

    public void showRollbackHistory() {
        System.out.println("\nRollback History (Most Recent First):");
        if (rollbackHistory.isEmpty()) {
            System.out.println("No cancellations found.");
            return;
        }

        for (int i = rollbackHistory.size() - 1; i >= 0; i--) {
            System.out.println("Released: " + rollbackHistory.get(i));
        }
    }
}
