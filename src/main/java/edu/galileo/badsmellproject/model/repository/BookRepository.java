package edu.galileo.badsmellproject.model.repository;

import edu.galileo.badsmellproject.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book,String> {
    List<Book> findAll();
}

