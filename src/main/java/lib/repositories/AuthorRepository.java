package lib.repositories;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import lib.entities.Author;

public interface AuthorRepository extends JpaRepository<Author, Long>{
	public Optional<Author> findById(Long id);
	
	@SuppressWarnings("unchecked")
	public Author save(Author a);

}
