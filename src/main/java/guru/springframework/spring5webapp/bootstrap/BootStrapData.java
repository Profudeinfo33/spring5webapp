package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.repository.AuthorRepository;
import guru.springframework.spring5webapp.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author eric = new Author("Eric", "Evans");
        Book ddd= new Book("Domain Driven Desing", "123123");

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author petre = new Author("PETRE", "Dinu");
        Book javaspring= new Book("Spring Framework for Java", "07122022");

        petre.getBooks().add(javaspring);
        javaspring.getAuthors().add(petre);

        authorRepository.save(petre);
        bookRepository.save(javaspring);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of books is: "+ bookRepository.count());
        System.out.println("Number of authors is: "+authorRepository.count());

    }
}
