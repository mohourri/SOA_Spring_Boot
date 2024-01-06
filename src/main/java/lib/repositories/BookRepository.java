package lib.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import lib.entities.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
	public Optional<Book> findById(Long id);
	
	@SuppressWarnings("unchecked")
	public Book save(Book b);


}
