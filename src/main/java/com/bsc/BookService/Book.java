package com.bsc.BookService;

/**
 * Created by amritag on 4/11/2019.
 */
public class Book {

    private String BookName;
    private int Price;
    private final ThreadLocal<String> AuthorName = new ThreadLocal<>();
    private int BookId;


    public Book()
    {

    }
    public Book(String bookName, int price, String authorName, int bookId) {
        BookName = bookName;
        Price = price;
        AuthorName.set(authorName);
        BookId = bookId;
    }

    public String getBookName() {
        return BookName;
    }

    public String setBookName(String bookName) {
        return bookName;
    }

    public int getPrice() {
        return Price;
    }

    public int setPrice(int price) {
        return price;
    }

    public String getAuthorName() {
        return AuthorName.get();
    }

    public String setAuthorName(String authorName) {
        return authorName;
    }

    public int getBookId() {
        return BookId;
    }

    public int setBookId(int bookId) {
        return  bookId;
    }

    @Override
    public String toString() {
        return "Book{" +
                "BookName='" + BookName + '\'' +
                ", Price=" + Price +
                ", AuthorName=" + AuthorName +
                ", BookId=" + BookId +
                '}';
    }
}
