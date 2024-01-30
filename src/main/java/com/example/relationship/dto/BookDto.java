package com.example.relationship.dto;

import java.util.UUID;

import lombok.Data;

@Data
public class BookDto {
	private UUID bookId;
	private String bookName;

}
