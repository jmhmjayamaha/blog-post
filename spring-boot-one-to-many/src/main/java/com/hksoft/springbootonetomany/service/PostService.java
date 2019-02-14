package com.hksoft.springbootonetomany.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hksoft.springbootonetomany.model.Post;

public interface PostService {

	Post createPost(Post post);
	Page<Post> getAllPost(Pageable pageable);
	Post updatePost(Long id, Post post);
	ResponseEntity<?> deletePost(Long id);
	
}
