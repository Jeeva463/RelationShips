package com.example.relationship.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.relationship.dto.AuthorDto;
import com.example.relationship.entity.Author;
import com.example.relationship.service.AuthorService;

@RestController
public class AuthorController {
	@Autowired
	AuthorService authorService;
	
	@PostMapping("/post")
	public Author saveDetails(@RequestBody AuthorDto authorDto ) {
		return authorService.saveDetails(authorDto);
//		return "Success";
	}
	@PostMapping("/save")
	public String saveDetail(@RequestBody Author author) {
		authorService.saveDetails(author);
		return "Success";
	}
	@GetMapping("/getall")
	public List<Author> getAll() {
		return authorService.getAll();
	}
	@GetMapping("/get")
	public List<AuthorDto> get(){
		return authorService.get();
	}
	@PostMapping("/saveall")
	public String saveAll(@RequestBody List<Author> author) {
		authorService.saveAll(author);
		return "Success";
	}
	@PostMapping("/postall")
	public String postAll(@RequestBody List<AuthorDto> authorDto) {
		authorService.postAll(authorDto);
		return "Success";
	}
	@GetMapping("/getbyid")
	public Author getById(@RequestParam UUID id) {
		return authorService.getById(id);
	}
	@GetMapping("/getbyId")
	public AuthorDto getbyId(@RequestParam UUID id) {
		return authorService.getbyId(id);
	}
	
	@GetMapping("/getbyname")
	public Optional<Author> getbyname(@RequestParam ("name")  String authorName) {
		return authorService.getbyname(authorName);
	}
	@PutMapping("/put/{id}")
	public String putDetails(@RequestBody Author author,@PathVariable UUID id) {
		authorService.putDetails(author,id);
		return "Success";
	}
	@PutMapping("/putdetails")
	public String putDetails(@RequestBody AuthorDto authorDto) {
		authorService.putDetails(authorDto);
		return "Success";
	}
	@DeleteMapping("/delete/{id}")
	public void delete(@RequestBody Author author,@PathVariable UUID id) {
		authorService.delete(author,id);
	
	}
	@DeleteMapping("deletedetails")
	public void deleteDetails(@RequestBody AuthorDto authorDto) {
		authorService.deletedetails(authorDto);
		
	}
	@GetMapping("/getByname")
	public AuthorDto getbyName(@RequestParam String authorname) {
		return authorService.getbyName(authorname);
		
	}
}
