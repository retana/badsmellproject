package edu.galileo.badsmellproject.controller;

import edu.galileo.badsmellproject.model.Book;
import edu.galileo.badsmellproject.model.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@RestController
@RequestMapping(value = "/api/v1/book")
public class BookController {
    @Autowired
    public BookRepository bookRepository;

    @GetMapping()
    public Object list(){
        return this.bookRepository.findAll();
    }
    @PostMapping
    public Object add(@RequestBody Book book){
        return this.bookRepository.save(book);
    }

    @PutMapping
    public Object edit(@RequestBody Book book){
        return this.bookRepository.save(book);
    }
    @DeleteMapping("/{id}")
    public Object remove(@PathVariable(name = "id", required = true) String  id){
        Optional<Book> result = this.bookRepository.findById(id);
        if(result.isPresent()){
            Book bookToRemove = result.get();
            this.bookRepository.delete(bookToRemove);
            return bookToRemove;
        }else{
            return null;
        }
    }
}
