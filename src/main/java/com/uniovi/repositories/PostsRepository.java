package com.uniovi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.uniovi.entities.Post;
import com.uniovi.entities.User;

public interface PostsRepository extends CrudRepository<Post, Long>{

	@Query("SELECT p FROM Post p WHERE p.author = ?1")
	List<Post> getAllByAuthor(User author);
	
}
