package com.bridgelabz.Repository;

import com.bridgelabz.Model.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository <BookEntity, Long> {
    public List<BookEntity>findAllByNameStartingWith(String Name);
}
