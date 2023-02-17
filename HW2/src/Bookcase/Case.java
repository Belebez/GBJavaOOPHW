package Bookcase;


import java.util.ArrayList;

public class Case {
    // создадим массив для хранения объектов класса Book
//    static ArrayList<Book> caseBook = new ArrayList<>(Book.getBookList());


    public static int countBook(){
        return Book.getBookList().size();
    }

    public static void deleteBook(String s) {
        if (Book.getBookList().size() == 0) {
            System.out.println("Книг нет, в нашей библиотеке...");
        } else {
            Book.getBookList().removeIf(book -> (book.getNameBook().equalsIgnoreCase(s)) || (book.getWriterBook().equalsIgnoreCase(s)));
        }
    }

    public static void searchBook(String s) {
        // создадим переменную для подсчета найденых книг, если таких нет, то сообщим
        int count = 0;

        // проверим первый символ, если это цифра, то выведим всё по совпадающему году, если нет, то по автору или названию.
        if (Character.isDigit(s.charAt(0))) {
            int year = Integer.parseInt(s);
            for (Book book: Book.getBookList()) {
                if (year == book.getDatePublication()) {
                    count++;
                    System.out.println(book);
                }
            }
        } else if (Character.isLetter(s.charAt(2))){
            for (Book book: Book.getBookList()) {
                if ((book.getNameBook().toLowerCase().contains(s))||(book.getWriterBook().toLowerCase().contains(s))) {
                    count++;
                    System.out.println(book);
                }
            }
        }
        if (count == 0) {
            System.out.println("\nКниги, с таким параметром у нас нет.\n");
        }
    }

    public static void addBook(String s) {
        String[] string = s.split(" ");
        for (int i = 0; i < Book.getBookList().size(); i++) {

        }
    }


}
