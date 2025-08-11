package main.BehaviouralPatterns.IteratorPattern;

import java.util.ArrayList;
import java.util.List;

// Step 1: Iterator Interface
interface Iterator<T> {
    boolean hasNext();
    T next();
}

// Step 2: Aggregate Interface
interface Aggregate<T> {
    Iterator<T> createIterator();
}

// Step 3: Concrete Iterator
class BookIterator implements Iterator<Book1> {
    private List<Book1> books;
    private int position = 0;

    public BookIterator(List<Book1> books) {
        this.books = books;
    }

    @Override
    public boolean hasNext() {
        return position < books.size();
    }

    @Override
    public Book1 next() {
        return books.get(position++);
    }
}

// Step 4: Concrete Aggregate
class BookCollection1 implements Aggregate<Book1> {
    private List<Book1> books = new ArrayList<>();

    public void addBook(Book1 book) {
        books.add(book);
    }

    @Override
    public Iterator<Book1> createIterator() {
        return new BookIterator(books);
    }
}

// Step 5: Client Code
public class IteratorPatternExample {
    public static void main(String[] args) {
        BookCollection1 collection = new BookCollection1();
        collection.addBook(new Book1("Design Patterns"));
        collection.addBook(new Book1("Clean Code"));

        Iterator<Book1> iterator = collection.createIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().title);
        }
    }
}

class Book1 {
    String title;
    Book1(String title) { this.title = title; }
}