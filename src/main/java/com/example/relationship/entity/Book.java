package com.example.relationship.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="book_details")
public class Book {
	@Id
	@GeneratedValue(generator="UUID")
	@Type(type="uuid-char")
	@Column(name="book_id")
	private UUID bookId;
	@Column(name="book_name")
	private String bookName;
}
