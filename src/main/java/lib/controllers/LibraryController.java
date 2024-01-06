package lib.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import lib.entities.Author;
import lib.entities.Book;
import lib.service.LibraryService;

@RestController
public class LibraryController {
	@Autowired
	private LibraryService ls ;
	
	@GetMapping("/books")
	public ResponseEntity<?> getAllBooks(){
		return ResponseEntity.status(200).body(ls.getAllBooks());
	}
	
	@GetMapping("/authors")
	public ResponseEntity<?> getAllAuthors(){
		List<?> res = ls.getAllAuthors();
		return ResponseEntity.status(200).body(res);
	}
	
	@GetMapping("/books/{id}")
	public ResponseEntity<?> getBookById(@PathVariable Long id){
		ResponseEntity<?> re = null;
		try {
			Book b = ls.getBookById(id);
			if(b==null) {
				re = ResponseEntity.status(404).body("The book that you're looking for is not found !");
			}
			
			re = ResponseEntity.status(200).body(b);
				
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}

	@GetMapping("/authors/{id}")
	public ResponseEntity<?> getAuthorById(@PathVariable Long id){
		ResponseEntity<?> re = null;
		try {
			Author a = ls.getAuthorById(id);
			if(a==null) {
				re = ResponseEntity.status(404).body("The author that you're looking for is not found !");
			}
			
			re = ResponseEntity.status(200).body(a);
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}
	
	@PostMapping("/books")
	public ResponseEntity<?> addBook(@RequestBody Book bk) {
	    try {
	        if (bk == null) {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid book data received!");
	        }
	        Book addedBook = ls.addBook(bk);
	        return ResponseEntity.status(HttpStatus.CREATED).body(addedBook);
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while adding the book.");
	    }
	}


	@PostMapping("/authors")
	public ResponseEntity<?> addAuthor(@RequestBody Author a) {
	    try {
	        if (a == null) {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid author data received!");
	        }
	        Author AddedAuthor = ls.addAuthor(a);
	        return ResponseEntity.status(HttpStatus.CREATED).body(AddedAuthor);
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while adding the author.");
	    }
	}

	
	@PutMapping("/authors")
	public ResponseEntity<?> updateAuthor(@RequestBody Author a) {
	    try {
	        if (a == null) {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cannot receive the author!");
	        }
	        Author updatedAuthor = ls.updateAuthor(a);
	        return ResponseEntity.status(HttpStatus.OK).body(updatedAuthor);
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while updating the author.");
	    }
	}

	
	@PutMapping("/books")
	public ResponseEntity<?> updateBook(@RequestBody Book a) {
	    try {
	        if (a == null) {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cannot receive the author!");
	        }
	        Book updatedBook = ls.updateBook(a);
	        return ResponseEntity.status(HttpStatus.OK).body(updatedBook);
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while updating the author.");
	    }
	}

	
	@DeleteMapping("/books/{id}")
	public ResponseEntity<?> deleteBook(@PathVariable Long id) {
	    try {
	        if (id == null) {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid book ID!");
	        }
	        ls.deleteBook(id);
	        return ResponseEntity.status(HttpStatus.OK).body("Book deleted successfully");
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while deleting the book.");
	    }
	}



	@DeleteMapping("/authors/{id}")
	public ResponseEntity<?> deleteAuthor(@PathVariable Long id) {
	    try {
	        if (id == null) {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid author ID!");
	        }
	        ls.deleteAuthor(id);
	        return ResponseEntity.status(HttpStatus.OK).body("Author deleted successfully");
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while deleting the author.");
	    }
	}

}
