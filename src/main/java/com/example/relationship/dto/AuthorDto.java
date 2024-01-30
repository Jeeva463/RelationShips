package com.example.relationship.dto;

import java.util.List;
import java.util.UUID;

import lombok.Data;

@Data
public class AuthorDto {
	private UUID authorId;
	private String authorName;
	private int authorAge;
	private String authorGender;
	private List<BookDto> bookDto;
}
