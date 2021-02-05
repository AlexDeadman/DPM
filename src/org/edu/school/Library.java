package org.edu.school;

import java.util.Arrays;

public class Library {
    private String title;
    private Book[] books;

    public Library(String title, Book[] books) {
        this.title = title;
        this.books = books;
    }

    public Library(String title, int booksQuantity) {
        this(title, new Book[booksQuantity]);
    }

    @Override
    public String toString() {
        return "Library{" +
                "title='" + title + '\'' +
                ", books=" + Arrays.toString(books) +
                '}';
    }

//  ------------------------------------------------------------------------


    public int getAllPages() {
        int allPages = 0;
        for (Book currBook : books) {
            allPages += currBook.getPages();
        }
        return allPages;
    }

    public boolean hasBook(String title) {
        for (Book currBook : books) {
            if (currBook.getTitle().equals(title)) {
                return true;
            }
        }
        return false;
    }

    public Book[] getAuthorBooks(String searchAuthor) {
        Book[] authorBooks = new Book[books.length];
        for (int i = 0; i < books.length; i++) {
            if(books[i].getAuthor().equals(searchAuthor)) {
                authorBooks[i] = books[i].copy();
            }
        }
        return authorBooks;
    }

    public void printAuthorBooks(String searchAuthor) {
        boolean notFound = true;

        System.out.print("Books by " + searchAuthor + ": ");
        for (Book currBook : this.getAuthorBooks(searchAuthor)) {
            if (currBook != null) {
                System.out.print( '\"' + currBook.getTitle() + "\" ");
                notFound = false;
            }
        }

        if(notFound) {
            System.out.println("ERROR: \"404 NOT FOUND\", COMMENT: \"TOTAL CRINGE BRO\"");
        } else {
            System.out.println();
        }
    }

//  ------------------------------------------------------------------------

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Book[] getBooks() {
        return books;
    }

    public void setBooks(Book[] books) {
        this.books = books;
    }
}
