package com.bridgelabz.Model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name="Cart")
@NoArgsConstructor
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cartId", nullable = false)
    private long cartId;

    @ManyToOne
    @JoinColumn(name = "bookId")
    public BookEntity bookEntity;

    @OneToOne
    @JoinColumn(name="userId")
    public User user;

    public Integer quantity;
    public double totalPrice;

    public Cart(BookEntity bookId, User userId, Integer quantity, double totalPrice) {
        this.bookEntity = bookId;
        this.user = userId;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }
}
