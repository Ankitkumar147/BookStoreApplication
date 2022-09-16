package com.bridgelabz.Model;

import com.bridgelabz.DTO.BookDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name="Book")
@NoArgsConstructor
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler", "fieldHandler"})
@SequenceGenerator(name = "seq",initialValue = 1)
public class BookEntity {
    @Id
    @GeneratedValue(generator = "seq")
    private long bookId;

    private String name;
    private String author;

    private int price;
    private Integer quantity;

    @Column(length = 1000)
    private String description;


    public BookEntity(BookDto bookDto) {
        this.bookId = bookId;
        this.name = bookDto.getName();
        this.author = bookDto.getAuthor();
        this.price = bookDto.getPrice();
        this.quantity = bookDto.getQuantity();
        this.description = bookDto.getDescription();
    }

    public BookEntity(long bookId, BookDto bookDto) {
        this.bookId = bookId;
        this.name = bookDto.getName();
        this.author = bookDto.getAuthor();
        this.price = bookDto.getPrice();
        this.quantity = bookDto.getQuantity();
        this.description = bookDto.getDescription();
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }
}
