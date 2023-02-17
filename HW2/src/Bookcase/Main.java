package Bookcase;

/*
 *** Необязательное задание**
 * Написать программу - реализацию книжного шкафа в библиотеке.
 * Должны иметь возможность добавлять \ удалять книги.
 * Узнать кол-во книг
 * При запросе сообщить есть ли такая книга у нас или нет
 * Делаем с принципом инкапсуляции. Используем геттеры, сеттеры, конструкторы
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("Братья Карамазовы", "Достоевский", 1880);
//        Book book2 = new Book("Бесы", "Достоевский", 1873);
//        Book book3 = new Book("Морской Волк", "Лондон", 1904);
//        Book book4 = new Book("Капитанская дочка", "Пушкин", 1836);
//        Book book5 = new Book("Евгений Онегин", "Пушкин", 1833);
//
//        // метод для понимания количества книг
//        Case.countBook();
//        // метод удаления книги
//        Case.deleteBook("Бесы");
//        //
//        Case.countBook();
//        // метод поиска книги
//        Case.searchBook("1880");
//        Case.searchBook("Морской Волк");

        boolean flag = true;
        while (flag) {
            System.out.print("\nБиблиотека\n \nВыберите пункт:\n" +
                    "1. Список книг.\n" +
                    "2. Количество книг.\n" +
                    "3. Найти книгу.\n" +
                    "4. Добавить книгу.\n" +
                    "5. Удалить книгу.\n" +
                    "\n" +
                    "0. Выход\n");
            System.out.print("\nВведите номер задачи --> ");
            Scanner scanner1 = new Scanner(System.in);
            int taskNum1 = scanner1.nextInt();
            switch (taskNum1) {
                case 1 :
                    Case.listBook();
                    break;
                case 2 :
                    Case.countBook();
                    break;
                case 3 :
                    System.out.print("\nВведите название книги или фамилию писателя, или год публикации --> ");
                    Scanner scanner3 = new Scanner(System.in);
                    String string = scanner3.nextLine();
                    Case.searchBook(string);
                    break;
                case 4 :
//                    System.out.println("К сожалению, пока в разработке..");
                    System.out.print("\nВведите название книги, фамилию писателя, год публикации через пробел --> ");
                    Scanner scanner4 = new Scanner(System.in);
                    String string1 = scanner4.nextLine();
                    Case.addBook(string1);
                    break;
                case 5 :
                    System.out.print("\nВведите название книги --> ");
                    Scanner scanner5 = new Scanner(System.in);
                    String string2 = scanner5.nextLine();
                    Case.deleteBook(string2);
                    break;
                case 0 :
                    System.out.println("Всего доброго.");
                    flag = false;
            }
        }
    }
}
