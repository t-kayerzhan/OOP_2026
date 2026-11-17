package pr1;

public interface Printable {
	void print();           // every class MUST implement this
    default void preview() {
        System.out.println("Previewing: " + getTitle());
    }
    String getTitle();
}
