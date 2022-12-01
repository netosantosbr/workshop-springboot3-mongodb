package com.udemy.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udemy.workshopmongo.domain.Post;
import com.udemy.workshopmongo.repository.PostRepository;
import com.udemy.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepository;
		
	public Post findById(String id) {
		return postRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!"));
	}
	
	public List<Post> findByTitle(String text) {
		return postRepository.findByTitleContainingIgnoreCase(text);
	}
}
