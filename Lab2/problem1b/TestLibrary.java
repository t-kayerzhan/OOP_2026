package problem1b;

public class TestLibrary {
    public static void main(String[] args) {
        Book book = new Book("The Hobbit", "J.R.R. Tolkien", 1937, 310);
        DVD dvd = new DVD("Inception", "Christopher Nolan", 2010, 148);
        Magazine magazine = new Magazine("National Geographic", "Various", 2023, 2025);

        System.out.println(book);
        System.out.println(dvd);
        System.out.println(magazine);
    }
}