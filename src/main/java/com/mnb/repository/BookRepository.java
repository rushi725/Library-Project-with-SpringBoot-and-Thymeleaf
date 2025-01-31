package com.mnb.repository;

import com.mnb.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {

    List<Book> findByBookName(String keyword);
}
