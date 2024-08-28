package com.recykal.Spring.Data.Rest.HATEOS.repo;

import com.recykal.Spring.Data.Rest.HATEOS.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "books")
public interface BookRepository extends JpaRepository<Book,Integer> {
    public List<Book> findByName(@Param("name") String name);
}
