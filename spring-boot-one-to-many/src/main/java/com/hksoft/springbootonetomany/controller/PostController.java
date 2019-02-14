package com.hksoft.springbootonetomany.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hksoft.springbootonetomany.model.Post;
import com.hksoft.springbootonetomany.service.PostService;

@RestController
@RequestMapping("/rest/posts")
public class PostController {

	@Autowired
	private PostService postSevice;
	
	@PostMapping
	@ResponseStatus(value=HttpStatus.CREATED)
	public Post createPost(@Valid @RequestBody Post post) {
		return postSevice.createPost(post);
	}
	
	@GetMapping
	public Page<Post> getAllPage(Pageable pageable) {
		return postSevice.getAllPost(pageable);
	}
	
	@PutMapping("/{postId}")
	public Post updatePost(@PathVariable Long postId, @Valid @RequestBody Post postUpdate) {
		return postSevice.updatePost(postId, postUpdate);
	}
	
	@DeleteMapping("/{postId}")
	public ResponseEntity<?> deletePost(@PathVariable Long postId) {
		return postSevice.deletePost(postId);
	}
}
