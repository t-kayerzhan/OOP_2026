package problem1b;

public class Magazine extends LibraryItem {
    private int issueNumber;

    public Magazine(String title, String author, int publicationYear, int issueNumber) {
        super(title, author, publicationYear);
        this.issueNumber = issueNumber;
    }

    public int getIssueNumber() { return issueNumber; }
    public void setIssueNumber(int issueNumber) { this.issueNumber = issueNumber; }

    @Override
    public String toString() {
        return super.toString() + ", Issue: " + issueNumber;//год выпуска
    }
}