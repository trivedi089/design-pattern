package main.BehaviouralPatterns.IteratorPattern;

import java.util.ArrayList;
import java.util.List;

class Book {
    String title;
    Book(String title) { this.title = title; }
}

class BookCollection {
    List<Book> books = new ArrayList<>();

    void addBook(Book book) {
        books.add(book);
    }
}

public class WithourIteratorPattern {
    public static void main(String[] args) {
        BookCollection collection = new BookCollection();
        collection.addBook(new Book("Design Patterns"));
        collection.addBook(new Book("Clean Code"));

        // BAD: Directly accessing internal list
        for (int i = 0; i < collection.books.size(); i++) {
            System.out.println(collection.books.get(i).title);
        }
    }
}
