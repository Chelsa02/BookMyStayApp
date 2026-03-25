public class BookingCancellation {

    public static void main(String[] args) {
        System.out.println("Booking Cancellation");
        System.out.println("--------------------");

        // Initialize components
        RoomInventory inventory = new RoomInventory();
        BookingCancellationService cancellationService = new BookingCancellationService();

        // Simulate an existing confirmed reservation
        // (Current Reservation class only takes Name and Type)
        Reservation confirmedBooking = new Reservation("John Doe", "Single");

        // Perform Cancellation and Rollback
        cancellationService.cancelBooking(confirmedBooking, inventory);

        // Show Rollback History (LIFO)
        cancellationService.showRollbackHistory();

        // Show updated state
        System.out.println("\nUpdated Single Room Availability: " + inventory.getAvailableRooms("Single"));
    }
}
