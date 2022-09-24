package com.bridgelabz.Repository;

import com.bridgelabz.Model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart,Long> {

    @Query(value = "SELECT * from bookstoredb.cart where bookId = :bookId and userId = :id",nativeQuery = true)
    Cart findCartByUserIdAndBookId(long bookId, long id);

    @Query(value = "SELECT * From bookstoredb.cart where userId = :userId",nativeQuery = true)
    List<Cart> findCartByUserId(long userId);
}
