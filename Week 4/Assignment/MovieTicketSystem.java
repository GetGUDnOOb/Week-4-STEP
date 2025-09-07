public class MovieTicketSystem {

    // MovieTicket class
    static class MovieTicket {
        // Fields
        String movieName;
        String theatreName;
        int seatNumber;
        double price;

        // 1. Default constructor → assigns "Unknown" movie.
        public MovieTicket() {
            this.movieName = "Unknown";
            this.theatreName = "Not Assigned";
            this.seatNumber = 0;
            this.price = 0.0;
        }

        // 2. Constructor with movie name → assigns default price = 200.
        public MovieTicket(String movieName) {
            this.movieName = movieName;
            this.theatreName = "Not Assigned";
            this.seatNumber = 0;
            this.price = 200.0;
        }

        // 3. Constructor with movie name and seat number → assigns default theatre "PVR".
        public MovieTicket(String movieName, int seatNumber) {
            this.movieName = movieName;
            this.seatNumber = seatNumber;
            this.theatreName = "PVR";
            this.price = 200.0;
        }

        // 4. Full constructor → sets all details.
        public MovieTicket(String movieName, String theatreName, int seatNumber, double price) {
            this.movieName = movieName;
            this.theatreName = theatreName;
            this.seatNumber = seatNumber;
            this.price = price;
        }

        // Method to print ticket details
        public void printTicket() {
            System.out.println("🎟️ Movie Ticket Details:");
            System.out.println("Movie Name   : " + movieName);
            System.out.println("Theatre Name : " + theatreName);
            System.out.println("Seat Number  : " + seatNumber);
            System.out.println("Price        : ₹" + price);
            System.out.println("--------------------------------");
        }
    }

    // main method
    public static void main(String[] args) {
        // Create multiple tickets using different constructors

        // Ticket 1: Default constructor
        MovieTicket ticket1 = new MovieTicket();
        ticket1.printTicket();

        // Ticket 2: Constructor with movie name only
        MovieTicket ticket2 = new MovieTicket("Inception");
        ticket2.printTicket();

        // Ticket 3: Constructor with movie name and seat number
        MovieTicket ticket3 = new MovieTicket("Interstellar", 12);
        ticket3.printTicket();

        // Ticket 4: Full constructor
        MovieTicket ticket4 = new MovieTicket("Dune", "INOX", 5, 350.0);
        ticket4.printTicket();
    }
}
