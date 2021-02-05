package stat.cringe;

public class StatBook {
    private static int idCounter = 67;
    private int id;
    private String title;
    private String author;
    private int pages;

    public StatBook(String title, String author, int pages) {
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.id = idCounter++;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", pages=" + pages +
                '}';
    }

    public static void setIdCounter(int idCounter) {
        StatBook.idCounter = idCounter;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }
}
