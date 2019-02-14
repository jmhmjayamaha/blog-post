package com.hksoft.springbootonetomany.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hksoft.springbootonetomany.exception.ResourceNotFoundException;
import com.hksoft.springbootonetomany.model.Comment;
import com.hksoft.springbootonetomany.repository.CommentRepository;
import com.hksoft.springbootonetomany.repository.PostRepository;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentRepository commentRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public Page<Comment> getAllComments(Long postId, Pageable pageable) {
		return commentRepository.findByPostId(postId, pageable);
	}

	@Override
	public Comment createComment(Long postId, Comment comment) {
		return postRepository.findById(postId).map(post -> {
			comment.setPost(post);
			return commentRepository.save(comment);
		}).orElseThrow(() -> new ResourceNotFoundException("PostId " + postId + " not found"));
	}

	@Override
	public Comment updateComment(Long postId, Long commentId, Comment commentUpdate) {		
		if(!postRepository.existsById(postId)) {
			throw new ResourceNotFoundException("PostId " + postId + " not found");
		}
		
		return commentRepository.findById(commentId).map(comment -> {
			comment.setComment(commentUpdate.getComment());
			return commentRepository.save(comment);
		}).orElseThrow(() -> new ResourceNotFoundException("commentId " + commentId + " not found"));
	}

	@Override
	public ResponseEntity<?> deleteComment(Long postId, Long commentId) {
		return commentRepository.findByIdAndPostId(commentId, postId).map(comment -> {
			commentRepository.delete(comment);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new ResourceNotFoundException("commentId " + commentId + " not found"));
	}

}
