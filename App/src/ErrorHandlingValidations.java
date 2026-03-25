import java.util.Scanner;

public class ErrorHandlingValidations {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        RoomInventory inventory = new RoomInventory();
        ReservationValidator validator = new ReservationValidator();

        try {
            System.out.print("Enter guest name: ");
            String guestName = scanner.nextLine();

            System.out.print("Enter room type (Single/Double/Suite): ");
            String roomType = scanner.nextLine();

            System.out.print("Enter number of rooms: ");
            int rooms = scanner.nextInt();

            // ✅ VALIDATION FIRST (Fail-Fast)
            validator.validate(guestName, roomType, rooms, inventory);

            // ✅ THEN UPDATE STATE
            inventory.bookRooms(roomType, rooms);

            System.out.println("Booking successful!");

        } catch (InvalidBookingException e) {
            System.out.println("Booking failed: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}