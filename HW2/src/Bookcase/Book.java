package Bookcase;

import java.util.HashMap;

public class Book {
    private String nameBook;
    private String writerBook;
    private int datePublication;

    private static int id;
    private static HashMap<Integer, Book> bookList = new HashMap<Integer, Book>();

    static {
        Book.id = 0;
    }
    public Book(String nameBook, String writerBook, int datePublication) {
        this.nameBook = nameBook;
        this.writerBook = writerBook;
        this.datePublication = datePublication;
        bookList.put(++Book.id, Book.this);
    }

    public Book(String[] string) {
        this.nameBook = string[0];
        this.writerBook = string[1];
        this.datePublication = Integer.parseInt(string[2]);
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

    public static HashMap<Integer, Book> getBookList() {
        return bookList;
    }

    public static void setBookList(HashMap<Integer, Book> bookList) {
        Book.bookList = bookList;
    }
}
