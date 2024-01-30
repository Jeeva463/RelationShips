package com.example.relationship.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.relationship.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book,UUID> {

}
