package com.mnb.service;

import com.mnb.dao.AuthorRepository;
import com.mnb.entity.Author;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthorServiceImpl implements AuthorService{
    final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }


    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Author findById(int theId) {
        Optional<Author> result = authorRepository.findById(theId);

        Author theAuthor = null;

        if (result.isPresent()) {
            theAuthor = result.get();
        }
        else {
            // we didn't find the book
            throw new RuntimeException("Did not find author id - " + theId);
        }

        return theAuthor;
    }

    @Override
    public void save(Author theAuthor) {
        authorRepository.save(theAuthor);
    }

    @Override
    public void deleteById(int theId) {
        authorRepository.deleteById(theId);
    }
}
