package problem1b;

public class DVD extends LibraryItem {
    private int duration; // in minutes

    public DVD(String title, String author, int publicationYear, int duration) {
        super(title, author, publicationYear);
        this.duration = duration;
    }

    public int getDuration() { return duration; }
    public void setDuration(int duration) { this.duration = duration; }

    @Override
    public String toString() {
        return super.toString() + ", Duration: " + duration + " min";
    }
}