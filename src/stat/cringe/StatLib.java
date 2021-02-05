package stat.cringe;

import java.util.Arrays;

public class StatLib {
    private String title;
    private StatBook[] statBooks;

    public StatLib(String title, StatBook[] statBooks) {
        this.title = title;
        this.statBooks = statBooks;
    }

    public StatLib(String title, int booksQuantity) {
        this(title, new StatBook[booksQuantity]);
    }

    @Override
    public String toString() {
        return "StatLib{" +
                "title='" + title + '\'' +
                ", books=" + Arrays.toString(statBooks) +
                '}';
    }

    ///

//    public boolean addBook(StatBook bookToAdd) {
//        boolean exist = false;
//        for (StatBook currStatBook_i : statBooks) {
//            if (currStatBook_i.getId() == bookToAdd.getId()) {
//
//                // Бред
//            }
//        }
//    }

    ///


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public StatBook[] getStatBooks() {
        return statBooks;
    }

    public void setStatBooks(StatBook[] statBooks) {
        this.statBooks = statBooks;
    }
}
