package com.example.relationship.repository;

import java.util.Optional;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.relationship.entity.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, UUID> {
	@Query(value = "SELECT * FROM author_details where author_name=:authorName", nativeQuery = true)
	Optional<Author> findbyAuthorname(String authorName);
	

}
