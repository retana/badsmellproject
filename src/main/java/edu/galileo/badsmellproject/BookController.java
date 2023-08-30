package edu.galileo.badsmellproject;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping(value = "/api/v1/book")
public class BookController {
    @Autowired
    public BookRepository bookRepository;

    @GetMapping()
    public Object list(){
        return this.operation(null,"list","Operation List","LIST", null,null);
    }
    @PostMapping
    public Object add(@RequestBody Book book){
        return this.operation(book,"add","Operation ADD","SAVE", null,null);
    }

    @PutMapping
    public Object edit(@RequestBody Book book){
        return this.operation(book,"edit","Operation UPDATE","UPDATE", null,null);
    }
    @DeleteMapping("/{id}")
    public Object remove(@PathVariable(name = "id", required = true) String  id){
        System.out.println("DELETE");
        return this.operation(null,"delete","Operation DELETE","DELETE", id,null);
    }
    public Object operation(Book book,String operation, String message, String title,String id, String nothing){
        if(book==null && (operation.equals("add") || operation.equals("edit") )){
            return bookRepository.save(book);
        }
        switch (operation){
            case "add":
                log.info(message,title);
                return bookRepository.save(book);
            case "edit":
                log.info(message,title);
                return  bookRepository.save(book);
            case "list":
                log.info(message,title);
                return this.bookRepository.findAll();
            case "delete":
                try{
                    log.info(message,title);
                    Optional<Book> bookPromise = bookRepository.findById(id);
                    Book bookToRemove = bookPromise.get();
                    bookRepository.delete(bookToRemove);
                    return bookToRemove;
                }catch (Exception e){
                    log.error("DELETE_OPERATION_ERROR", e);
                    e.printStackTrace();
                }

        }
        return null;
    }

}
