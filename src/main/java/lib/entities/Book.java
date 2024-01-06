package lib.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity @Getter @Setter @ToString @AllArgsConstructor  @NoArgsConstructor
public class Book {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String isbn;
	private String nom;
	@ManyToOne
	@JoinColumn(name = "id_author")
	private Author author;
}
