package com.bsc.BookService;


import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by amritag on 4/11/2019.
 */
public interface BookRepository extends MongoRepository <Book , Integer> {

    Book findById(int BookId);

}
