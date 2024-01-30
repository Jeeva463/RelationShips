package com.example.relationship.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.relationship.dto.AuthorDto;
import com.example.relationship.dto.BookDto;
import com.example.relationship.entity.Author;
import com.example.relationship.entity.Book;
import com.example.relationship.repository.AuthorRepository;

@Service
public class AuthorService {
	@Autowired
	AuthorRepository authorRepository;

	public Author saveDetails(AuthorDto authorDto) {
		Author obj=new Author();
		obj.setAuthorName(authorDto.getAuthorName());
		obj.setAuthorAge(authorDto.getAuthorAge());
		obj.setAuthorGender(authorDto.getAuthorGender());
		List<Book>total=new ArrayList<>();
		for(BookDto dto:authorDto.getBookDto()) {
			Book book = new Book();
			book.setBookName(dto.getBookName());
			total.add(book);
		}
		obj.setBook(total);
		authorRepository.save(obj);
		return obj;
	}

	public void saveDetails(Author author) {
		authorRepository.save(author);
		return;
	}

	public List<Author> getAll() {
		return authorRepository.findAll();
	}

	public List<AuthorDto> get() {
		List<AuthorDto>total=new ArrayList<>();
		List<Author> author=authorRepository.findAll();
		for(Author obj:author) {
			AuthorDto dto=new AuthorDto();
			dto.setAuthorId(obj.getAuthorId());
			dto.setAuthorName(obj.getAuthorName());
			dto.setAuthorAge(obj.getAuthorAge());
			dto.setAuthorGender(obj.getAuthorGender());
			List<BookDto>tl=new ArrayList<>();
			for(Book bk:obj.getBook()) {
				BookDto bd=new BookDto();
				bd.setBookId(bk.getBookId());
				bd.setBookName(bk.getBookName());
				tl.add(bd);
				}
			dto.setBookDto(tl);
			total.add(dto);
		}
		return total;
	}

	public void saveAll(List<Author> author) {
		authorRepository.saveAll(author);
		return;
	}

	public void postAll(List<AuthorDto> authorDto) {
		for(AuthorDto obj:authorDto) {
			Author author=new Author();
			author.setAuthorName(obj.getAuthorName());
			author.setAuthorAge(obj.getAuthorAge());
			author.setAuthorGender(obj.getAuthorGender());
			List<Book>total=new ArrayList<>();
			for(BookDto dto:obj.getBookDto()) {
				Book book=new Book();
				book.setBookName(dto.getBookName());
				total.add(book);
			}
			author.setBook(total);
			authorRepository.save(author);
			return;
		}
	}

	public Author getById(UUID id) {
		return authorRepository.findById(id).orElse(null);
		 
	}

	public AuthorDto getbyId(UUID id) {
		Optional<Author>author=authorRepository.findById(id);
		Author aut=author.get();
		AuthorDto dto=new AuthorDto();
		dto.setAuthorId(aut.getAuthorId());
		dto.setAuthorName(aut.getAuthorName());
		dto.setAuthorAge(aut.getAuthorAge());
		dto.setAuthorGender(aut.getAuthorGender());
		List<BookDto>total=new ArrayList<>();
		for(Book obj:aut.getBook()) {
			BookDto obj1=new BookDto();
			obj1.setBookId(obj.getBookId());
			obj1.setBookName(obj.getBookName());
			total.add(obj1);
		}
		dto.setBookDto(total);
		return dto;
	}

	public Optional<Author> getbyname(String authorName) {
		return authorRepository.findbyAuthorname(authorName);
	}

	public void putDetails(Author author, UUID id) {
		authorRepository.save(author);
		return;
	}

	public void putDetails(AuthorDto authorDto) {
		Optional<Author>obj=authorRepository.findById(authorDto.getAuthorId());
		Author author=obj.get();
		author.setAuthorName(authorDto.getAuthorName());
		author.setAuthorAge(authorDto.getAuthorAge());
		author.setAuthorGender(authorDto.getAuthorGender());
		List<Book>total=new ArrayList<>();
		for(BookDto dto:authorDto.getBookDto()) {
			Book book=new Book();
			book.setBookName(dto.getBookName());
			total.add(book);
		}
		author.setBook(total);
		authorRepository.save(author);
		return;
	}

	public void delete(Author author, UUID id) {
		authorRepository.deleteById(id);
	}

	public void deletedetails(AuthorDto authorDto) {
		Optional<Author>obj=authorRepository.findById(authorDto.getAuthorId());
		Author author=obj.get();
		AuthorDto dto=new AuthorDto();
		dto.setAuthorName(author.getAuthorName());
		dto.setAuthorAge(author.getAuthorAge());
		dto.setAuthorGender(author.getAuthorGender());
		List<BookDto>total=new ArrayList<>();
		for(Book book:author.getBook()){
			BookDto Dto=new BookDto();
			Dto.setBookName(book.getBookName());
			total.add(Dto);
		}
		dto.setBookDto(total);
		authorRepository.delete(author);
		}

	public AuthorDto getbyName(String authorname) {
		Optional<Author>obj=authorRepository.findbyAuthorname(authorname);
		Author obj1=obj.get();
		AuthorDto dto=new AuthorDto();
		dto.setAuthorId(obj1.getAuthorId());
		dto.setAuthorAge(obj1.getAuthorAge());
		dto.setAuthorName(obj1.getAuthorName());
		dto.setAuthorGender(obj1.getAuthorGender());
		List<BookDto> total=new ArrayList<>();
		for(Book book:obj1.getBook()) {
			BookDto Dto=new BookDto();
			Dto.setBookId(book.getBookId());
			Dto.setBookName(book.getBookName());
			total.add(Dto);
		}
		dto.setBookDto(total);
		return dto;
	}

	}


