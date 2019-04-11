package com.bsc.Book;

import com.bsc.BookService.Book;
import com.bsc.BookService.BookRepository;
import com.bsc.BookService.BookServiceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by amritag on 4/11/2019.
 */
@RestController
@RequestMapping("/")
public class BookController {

    @Autowired
    private BookRepository repository;

    @Autowired
    private BookServiceRepo serviceRepo;

    /* Get list of 20 books by date and price less dan equal to 500*/
    @GetMapping("/book?limit=20&sort_by=Date&price:lte:500")
    public List<Book> index(){
        return repository.findAll();
    }

    /* find the book of given id*/
    @GetMapping("/book/{id}")
    public Book show(@PathVariable String id){
        int BookId = Integer.parseInt(id);
        return repository.findById(BookId);
    }

    /* Add New Book along with all the details*/
    @PostMapping("/book")
    public Book create(@RequestBody Book book){
        int id = book.setBookId(book.getBookId());
        String AuthorName = book.setAuthorName(book.getAuthorName());
        String BookName = book.setBookName(book.getBookName());
        int Price = book.setPrice(book.getPrice());
        return repository.save(book);
    }

    /*Update Book Price */
    @PutMapping("/book/{id}")
    public Book update(@PathVariable String Bookid, @RequestBody Book book){
       // int id = book.setBookId(book.getBookId());
        int price =book.setPrice(500);
        return repository.save(book);
    }
   /*Delete Book of given id */
    @DeleteMapping("book/{id}")
    public void delete(@PathVariable String id){
        int bookid = Integer.parseInt(id);
        repository.delete(repository.findById(bookid));
    }

}
