public class BookingHistoryReport {

    public static void main(String[] args) {

        BookingHistory history = new BookingHistory();

        // Create reservations (ONLY 2 parameters)
        Reservation r1 = new Reservation("Alice", "Single");
        Reservation r2 = new Reservation("Bob", "Double");

        history.addReservation(r1);
        history.addReservation(r2);

        BookingReportService reportService = new BookingReportService();
        reportService.generateReport(history);
    }
}