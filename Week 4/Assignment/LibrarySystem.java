public class LibrarySystem {

    // Book class
    static class Book {
        // Fields
        String title;
        String author;
        String isbn;
        boolean isAvailable;

        // 1. Default constructor → empty book
        public Book() {
            this.title = "Untitled";
            this.author = "Unknown";
            this.isbn = "N/A";
            this.isAvailable = true;
        }

        // 2. Constructor with title and author
        public Book(String title, String author) {
            this.title = title;
            this.author = author;
            this.isbn = "N/A";
            this.isAvailable = true;
        }

        // 3. Constructor with all details
        public Book(String title, String author, String isbn, boolean isAvailable) {
            this.title = title;
            this.author = author;
            this.isbn = isbn;
            this.isAvailable = isAvailable;
        }

        // borrowBook() → sets available = false
        public void borrowBook() {
            if (isAvailable) {
                isAvailable = false;
                System.out.println("📕 Book borrowed: " + title);
            } else {
                System.out.println("❌ Book is already borrowed: " + title);
            }
        }

        // returnBook() → sets available = true
        public void returnBook() {
            if (!isAvailable) {
                isAvailable = true;
                System.out.println("📗 Book returned: " + title);
            } else {
                System.out.println("ℹ️ Book was not borrowed: " + title);
            }
        }

        // displayBookInfo()
        public void displayBookInfo() {
            System.out.println("📘 Book Info:");
            System.out.println("Title      : " + title);
            System.out.println("Author     : " + author);
            System.out.println("ISBN       : " + isbn);
            System.out.println("Available  : " + (isAvailable ? "Yes" : "No"));
            System.out.println("--------------------------------");
        }
    }

    // main method
    public static void main(String[] args) {
        // Book 1: Default constructor
        Book book1 = new Book();
        book1.displayBookInfo();

        // Book 2: Constructor with title and author
        Book book2 = new Book("1984", "George Orwell");
        book2.displayBookInfo();
        book2.borrowBook();   // Borrowing
        book2.displayBookInfo();
        book2.borrowBook();   // Try borrowing again
        book2.returnBook();   // Returning
        book2.returnBook();   // Try returning again
        book2.displayBookInfo();

        // Book 3: Full constructor
        Book book3 = new Book("The Hobbit", "J.R.R. Tolkien", "978-0261102217", true);
        book3.displayBookInfo();
        book3.borrowBook();
        book3.displayBookInfo();
    }
}
