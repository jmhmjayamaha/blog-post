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

import com.hksoft.springbootonetomany.model.Comment;
import com.hksoft.springbootonetomany.service.CommentService;

@RestController
@RequestMapping("/rest/posts/{postId}/comments")
public class CommentController {

	@Autowired
	private CommentService commentService;
	
	@GetMapping()
	public Page<Comment> getAllComments(@PathVariable (value="postId") Long postId, Pageable pageable) {
		return commentService.getAllComments(postId, pageable);
	}
	
	@PostMapping()
	@ResponseStatus( value= HttpStatus.CREATED)
	public Comment createComment(@PathVariable (value="postId") Long postId, @RequestBody Comment comment) {
		return commentService.createComment(postId, comment);
	}
	
	@PutMapping("/{commentId}")
	public Comment updateComment(@PathVariable ( value= "postId") Long postId, @PathVariable ( value="commentId") Long commentId
			, @Valid @RequestBody Comment commentUpdate) {
		return commentService.updateComment(postId, commentId, commentUpdate);
	}
	
	@DeleteMapping("/{commentId}")
	public ResponseEntity<?> deleteComment(@PathVariable ( value= "postId") Long postId, @PathVariable ( value="commentId") Long commentId) {
		return commentService.deleteComment(postId, commentId);
	}
	
}
