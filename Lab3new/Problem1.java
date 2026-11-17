package pr1;

public class Problem1 {
    public static void main(String[] args) {
        System.out.println("====== INTERFACE EXAMPLE ======");
        Document doc   = new Document("Lab Report", "Results: OK");
        Photo    photo = new Photo("Sunset", 1920, 1080);

        doc.print();
        doc.preview();          // default method from interface
        doc.save("/home/user/lab.txt");

        System.out.println();
        photo.print();
        photo.save("/home/user/sunset.jpg");

        System.out.println("\nABSTRACT CLASS EXAMPLE ======");
        Shape[] shapes = { new Circle("red", 5), new Rectangle("blue", 4, 6) };
        for (Shape s : shapes) s.describe();
    }
}