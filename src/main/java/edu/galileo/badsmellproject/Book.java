package edu.galileo.badsmellproject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "book")
@Entity
@Data
public class Book implements Serializable {
    private String name;
    private String author;
    @Id
    private String isbn;
}
