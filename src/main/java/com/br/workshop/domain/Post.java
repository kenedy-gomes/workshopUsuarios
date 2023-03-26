package com.br.workshop.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.br.workshop.DTO.AuthorDTO;
import com.br.workshop.DTO.CommentsDTO;


@Document(collection="Post")
public class Post implements Serializable {
private static final long serialVersionUID = 1L;

@Id
 private String id;
 private String title;
 private Date date;
 private String body;
 private AuthorDTO author;
 
 private List<CommentsDTO> comments = new ArrayList<>();
 
 public Post() {}



public Post(String id, String title, Date date, String body, AuthorDTO author ) {
	super();
	this.id = id;
	this.title = title;
	this.date = date;
	this.body = body;
	this.author = author;
 
}

public String getId() {
	return id;
}



public void setId(String id) {
	this.id = id;
}



public String getTitle() {
	return title;
}



public void setTitle(String title) {
	this.title = title;
}



public Date getDate() {
	return date;
}



public void setDate(Date date) {
	this.date = date;
}



public String getBody() {
	return body;
}



public void setBody(String body) {
	this.body = body;
}



public AuthorDTO getAuthor() {
	return author;
}



public void setAuthor(AuthorDTO author) {
	this.author = author;
}



public List<CommentsDTO> getComments() {
	return comments;
}

public void setComments(List<CommentsDTO> comments) {
	this.comments = comments;
}

@Override
public int hashCode() {
	return Objects.hash(id);
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Post other = (Post) obj;
	return Objects.equals(id, other.id);
}

@Override
public String toString() {
	return "Post [id=" + id + "]";
}

}
