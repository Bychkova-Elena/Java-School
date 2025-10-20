package school.javacore.exceptions.project;

import school.javacore.exceptions.project.exception.NoAvailableCopiesException;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Library {
    private List<Book> catalog;

    public Library() {
        this.catalog = new ArrayList<>();
    }

    public void addBook(String title, String author, int copies) {
        catalog.add(new Book(title, author, copies));
    }

    public void takeBook(String title) {
        Book takenBook = null;
        for (Book book : catalog) {
            if (book.getTitle().equals(title)) {
                takenBook = book;
            }
        }

        if (takenBook == null) {
            throw new NoSuchElementException("Нет такой книги!");
        }

        if (takenBook.getAvailableCopies() == 0) {
            throw new NoAvailableCopiesException();
        }

        takenBook.setAvailableCopies(takenBook.getAvailableCopies() - 1);
    }

    public void returnBook(String title) {
        Book returnBook = null;
        for (Book book : catalog) {
            if (book.getTitle().equals(title)) {
                returnBook = book;
            }
        }

        if (returnBook == null) {
            throw new NoSuchElementException("Нет такой книги!");
        }

        returnBook.setAvailableCopies(returnBook.getAvailableCopies() + 1);
    }

    public List<Book> getAllBooks() {
        return catalog;
    }
}
