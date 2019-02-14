package com.hksoft.springbootonetomany.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hksoft.springbootonetomany.exception.ResourceNotFoundException;
import com.hksoft.springbootonetomany.model.Post;
import com.hksoft.springbootonetomany.repository.PostRepository;

@Service
public class PostServiceImpl implements PostService{

	@Autowired
	private PostRepository postRepository;
	
	@Override
	public Post createPost(Post post) {		
		return postRepository.save(post);
	}

	@Override
	public Page<Post> getAllPost(Pageable pageable) {
		return postRepository.findAll(pageable);
	}

	@Override
	public Post updatePost(Long postId, Post postUpdate) {
		return postRepository.findById(postId).map(post -> {
			post.setTitle(postUpdate.getTitle());
			post.setDescription(postUpdate.getDescription());
			post.setContent(postUpdate.getContent());
			
			return postRepository.save(post);
		}).orElseThrow(() -> new ResourceNotFoundException("PostId " + postId + " Not Found" ));
	}

	@Override
	public ResponseEntity<?> deletePost(Long postId) {
		return postRepository.findById(postId).map(post -> {
			postRepository.delete(post);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new ResourceNotFoundException("PostId " + postId + " Not Found" ));
	}

	
}
