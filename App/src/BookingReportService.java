import java.util.*;

public class BookingReportService {

    public void generateReport(BookingHistory history) {

        List<Reservation> reservations = history.getConfirmedReservations();

        System.out.println("Booking History Report");
        System.out.println("----------------------");

        if (reservations.isEmpty()) {
            System.out.println("No bookings found.");
            return;
        }

        int count = 1;

        for (Reservation r : reservations) {
            System.out.println("Booking #" + count++);
            System.out.println("Guest Name: " + r.getGuestName());
            System.out.println("Room Type: " + r.getRoomType());
            System.out.println("----------------------");
        }
    }
}