package Bookcase;

import java.util.ArrayList;

public class Book {
    private String nameBook;
    private String writerBook;
    private int datePublication;
    private static ArrayList<Book> bookList = new ArrayList<>();

    public Book(String nameBook, String writerBook, int datePublication) {
        this.nameBook = nameBook;
        this.writerBook = writerBook;
        this.datePublication = datePublication;
        bookList.add(Book.this);
    }

    @Override
    public String toString() {
        return "\nКнига:\n" +
                "1. Название = " + nameBook + "\n" +
                "2. Писатель = " + writerBook + "\n" +
                "3. Дата публикации = " + datePublication + " г.\n";
    }

    public String getNameBook() {
        return nameBook;
    }

    public String getWriterBook() {
        return writerBook;
    }

    public int getDatePublication() {
        return datePublication;
    }

    public static ArrayList<Book> getBookList() {
        return bookList;
    }

}
