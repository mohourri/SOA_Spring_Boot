package lib.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lib.entities.Author;
import lib.entities.Book;
import lib.repositories.AuthorRepository;
import lib.repositories.BookRepository;

@Service
public class LibraryService {

	@Autowired
	BookRepository br;
	
	@Autowired
	AuthorRepository ar;
	
	public List<?> getAllBooks(){
		return br.findAll();
	}
	
	public Book addBook(Book b) {
		Book book = br.save(b);
		return br.findById(book.getId()).orElse(book);
	}
	
	public Book getBookById(Long id) {
		return br.findById(id).orElse(null);
	}
	
	public Book updateBook(Book b) {
		return br.save(b);
	}
	
	public void deleteBook(Long id) {
		br.deleteById(id);
	}
	

	public List<?> getAllAuthors(){
		return ar.findAll();
	}
	

	public Author addAuthor(Author b) {
		return ar.save(b);
	}
	
	public Author getAuthorById(Long id) {
		return ar.findById(id).orElse(null);
	}
	
	public Author updateAuthor(Author a) {
		return ar.save(a);
	}
	
	public void deleteAuthor(Long id) {
		ar.deleteById(id);
	}
	
}
