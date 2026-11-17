package pr1;

class Photo implements Printable, Saveable {
    private String title;
    private int    width, height;

    public Photo(String title, int width, int height) {
        this.title  = title;
        this.width  = width;
        this.height = height;
    }

    @Override public String getTitle() { return title; }

    @Override
    public void print() {
        System.out.println("=== Printing Photo: " + title+ " [" + width + "x" + height + "] ===");
    }

    @Override
    public void save(String path) {
        System.out.println("Saving photo '" + title + "' to " + path);
    }
}