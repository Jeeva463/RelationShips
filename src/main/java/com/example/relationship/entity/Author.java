package com.example.relationship.entity;

import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
@Table(name="author_details")
public class Author {
	@Id
	@GeneratedValue(generator="UUID")
	@Type(type="uuid-char")
	@Column(name="author_id")
	private UUID authorId;
	@Column(name="author_name")
	private String authorName;
	@Column(name="author_age")
	private int authorAge;
	@Column(name="author_gender")
	private String authorGender;
	@OneToMany(targetEntity = Book.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "author_details_id", referencedColumnName = "author_id")
	private List<Book> book;

}
